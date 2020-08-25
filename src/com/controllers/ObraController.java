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

import com.IDAO.IObraDAO;
import com.modelo.Obra;

@Path("/api/obras")
public class ObraController {

	@Inject
	private IObraDAO obraDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarObras() {
		List<Obra> obra = obraDAO.listar();
		return Response.ok().entity(obra).build();
	}

	@GET
	@Path("{idObra}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarObra(@PathParam("idObra") Long idObra) {
		Obra obra = obraDAO.encontrar(idObra);
		if (obra != null)
			return Response.ok().entity(obra).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("No se encontro la obra").build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearObra(Obra obra) {
		try
		{
			if (!obraDAO.existe(obra)) {
				obraDAO.guardar(obra);
				return Response.ok().entity(obra).build();
			} else {
				return Response.status(Response.Status.CONFLICT).entity("La obra ya existe").build();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo guardar la obra").build();
		}
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editarObra(Obra obra) {
		try
		{
			Obra esp = obraDAO.encontrar(obra.getId());
			if (esp != null) {
				obraDAO.actualizar(obra);
				return Response.ok().entity(obra).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).entity("La obra no existe").build();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo actualizar la obra").build();
		}
	}

	@DELETE
	@Path("{idObra}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarObra(@PathParam("idObra") Long idObra) {
		try
		{
			Obra esp = obraDAO.encontrar(idObra);
			if (esp != null) {
				obraDAO.eliminar(esp);
				return Response.noContent().build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).entity("La obra no existe").build();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo eliminar la obra").build();
		}
	}
	
}
