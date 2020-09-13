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

import com.IDAO.IEdicionDAO;
import com.modelo.Edicion;

@Path("/api/ediciones")
public class EdicionController {

	@Inject
	private IEdicionDAO edicionDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarEdiciones() {
		List<Edicion> edicion = edicionDAO.listar();
		return Response.ok().entity(edicion).build();
	}

	@GET
	@Path("{idEdicion}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarEdicion(@PathParam("idEdicion") Long idEdicion) {
		Edicion edicion = edicionDAO.encontrar(idEdicion);
		if (edicion != null)
			return Response.ok().entity(edicion).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("No se encontro la edicion").build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearEdicion(Edicion edicion) {
		try
		{
			if (edicion.getDesde().isAfter(edicion.getHasta()))
				return Response.status(Response.Status.BAD_REQUEST).entity("Fecha desde debe ser menor que fecha hasta").build();
			if (!edicionDAO.existe(edicion) && edicionDAO.esValida(edicion)) {
				edicionDAO.guardar(edicion);
				return Response.ok().entity(edicion).build();
			} else {
				return Response.status(Response.Status.CONFLICT).entity("La edicion ya existe").build();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo guardar la edicion").build();
		}
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editarEdicion(Edicion edicion) {
		try
		{
			if (edicion.getDesde().isAfter(edicion.getHasta()))
				return Response.status(Response.Status.BAD_REQUEST).entity("Fecha desde debe ser menor que fecha hasta").build();
			Edicion ed = edicionDAO.encontrar(edicion.getId());
			if (ed == null)
				return Response.status(Response.Status.NOT_FOUND).entity("La edicion no existe").build();
			if (edicionDAO.esValidaUpdate(edicion)) {
				edicionDAO.actualizar(edicion);
				return Response.ok().entity(edicion).build();
			} else {
				return Response.status(Response.Status.BAD_REQUEST).entity("La edicion no es valida").build();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo actualizar la edicion").build();
		}
	}

	@DELETE
	@Path("{idEdicion}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarEdicion(@PathParam("idEdicion") Long idEdicion) {
		try
		{
			Edicion ed = edicionDAO.encontrar(idEdicion);
			if (ed != null) {
				edicionDAO.eliminar(ed);
				return Response.noContent().build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).entity("La edicion no existe").build();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo eliminar la edicion").build();
		}
	}

}
