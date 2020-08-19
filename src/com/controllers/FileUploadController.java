package com.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import com.IDAO.IArtistaDAO;
import com.IDAO.IUsuarioDAO;
import com.modelo.Artista;
import com.modelo.Usuario;
import com.security.JWToken;
import com.services.IStorage;

@Path("/api/archivos")
public class FileUploadController {

	@Inject
	private IArtistaDAO artistaDAO;
	@Inject
	private IUsuarioDAO usuDAO;
	@Inject
	private IStorage storageSrv;

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response uploadImagen(
		@FormDataParam("artista") Long idArtista,
		@FormDataParam("archivos") InputStream uploadedInputStream,
		@FormDataParam("archivos") FormDataContentDisposition fileDetails
		) throws FileNotFoundException {
		try
		{
			Artista artista = artistaDAO.encontrar(idArtista);
			if (artista != null) {
				String uploadedFileLocation = "artista" + artista.getId();
				String pathname = this.storageSrv.guardar(uploadedInputStream, fileDetails.getFileName(), uploadedFileLocation);
				artista.addFoto(pathname);
				this.artistaDAO.guardar(artista);
				return Response.status(Response.Status.NO_CONTENT).build();
			} else
				return Response.status(Response.Status.BAD_REQUEST).entity("No existe el artista.").build();
		}
		catch (IOException eio) {
			System.out.println(eio);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se puede guardar esa imagen en esa ruta.").build();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo guardar la imagen.").build();
		}
	}

	@GET
	@Path("{path}/{filename}")
	public String getImagen(
			@PathParam("path") String path,
			@PathParam("filename") String filename,
			@HeaderParam(JWToken.AUTHORIZATION_HEADER) String rawToken
		) {
		try
		{
	        String token = JWToken.getToken(rawToken);
	        String usrnmOwner = JWToken.parseToken(token);
	        Usuario own = usuDAO.encontrarPorNombre(usrnmOwner);
            if(own != null) {
				String b64 = this.storageSrv.cargarB64(path, filename);
            	return b64;
            } else {
    			return "";
            }
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return "";
		}
	}

}
