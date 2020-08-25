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

import com.IDAO.IArtistaDAO;
import com.IDAO.IUsuarioDAO;
import com.modelo.Artista;
import com.modelo.Obra;
import com.modelo.Usuario;
import com.security.JWToken;

@Path("/api/artistas")
public class ArtistaController {

	@Inject
	private IArtistaDAO artistaDAO;
	@Inject
	private IUsuarioDAO usuDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarArtistas() {
		List<Artista> artistas = artistaDAO.listar();
		return Response.ok().entity(artistas).build();
	}

	@GET
	@Path("/{idArtista}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response listarArtista(@PathParam("idArtista") Long idArtista) {
		try
		{
			Artista artista = artistaDAO.encontrar(idArtista);
			if (artista != null)
				return Response.ok(artista, MediaType.APPLICATION_JSON).build();
			else
				return Response.status(Response.Status.NOT_FOUND).entity("No se encontro el artista").build();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo guardar el artista").build();
		}
	}

	@GET
	@Path("{idArtista}/meinteresa")
	@Produces(MediaType.APPLICATION_JSON)
	public Response interesaAArtista(@PathParam("idArtista") Long idArtista,
			@Context HttpServletRequest httpServletRequest,
			@Context HttpServletResponse httpServletResponse
			) {
		try
		{
			Artista artista = artistaDAO.encontrar(idArtista);
			if (artista != null) {
	            String token = JWToken.getToken(httpServletRequest);
                Usuario usuario = usuDAO.encontrar(Long.valueOf(token));
                if(usuario != null) {
                	usuario.addArtistaFav(artista);
                	usuDAO.actualizar(usuario);
                	return Response.ok().entity("Artista agregado como favorito").build();
                } else {
        			return Response.status(Response.Status.NOT_FOUND).entity("No se encontro el usuario").build();
                }
			} else {
				return Response.status(Response.Status.NOT_FOUND).entity("No se encontro el artista").build();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo guardar el artista").build();
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearArtista(Artista artista) {
		try
		{
			if (!artistaDAO.existe(artista)) {
				artistaDAO.guardar(artista);
				return Response.ok().entity(artista).build();
			} else {
				return Response.status(Response.Status.CONFLICT).entity("El artista ya existe").build();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo guardar el artista").build();
		}
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editarArtista(Artista artista) {
		try
		{
			Artista art = artistaDAO.encontrar(artista.getId());
			if (art != null) {
				artistaDAO.actualizar(artista);
				return Response.ok().entity(artista).build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).entity("El artista no existe").build();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo actualizar el artista").build();
		}
	}

	@DELETE
	@Path("{idArtista}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response eliminarArtista(@PathParam("idArtista") Long idArtista) {
		try
		{
			Artista art = artistaDAO.encontrar(idArtista);
			if (art != null) {
				/*for (Obra o : art.getObras()) {
					art.removeObra(o);
				}*/
				artistaDAO.eliminar(art);
				return Response.noContent().build();
			} else {
				return Response.status(Response.Status.NOT_FOUND).entity("El artista no existe").build();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo eliminar el artista").build();
		}
	}

}
