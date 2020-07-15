package com.controllers;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.IDAO.IActividadDAO;
import com.IDAO.IAsistenciaDAO;
import com.IDAO.IObraDAO;
import com.IDAO.IUsuarioDAO;
import com.IDAO.IValoracionDAO;
import com.modelo.Actividad;
import com.modelo.Asistencia;
import com.modelo.Obra;
import com.modelo.Usuario;
import com.modelo.Valoracion;
import com.security.JWToken;

@Path("/actividades/obras")
public class ObraController {

	@Inject
	private IObraDAO obraDAO;
	@Inject
	private IUsuarioDAO usuDAO;
	@Inject
	private IAsistenciaDAO asistDAO;
	@Inject
	private IValoracionDAO valDAO;
	@Inject
	private IActividadDAO actDAO;

	@POST
	@Path("{idObra}/meinteresa")
	@Produces(MediaType.APPLICATION_JSON)
	public Response meInteresaObra(@PathParam("idObra") Long idObra,
			@Context HttpServletRequest httpServletRequest,
			@Context HttpServletResponse httpServletResponse
			) {
		Obra obra = obraDAO.encontrar(idObra);
		if (obra != null) {
            String token = JWToken.getToken(httpServletRequest);
            try
            {
                Usuario usuario = usuDAO.encontrar(Long.valueOf(token));
                if(usuario != null) {
                	usuario.addObraFav(obra);
                	usuDAO.actualizar(usuario);
                	return Response.ok().entity("Interes agregado").build();
                } else {
        			return Response.status(Response.Status.NOT_FOUND).entity("No se encontro el usuario").build();
                }
            }
            catch (Exception ex)
            {
            	throw ex;
            }
		} else
			return Response.status(Response.Status.NOT_FOUND).entity("No se encontro la obra").build();
	}

	@POST
	@Path("{idObra}/asistire/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response crearAsistenciaObra(
			@PathParam("idObra") Long idObra,
			@Context HttpServletRequest httpServletRequest,
			@Context HttpServletResponse httpServletResponse
			) {
		Obra obra = obraDAO.encontrar(idObra);
		if (obra != null) {
            String token = JWToken.getToken(httpServletRequest);
            try
            {
                Usuario usuario = usuDAO.encontrar(Long.valueOf(token));
                if(usuario != null) {
                	Asistencia asist = asistDAO.recuperarXObraYUsuario(usuario, obra);
                	if (asist == null)
                		asist = new Asistencia(usuario, obra);
            		asist.setEstado(Asistencia.Estados.ACTIVA);
                	asistDAO.actualizar(asist);
                	return Response.ok().entity(asist).build();
                } else {
        			return Response.status(Response.Status.NOT_FOUND).entity("No se encontro el usuario").build();
                }
            }
            catch (Exception ex)
            {
            	throw ex;
            }
		} else
			return Response.status(Response.Status.NOT_FOUND).entity("No se encontro la obra").build();
	}

	@PUT
	@Path("{idObra}/validar/{codigo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response asistioObra(
			@PathParam("idObra") Long idObra,
			@PathParam("codigo") String codigo,
			@Context HttpServletRequest httpServletRequest,
			@Context HttpServletResponse httpServletResponse
			) {
		Obra obra = obraDAO.encontrar(idObra);
		if (obra != null) {
            String token = JWToken.getToken(httpServletRequest);
            try
            {
                Usuario usuario = usuDAO.encontrar(Long.valueOf(token));
                if(usuario != null) {
                	Asistencia asist = asistDAO.recuperarXObraYUsuario(usuario, obra);
                	if (asist.getQrcode().equals(codigo)) {
                		asist.setEstado(Asistencia.Estados.ASISTIO);
                    	asistDAO.actualizar(asist);
                    	return Response.ok().entity("Asistencia validada").build();
                	} else {
            			return Response.status(Response.Status.CONFLICT).entity("Codigo erroneo").build();
                	}
                } else {
        			return Response.status(Response.Status.NOT_FOUND).entity("No se encontro el usuario").build();
                }
            }
            catch (Exception ex)
            {
            	throw ex;
            }
		} else
			return Response.status(Response.Status.NOT_FOUND).entity("No se encontro la obra").build();
	}

	@PUT
	@Path("{idObra}/valorar/{puntaje}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response valorarObra(
			@PathParam("idObra") Long idObra,
			@PathParam("puntaje") int puntaje,
			@Context HttpServletRequest httpServletRequest,
			@Context HttpServletResponse httpServletResponse
			) {
		Obra obra = obraDAO.encontrar(idObra);
		if (obra != null) {
            String token = JWToken.getToken(httpServletRequest);
            try
            {
                Usuario usuario = usuDAO.encontrar(Long.valueOf(token));
                if(usuario != null) {
                	if (puntaje >= 0 && puntaje <= 10) {
                    	Valoracion val = valDAO.recuperarXObraYUsuario(usuario, obra);
                    	if (val == null)
                    		val = new Valoracion(puntaje, usuario, obra);
                    	else
                    		val.setPuntaje(puntaje);
                		valDAO.actualizar(val);
                    	return Response.ok().entity("Obra puntuada").build();
                	} else {
            			return Response.status(Response.Status.CONFLICT).entity("Puntaje erroneo").build();
                	}
                } else {
        			return Response.status(Response.Status.NOT_FOUND).entity("No se encontro el usuario").build();
                }
            }
            catch (Exception ex)
            {
            	throw ex;
            }
		} else
			return Response.status(Response.Status.NOT_FOUND).entity("No se encontro la obra").build();
	}

	@PUT
	@Path("{idObra}/entradasEntregadas/{entradas}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response venderEntradasObra(
			@PathParam("idObra") Long idObra,
			@PathParam("entradas") int entradas,
			@Context HttpServletRequest httpServletRequest,
			@Context HttpServletResponse httpServletResponse
			) {
		Actividad act = actDAO.encontrarPorObra(idObra);
		if (act != null) {
            String token = JWToken.getToken(httpServletRequest);
            try
            {
                Usuario usuario = usuDAO.encontrar(Long.valueOf(token));
                if(usuario != null) {
                	if (entradas > 0 && act.getEspacio() != null && (entradas + act.getEntradasVendidas() <= act.getEspacio().getCapacidad())) {
                    	act.setEntradasVendidas(entradas + act.getEntradasVendidas());
                    	actDAO.actualizar(act);
                    	return Response.ok().entity("Entradas vendidas").build();
                	} else {
            			return Response.status(Response.Status.PRECONDITION_FAILED).entity("Numero de entradas incorrecto").build();
                	}
                } else {
        			return Response.status(Response.Status.NOT_FOUND).entity("No se encontro el usuario").build();
                }
            }
            catch (Exception ex)
            {
            	throw ex;
            }
		} else
			return Response.status(Response.Status.NOT_FOUND).entity("No se encontro la actividad").build();
	}

}
