package com.controllers;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

import com.IDAO.IUsuarioDAO;
import com.config.PersistenciaBinder;
import com.dto.requests.UsuarioDtoRequest;
import com.dto.responses.UsuarioDtoResponse;
import com.modelo.Usuario;
import com.security.JWToken;

@Path("/")
public class AuthController {

	//@Inject
	//private IUsuarioDAO udao;

	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public Response login(UsuarioDtoRequest usuario) {
		try
		{
			ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();
			ServiceLocatorUtilities.enablePerThreadScope(locator);
			ServiceLocatorUtilities.bind(locator, new PersistenciaBinder());
			//usuarios
			IUsuarioDAO udao = locator.getService(IUsuarioDAO.class);
			Usuario usu = udao.encontrarPorNombre(usuario.getNombreUsuario());
			if (usu != null) {
		        if (usu.verificarClave(usuario.getClave())) {
		        	String token = JWToken.generar(usu.getNombreUsuario());
					UsuarioDtoResponse resp = new UsuarioDtoResponse();
					resp.setNombreUsuario(usuario.getNombreUsuario());
					resp.setToken(token);
					if(usu.getRol() != null)
						resp.setRol(usu.getRol().getTipo());
					return Response.ok().entity(resp).build();
		        } else {
					return Response.status(Response.Status.UNAUTHORIZED).entity("Credenciales incorrectas").build();
		        }
			} else {
				return Response.status(Response.Status.UNAUTHORIZED).entity("El usuario no existe").build();
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			return Response.status(Response.Status.BAD_REQUEST).entity("No se pudo logear el usuario").build();
		}
	}

}
