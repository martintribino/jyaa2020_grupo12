package com.config;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.servlet.ServletContext;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

import com.IDAO.IRolDAO;
import com.IDAO.IUsuarioDAO;
import com.modelo.Direccion;
import com.modelo.Rol;
import com.modelo.Usuario;
import com.security.Encrypt;
import com.services.IStorage;

@ApplicationPath("/rest/*")
@Singleton
public class AppRest extends Application {

	@Context
	ServletContext servletContext;

	public AppRest() {
		System.out.println("init api rest");
	}
	
	@Override
	public Map<String, Object> getProperties() {
	    Map<String, Object> props = new HashMap<>();
	    props.put("jersey.config.server.provider.classnames", 
	            "org.glassfish.jersey.media.multipart.MultiPartFeature");
	    return props;
	}

	@PostConstruct
	public void init() {
		System.out.println("creating roles ...");
		ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();
		ServiceLocatorUtilities.enablePerThreadScope(locator);
		ServiceLocatorUtilities.bind(locator, new PersistenciaBinder());
		try
		{
			//Storage
			IStorage storage = locator.getService(IStorage.class);
			storage.init(servletContext);
			//Roles
			IRolDAO rolDAO = locator.getService(IRolDAO.class);
			//usuarios
			IUsuarioDAO usuDAO = locator.getService(IUsuarioDAO.class);
			//Administrador
			Rol administrador = new Rol("Administrador", Rol.Tipos.ADMINISTRADOR);
			rolDAO.guardar(administrador);
			//Operador
			Rol operador = new Rol("Operador", Rol.Tipos.OPERADOR);
			rolDAO.guardar(operador);
			//Participante
			Rol participante = new Rol("Participante", Rol.Tipos.PARTICIPANTE);
			rolDAO.guardar(participante);
			//Visitante
			Rol visitante = new Rol("Visitante", Rol.Tipos.VISITANTE);
			rolDAO.guardar(visitante);
			Direccion dir1 = new Direccion("26 nro 118", "La Plata", "Buenos Aires", 1900, -57.98648357391353, -34.92119690351051);
			String pass = Encrypt.encode("admin123");
			Usuario admin = new Usuario( "admin", pass, "Admin", "Admin", 123321, 123456,
					"admin@admin.com", administrador, dir1);
			usuDAO.actualizar(admin);
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println("Error creating roles.");
		}
	}

}