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

import com.IDAO.IRolDAO;
import com.IDAO.IUsuarioDAO;
import com.modelo.Rol;
import com.modelo.Usuario;
import com.security.Encrypt;
import com.security.JWToken;

@Path("/api/usuarios")
public class UsuarioController {

	@Inject
	private IUsuarioDAO udao;
	@Inject
	private IRolDAO roldao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarUsuarios() {
		List<Usuario> usuarios = udao.listar();
		if (usuarios.isEmpty())
			return Response.ok().entity(usuarios).build(); 
		else
			return Response.ok().entity(usuarios).build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearUsuario(@HeaderParam(JWToken.AUTHORIZATION_HEADER) String rawToken, Usuario usuario) {
		try
		{
			if (!udao.existe(usuario)) {
		        String token = JWToken.getToken(rawToken);
		        String usrnmOwner = JWToken.parseToken(token);
		        Usuario own = udao.encontrarPorNombre(usrnmOwner);
		        if(own == null || !own.esAdministrador())
					return Response.status(Response.Status.UNAUTHORIZED).entity("No tiene autorizacion.").build();
				if (usuario.getRol() == null || usuario.getRol().getTipo() == null) {
					return Response.status(Response.Status.BAD_REQUEST).entity("Un usuario debe poser un rol.").build();
				}
				Rol rol = roldao.encontrarPorTipo(usuario.getRol().getTipo());
				if (rol == null)
					return Response.status(Response.Status.BAD_REQUEST).entity("No existe el rol").build();
				usuario.setRol(rol);
				String pass = Encrypt.encode(usuario.getClave());
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
		Usuario usu = udao.encontrar(usuario.getId());
		if (usu != null) {
			try
			{
		        String token = JWToken.getToken(rawToken);
		        String usrnmOwner = JWToken.parseToken(token);
		        Usuario own = udao.encontrarPorNombre(usrnmOwner);
		        if(own == null || (!own.esAdministrador() && own.getId() != usu.getId()))
					return Response.status(Response.Status.UNAUTHORIZED).entity("No tiene autorizacion.").build();
				String pass = Encrypt.encode(usuario.getClave());
				usuario.setClave(pass);
				if (usuario.getRol() == null || usuario.getRol().getTipo() == null) {
					return Response.status(Response.Status.BAD_REQUEST).entity("Un usuario debe poser un rol.").build();
				}
				Rol rol = roldao.encontrarPorTipo(usuario.getRol().getTipo());
				if (rol == null)
					return Response.status(Response.Status.BAD_REQUEST).entity("No existe el rol").build();
				usuario.setRol(rol);
				udao.actualizar(usuario);
				return Response.ok().entity(usuario).build();
			}
			catch(Exception ex)
			{
				System.out.println(ex);
				return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo actualizar el usuario").build();
			}
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("El usuario no existe").build();
		}
	}

	@DELETE
	@Path("{idUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarUsuario(@HeaderParam(JWToken.AUTHORIZATION_HEADER) String rawToken, @PathParam("idUsuario") Long idUsuario) {
		Usuario usu = udao.encontrar(idUsuario);
		if (usu != null) {
			try
			{
		        String token = JWToken.getToken(rawToken);
		        String usrnmOwner = JWToken.parseToken(token);
		        Usuario own = udao.encontrarPorNombre(usrnmOwner);
		        if(own == null || !own.esAdministrador())
					return Response.status(Response.Status.UNAUTHORIZED).entity("No tiene autorizacion.").build();
		        if(own.getId() == usu.getId())
					return Response.status(Response.Status.UNAUTHORIZED).entity("No puede borrar su perfil.").build();
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
