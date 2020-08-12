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

import com.IDAO.IActividadDAO;
import com.modelo.Actividad;

@Path("/api/actividades")
public class ActividadController {

	@Inject
	private IActividadDAO actdao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarActividades() {
		List<Actividad> actividades = actdao.listar();
		if (actividades.isEmpty())
			return Response.noContent().build();
		else
			return Response.ok().entity(actividades).build();
	}

	@GET
	@Path("{idActividad}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarActividad(@PathParam("idActividad") Long idActividad) {
		Actividad actividad = actdao.encontrar(idActividad);
		if (actividad != null)
			return Response.ok().entity(actividad).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("No se encontro la actividad").build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearUsuario(Actividad actividad) {
		try
		{
			if (!actdao.existe(actividad) && actdao.esValida(actividad)) {
				actdao.guardar(actividad);
				return Response.ok().entity(actividad).build();
			} else {
				return Response.status(Response.Status.CONFLICT).entity("La actividad ya existe").build();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo guardar la actividad").build();
		}
	}

	@PUT
	@Path("{idActividad}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editarActividad(@PathParam("idActividad") Long idActividad, Actividad actividad) {
		Actividad act = actdao.encontrar(idActividad);
		if (act != null) {
			try
			{
				if (actdao.esValida(actividad)) {
					actividad.setId(act.getId());
					actdao.actualizar(actividad);
					return Response.ok().entity(actividad).build();
				} else {
					return Response.status(Response.Status.BAD_REQUEST).entity("La actividad no es valida").build();
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex);
				return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo actualizar la actividad").build();
			}
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("La actividad no existe").build();
		}
	}

	@DELETE
	@Path("{idActividad}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarUsuario(@PathParam("idActividad") Long idActividad) {
		Actividad actividad = actdao.encontrar(idActividad);
		if (actividad != null) {
			try
			{
				actdao.eliminar(actividad);
				return Response.noContent().build();
			}
			catch(Exception ex)
			{
				System.out.println(ex);
				return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo eliminar la actividad").build();
			}
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("La actividad no existe").build();
		}
	}

}
