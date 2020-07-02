package com.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
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

@Path("/usuarios")
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
			return Response.noContent().build(); 
		else
			return Response.ok().entity(usuarios).build();
	}

	@GET
	@Path("{idUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarUsuario(@PathParam("idUsuario") Long idUsuario) {
		Usuario usuario = udao.encontrar(idUsuario);
		if (usuario != null)
			return Response.ok().entity(usuario).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("No se encontro el usuario").build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearUsuario(Usuario usuario) {
		try
		{
			if (!udao.existe(usuario)) {
				Rol rol = roldao.encontrarPorTipo(usuario.getRol().getTipo());
				if (rol == null)
					rol = roldao.encontrarPorTipo(Rol.Tipos.VISITANTE);
				usuario.setRol(rol);
				udao.guardar(usuario);
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
	@Path("{idUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editarUsuario(@PathParam("idUsuario") Long idUsuario, Usuario usuario) {
		Usuario usu = udao.encontrar(idUsuario);
		if (usu != null) {
			try
			{
				if (usuario.getRol() == null)
					usuario.setRol(usu.getRol());
				if (usuario.getDireccion() == null)
					usuario.setDireccion(usu.getDireccion());
				usuario.setId(usu.getId());
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
	public Response eliminarUsuario(@PathParam("idUsuario") Long idUsuario) {
		Usuario usu = udao.encontrar(idUsuario);
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
