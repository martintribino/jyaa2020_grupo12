package com.controllers;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import com.IDAO.IEtiquetaDAO;
import com.IDAO.IUsuarioDAO;
import com.modelo.Etiqueta;
import com.modelo.Usuario;
import com.security.JWToken;

@Path("/api/etiquetas")
public class EtiquetaController {

	@Inject
	private IEtiquetaDAO etiDAO;
	@Inject
	private IUsuarioDAO usuDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarEtiquetas() {
		List<Etiqueta> etiquetas = etiDAO.listar();
		return Response.ok().entity(etiquetas).build();
	}

	@GET
	@Path("{etiqueta}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarEtiqueta(@PathParam("etiqueta") String etiquetaStr) {
		Etiqueta etiqueta = etiDAO.etiquetaPorNombre(etiquetaStr);
		if (etiqueta != null)
			return Response.ok().entity(etiqueta).build();
		else
			return Response.status(Response.Status.NOT_FOUND).entity("No se encontro la etiqueta").build();
	}

	@GET
	@Path("{etiqueta}/meinteresa")
	@Produces(MediaType.APPLICATION_JSON)
	public Response meInteresaObra(@PathParam("etiqueta") String etiquetaStr,
			@Context HttpServletRequest httpServletRequest,
			@Context HttpServletResponse httpServletResponse
			) {
		Etiqueta etiqueta = etiDAO.etiquetaPorNombre(etiquetaStr);
		if (etiqueta != null) {
            String token = JWToken.getToken(httpServletRequest);
            try
            {
                Usuario usuario = usuDAO.encontrar(Long.valueOf(token));
                if(usuario != null) {
                	usuario.addEtiquetaFav(etiqueta);
                	usuDAO.actualizar(usuario);
                	return Response.ok().entity("Etiqueta agregada para usuario").build();
                } else {
        			return Response.status(Response.Status.NOT_FOUND).entity("No se encontro el usuario").build();
                }
            }
            catch (Exception ex)
            {
            	throw ex;
            }
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("No se encontro la etiqueta").build();
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearEtiqueta(Etiqueta etiqueta) {
		try
		{
			if (!etiDAO.existe(etiqueta)) {
				etiDAO.guardar(etiqueta);
				return Response.ok().entity(etiqueta).build();
			} else {
				return Response.status(Response.Status.CONFLICT).entity("La etiqueta ya existe").build();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo guardar la etiqueta").build();
		}
	}

	@PUT
	@Path("{etiqueta}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editarActividad(@PathParam("etiqueta") String etiquetaStr, Etiqueta etiquetaParam) {
		try
		{
			Etiqueta etiqueta = etiDAO.etiquetaPorNombre(etiquetaStr);
			if (etiqueta != null) {
				etiquetaParam.setId(etiqueta.getId());
				etiDAO.actualizar(etiquetaParam);
				return Response.ok().entity(etiquetaParam).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).entity("La etiqueta no existe").build();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo actualizar la etiqueta").build();
		}
	}

	@DELETE
	@Path("{etiqueta}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarEtiqueta(@PathParam("etiqueta") String etiquetaStr) {
		try
		{
			Etiqueta etiqueta = etiDAO.etiquetaPorNombre(etiquetaStr);
			if (etiqueta != null) {
				etiDAO.eliminar(etiqueta);
				return Response.ok().entity(etiqueta).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).entity("La etiqueta no existe").build();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo actualizar la etiqueta").build();
		}
	}

}
