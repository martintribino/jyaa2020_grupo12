package com.controllers;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.IDAO.IActividadDAO;
import com.IDAO.INotificacionDAO;
import com.IDAO.IUsuarioDAO;
import com.modelo.Actividad;
import com.modelo.Notificacion;
import com.modelo.Usuario;
import com.security.JWToken;

@Path("/api/notificaciones")
public class NotificacionController {

	@Inject
	private IActividadDAO actdao;
	@Inject
	private INotificacionDAO notdao;
	@Inject
	private IUsuarioDAO usuDAO;

	@POST
	@Path("{idActividad}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearUsuario(
			@PathParam("idActividad") Long idActividad,
			Notificacion not,
			@Context HttpServletRequest httpServletRequest,
			@Context HttpServletResponse httpServletResponse
			) {
		try
		{
			Actividad act = actdao.encontrar(idActividad);
			if (act != null) {
	            String token = JWToken.getToken(httpServletRequest);
		        String usrnmOwner = JWToken.parseToken(token);
		        Usuario usuario = usuDAO.encontrarPorNombre(usrnmOwner);
                if(usuario != null) {
                    if(!usuario.getRol().esOperador() && !usuario.getRol().esAdministrador())
        				return Response.status(Response.Status.UNAUTHORIZED).entity("No tiene permisos").build();
    				Notificacion notificacion = new Notificacion(
    						not.getNombre(),
    						not.getTipo(),
    						not.getEstado(),
    						act
    				);
    				notdao.guardar(notificacion);
    				return Response.ok().entity(notificacion).build();
                } else {
        			return Response.status(Response.Status.NOT_FOUND).entity("No se encontro el usuario").build();
                }
			} else {
				return Response.status(Response.Status.CONFLICT).entity("La actividad existe").build();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo notificar la actividad").build();
		}
	}

}
