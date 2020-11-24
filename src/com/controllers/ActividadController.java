package com.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.IDAO.IActividadDAO;
import com.IDAO.IUsuarioDAO;
import com.modelo.Actividad;
import com.modelo.Edicion;
import com.modelo.Usuario;
import com.security.JWToken;

@Path("/api/actividades")
public class ActividadController {

	@Inject
	private IUsuarioDAO usuDAO;
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
	@Consumes(MediaType.APPLICATION_JSON)
	public Response listarActividad(@PathParam("idActividad") Long idActividad) {
		try
		{
			Actividad actividad = actdao.encontrar(idActividad);
			if (actividad != null)
				return Response.ok(actividad, MediaType.APPLICATION_JSON).build();
			else
				return Response.status(Response.Status.NOT_FOUND).entity("No se encontro la actividad").build();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo retornar la actividad").build();
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearUsuario(Actividad actividad,
			@Context HttpServletRequest httpServletRequest) {
		try
		{
            String token = JWToken.getToken(httpServletRequest);
	        String usrnmOwner = JWToken.parseToken(token);
	        Usuario usuario = usuDAO.encontrarPorNombre(usrnmOwner);
        	if (usuario == null || (!usuario.getRol().esParticipante() && !usuario.getRol().esAdministrador()))
				return Response.status(Response.Status.UNAUTHORIZED).entity("No tiene permisos").build();
			if (actividad.getDesde().isAfter(actividad.getHasta()))
				return Response.status(Response.Status.BAD_REQUEST).entity("Fecha desde debe ser menor que fecha hasta").build();
			if (actdao.existe(actividad)) 
				return Response.status(Response.Status.CONFLICT).entity("La actividad ya existe").build();
			if (actividad.getEspacio() != null && actividad.getEntradasVendidas() > actividad.getEspacio().getCapacidad()) 
				return Response.status(Response.Status.BAD_REQUEST).entity("Entradas vendidas no pueden ser mayor que la capacidad del espacio").build();
			if (actdao.esValida(actividad)) {
				actdao.actualizar(actividad);
				return Response.ok().entity(actividad).build();
			} else {
				return Response.status(Response.Status.CONFLICT).entity("La actividad no es válida").build();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo guardar la actividad").build();
		}
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editarActividad(Actividad actividad,
			@Context HttpServletRequest httpServletRequest) {
			try
			{
	            String token = JWToken.getToken(httpServletRequest);
		        String usrnmOwner = JWToken.parseToken(token);
		        Usuario usuario = usuDAO.encontrarPorNombre(usrnmOwner);
	        	if (usuario == null || (!usuario.getRol().esParticipante() && !usuario.getRol().esAdministrador()))
					return Response.status(Response.Status.UNAUTHORIZED).entity("No tiene permisos").build();
				if (actividad.getDesde().isAfter(actividad.getHasta()))
					return Response.status(Response.Status.BAD_REQUEST).entity("Fecha desde debe ser menor que fecha hasta").build();
				Edicion ed = actividad.getEdicion();
				if (actividad.getDesde().isBefore(ed.getDesde()) || actividad.getHasta().isAfter(ed.getHasta()))
					return Response.status(Response.Status.BAD_REQUEST).entity("Las fechas deben coincidir con la edicion").build();
				Actividad act = actdao.encontrar(actividad.getId());
				if (act == null)
					return Response.status(Response.Status.NOT_FOUND).entity("La actividad no existe").build();
				if (actividad.getEspacio() != null && actividad.getEntradasVendidas() > actividad.getEspacio().getCapacidad()) 
					return Response.status(Response.Status.BAD_REQUEST).entity("Entradas vendidas no pueden ser mayor que la capacidad del espacio").build();
				if (actdao.esValidaUpdate(actividad)) {
					actdao.actualizar(actividad);
					return Response.ok().entity(actividad).build();
				} else {
					return Response.status(Response.Status.BAD_REQUEST).entity("La actividad no es válida").build();
				}
			}
			catch(Exception ex)
			{
				System.out.println(ex);
				return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo actualizar la actividad").build();
			}
	}

	@DELETE
	@Path("{idActividad}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarUsuario(@PathParam("idActividad") Long idActividad,
			@Context HttpServletRequest httpServletRequest) {
		try
		{
            String token = JWToken.getToken(httpServletRequest);
	        String usrnmOwner = JWToken.parseToken(token);
	        Usuario usuario = usuDAO.encontrarPorNombre(usrnmOwner);
        	if (usuario == null || (!usuario.getRol().esParticipante() && !usuario.getRol().esAdministrador()))
				return Response.status(Response.Status.UNAUTHORIZED).entity("No tiene permisos").build();
    		Actividad actividad = actdao.encontrar(idActividad);
    		if (actividad != null) {
    			actdao.eliminar(actividad);
    			return Response.noContent().build();
    		} else {
    			return Response.status(Response.Status.NOT_FOUND).entity("La actividad no existe").build();
    		}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo eliminar la actividad").build();
		}
	}

}
