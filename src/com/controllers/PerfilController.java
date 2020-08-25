package com.controllers;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.IDAO.IUsuarioDAO;
import com.dto.responses.PerfilDTOResponse;
import com.modelo.Usuario;

@Path("/api/perfil")
public class PerfilController {

	@Inject
	private IUsuarioDAO udao;

	@GET
	@Path("{idUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarUsuario(@PathParam("idUsuario") Long idUsuario) {
		try
		{
			Usuario usuario = udao.encontrar(idUsuario);
			if (usuario != null) {
				return Response.status(Response.Status.OK).entity(usuario).build();
			} else
				return Response.status(Response.Status.NOT_FOUND).entity("No se encontro el usuario").build();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se encontro el usuario").build();
		}
	}
}
