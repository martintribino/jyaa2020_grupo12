package com.config;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;

import com.IDAO.IRolDAO;
import com.modelo.Rol;

@ApplicationPath("/api")
@Singleton
public class AppRest extends Application {

	public AppRest() {
		System.out.println("init api rest");
	}

	@PostConstruct
	public void init() {
		System.out.println("creating roles ...");
		ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();
		ServiceLocatorUtilities.enablePerThreadScope(locator);
		ServiceLocatorUtilities.bind(locator, new PersistenciaBinder());
		try
		{
			//Roles
			IRolDAO rolDAO = locator.getService(IRolDAO.class);
			//Administrador
			Rol administrador = new Rol("Administrador", "Administrador", Rol.Tipos.ADMINISTRADOR);
			rolDAO.guardar(administrador);
			//Operador
			Rol operador = new Rol("Operador", "Operador", Rol.Tipos.OPERADOR);
			rolDAO.guardar(operador);
			//Participante
			Rol participante = new Rol("Participante", "Participante", Rol.Tipos.PARTICIPANTE);
			rolDAO.guardar(participante);
			//Visitante
			Rol visitante = new Rol("Visitante", "Visitante", Rol.Tipos.VISITANTE);
			rolDAO.guardar(visitante);
		}
		catch (Exception e)
		{
			System.out.println("Error creating roles.");
		}
	}

}