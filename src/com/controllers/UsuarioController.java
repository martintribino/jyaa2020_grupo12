package com.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

import com.IDAO.IRolDAO;
import com.IDAO.IUsuarioDAO;
import com.config.PersistenciaBinder;
import com.modelo.Rol;
import com.modelo.Usuario;
import com.security.Encrypt;
import com.security.JWToken;

@Path("/api/usuarios")
public class UsuarioController {

	//@Inject
	//private IUsuarioDAO udao;
	//@Inject
	//private IRolDAO roldao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarUsuarios() {
		ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();
		ServiceLocatorUtilities.enablePerThreadScope(locator);
		ServiceLocatorUtilities.bind(locator, new PersistenciaBinder());
		//usuarios
		IUsuarioDAO udao = locator.getService(IUsuarioDAO.class);
		List<Usuario> usuarios = udao.listar();
		if (usuarios.isEmpty())
			return Response.ok().entity(usuarios).build(); 
		else
			return Response.ok().entity(usuarios).build();
	}

	@GET
	@Path("{userName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarUsuario(@PathParam("userName") String userName) {
		ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();
		ServiceLocatorUtilities.enablePerThreadScope(locator);
		ServiceLocatorUtilities.bind(locator, new PersistenciaBinder());
		//usuarios
		IUsuarioDAO udao = locator.getService(IUsuarioDAO.class);
		Usuario usuario = udao.encontrarPorNombre(userName);
		if (usuario != null)
			return Response.ok().entity(usuario).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("No se encontro el usuario").build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearUsuario(Usuario usuario) {
		ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();
		ServiceLocatorUtilities.enablePerThreadScope(locator);
		ServiceLocatorUtilities.bind(locator, new PersistenciaBinder());
		//usuarios
		IUsuarioDAO udao = locator.getService(IUsuarioDAO.class);
		IRolDAO roldao = locator.getService(IRolDAO.class);
		try
		{
			if (!udao.existe(usuario)) {
				Rol rol = roldao.encontrarPorTipo(usuario.getRol().getTipo());
				if (rol == null)
					rol = roldao.encontrarPorTipo(Rol.Tipos.VISITANTE);
				String pass = Encrypt.encode(usuario.getClave());
				usuario.setRol(rol);
				usuario.setClave(pass);
				udao.actualizar(usuario);
				return Response.ok().entity(usuario).build();
			} else {
				return Response.status(Response.Status.CONFLICT).entity("El usuario ya existe").build();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo guardar el usuario").build();
		}
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editarUsuario(@HeaderParam(JWToken.AUTHORIZATION_HEADER) String rawToken, Usuario usuario) {
		ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();
		ServiceLocatorUtilities.enablePerThreadScope(locator);
		ServiceLocatorUtilities.bind(locator, new PersistenciaBinder());
		//usuarios
		IUsuarioDAO udao = locator.getService(IUsuarioDAO.class);
		IRolDAO roldao = locator.getService(IRolDAO.class);
		Usuario usu = udao.encontrarPorNombre(usuario.getNombreUsuario());
		if (usu != null) {
			try
			{
		        String token = JWToken.getToken(rawToken);
		        String usrnmOwner = JWToken.parseToken(token);
		        Usuario own = udao.encontrarPorNombre(usrnmOwner);
		        if(own == null || (!own.esAdministrador() && own.getId() != usu.getId()))
					return Response.status(Response.Status.UNAUTHORIZED).entity("No tiene autorizacion.").build();
				String pass = usu.getClave();
				if(usuario.getClave() != null)
					pass = Encrypt.encode(usuario.getClave());
				usuario.setClave(pass);
				if (usuario.getRol() == null || usuario.getRol().getTipo() == null)
					usuario.setRol(usu.getRol());
				else {
					Rol rol = roldao.encontrarPorTipo(usuario.getRol().getTipo());
					usuario.setRol(rol);
				}
				if (usuario.getDireccion() == null)
					usuario.setDireccion(usu.getDireccion());
				usuario.setId(usu.getId());
				udao.actualizar(usuario);
				return Response.ok().entity(usuario).build();
			}
			catch(Exception ex)
			{
				//throw ex;
				//System.out.println(ex);
				return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo actualizar el usuario").build();
			}
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("El usuario no existe").build();
		}
	}

	@DELETE
	@Path("{userName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarUsuario(@PathParam("userName") String userName) {
		ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();
		ServiceLocatorUtilities.enablePerThreadScope(locator);
		ServiceLocatorUtilities.bind(locator, new PersistenciaBinder());
		//usuarios
		IUsuarioDAO udao = locator.getService(IUsuarioDAO.class);
		Usuario usu = udao.encontrarPorNombre(userName);
		if (usu != null) {
			try
			{
				udao.eliminar(usu);
				return Response.noContent().build();
			}
			catch(Exception ex)
			{
				System.out.println(ex);
				return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo eliminar el usuario").build();
			}
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("El usuario no existe").build();
		}
	}

}
