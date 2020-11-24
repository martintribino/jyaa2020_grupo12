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
import com.IDAO.IObraDAO;
import com.IDAO.IUsuarioDAO;
import com.modelo.Etiqueta;
import com.modelo.Obra;
import com.modelo.Usuario;
import com.security.JWToken;

@Path("/api/obras")
public class ObraController {

	@Inject
	private IUsuarioDAO usuDAO;
	@Inject
	private IObraDAO obraDAO;
	@Inject
	private IEtiquetaDAO etiquetaDAO;

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

	@GET
	@Path("/artista/{idArtista}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarObrasPorArtista(@PathParam("idArtista") Long idArtista) {
		try
		{
			List<Obra> obras = obraDAO.recuperarPorArtista(idArtista);
			return Response.ok().entity(obras).build();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se puddieron obtener obras").build();
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearObra(
			Obra obra,
			@Context HttpServletRequest httpServletRequest
			) {
		try
		{
			if (!obraDAO.existe(obra)) {
	            String token = JWToken.getToken(httpServletRequest);
		        String usrnmOwner = JWToken.parseToken(token);
		        Usuario usuario = usuDAO.encontrarPorNombre(usrnmOwner);
                if(usuario == null || !usuario.getRol().esAdministrador())
    				return Response.status(Response.Status.UNAUTHORIZED).entity("No tiene permisos").build();
				obraDAO.actualizar(obra);
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
	@Path("{idObra}/meinteresa")
	@Produces(MediaType.APPLICATION_JSON)
	public Response meInteresaObra(@PathParam("idObra") Long idObra,
			@Context HttpServletRequest httpServletRequest,
			@Context HttpServletResponse httpServletResponse
			) {
        try
        {
			Obra obra = obraDAO.encontrar(idObra);
			if (obra != null) {
	            String token = JWToken.getToken(httpServletRequest);
		        String usrnmOwner = JWToken.parseToken(token);
		        Usuario usuario = usuDAO.encontrarPorNombre(usrnmOwner);
                if(usuario != null) {
                	if (!usuario.getRol().esParticipante() && !usuario.getRol().esAdministrador() && !usuario.getRol().esOperador())
        				return Response.status(Response.Status.UNAUTHORIZED).entity("No tiene permisos").build();
                	//toggle obra favoritos
                	if(obra.getUsuariosFav().contains(usuario))
                		obra.removeUsuarioFav(usuario);
                	else
                		obra.addUsuarioFav(usuario);
                	obraDAO.actualizar(obra);
                	return Response.ok(obra).build();
                } else {
        			return Response.status(Response.Status.NOT_FOUND).entity("No se encontro el usuario").build();
                }
			} else
				return Response.status(Response.Status.NOT_FOUND).entity("No se encontro la obra").build();
        }
        catch (Exception ex)
        {
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("Error al registrar interes").build();
        }
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editarObra(
			Obra obra,
			@Context HttpServletRequest httpServletRequest
			) {
		try
		{
			Obra esp = obraDAO.encontrar(obra.getId());
			if (esp != null) {
	            String token = JWToken.getToken(httpServletRequest);
		        String usrnmOwner = JWToken.parseToken(token);
		        Usuario usuario = usuDAO.encontrarPorNombre(usrnmOwner);
                if(usuario == null || !usuario.getRol().esAdministrador())
    				return Response.status(Response.Status.UNAUTHORIZED).entity("No tiene permisos").build();
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

	@PUT
	@Path("/etiqueta/{nombre}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response agregarEtiqueta(
			@PathParam("nombre") String nombre,
			Obra obra
	) {
		try
		{
			Obra o = obraDAO.encontrar(obra.getId());
			if (o != null) {
				Etiqueta etiqueta = etiquetaDAO.etiquetaPorNombre(nombre);
				if (etiqueta == null) {
					etiqueta = new Etiqueta(nombre);
				}
				o.addEtiqueta(etiqueta);
				obraDAO.actualizar(o);
				return Response.ok().entity(o).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).entity("La obra no existe").build();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo agregar la etiqueta").build();
		}
	}

	@DELETE
	@Path("{idObra}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarObra(
			@PathParam("idObra") Long idObra,
			@Context HttpServletRequest httpServletRequest
			) {
		try
		{
            String token = JWToken.getToken(httpServletRequest);
	        String usrnmOwner = JWToken.parseToken(token);
	        Usuario usuario = usuDAO.encontrarPorNombre(usrnmOwner);
            if(usuario == null || !usuario.getRol().esAdministrador())
				return Response.status(Response.Status.UNAUTHORIZED).entity("No tiene permisos").build();
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
