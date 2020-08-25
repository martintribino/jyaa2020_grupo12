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

import com.IDAO.IEspacioDAO;
import com.modelo.Espacio;

@Path("/api/espacios")
public class EspacioController {

	@Inject
	private IEspacioDAO espacioDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarEspacios() {
		List<Espacio> espacio = espacioDAO.listar();
		return Response.ok().entity(espacio).build();
	}

	@GET
	@Path("{idEspacio}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarEspacio(@PathParam("idEspacio") Long idEspacio) {
		Espacio espacio = espacioDAO.encontrar(idEspacio);
		if (espacio != null)
			return Response.ok().entity(espacio).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("No se encontro el espacio").build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearEspacio(Espacio espacio) {
		try
		{
			if (!espacioDAO.existe(espacio)) {
				espacioDAO.guardar(espacio);
				return Response.ok().entity(espacio).build();
			} else {
				return Response.status(Response.Status.CONFLICT).entity("El espacio ya existe").build();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo guardar el espacio").build();
		}
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editarEspacio(Espacio espacio) {
		try
		{
			Espacio esp = espacioDAO.encontrar(espacio.getId());
			if (esp != null) {
				espacioDAO.actualizar(espacio);
				return Response.ok().entity(espacio).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).entity("El espacio no existe").build();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo actualizar el espacio").build();
		}
	}

	@DELETE
	@Path("{idEspacio}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarEspacio(@PathParam("idEspacio") Long idEspacio) {
		try
		{
			Espacio esp = espacioDAO.encontrar(idEspacio);
			if (esp != null) {
				espacioDAO.eliminar(esp);
				return Response.noContent().build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).entity("El Espacio no existe").build();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo eliminar el Espacio").build();
		}
	}

}
