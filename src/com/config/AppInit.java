package com.config;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;

import com.IDAO.IRolDAO;
import com.IDAO.IUsuarioDAO;
import com.modelo.Direccion;
import com.modelo.Rol;
import com.modelo.Usuario;
import com.security.Encrypt;
import com.services.IStorage;

public class AppInit implements Feature {

	@Context
	ServletContext servletContext;
	@Inject
	IRolDAO rolDAO;
	@Inject
	IUsuarioDAO usuDAO;
	@Inject
	IStorage storage;
	
	@PostConstruct
	public void init() {
		try
		{
			System.out.println("creating roles ...");
			storage.init(servletContext);
			Rol administrador = new Rol("Administrador", Rol.Tipos.ADMINISTRADOR);
			try
			{
				//Administrador
				rolDAO.guardar(administrador);
			}
			catch (Exception e)
			{
				System.out.println(e);
				System.out.println("Rol administrador ya creado.");
			}
			try
			{
				//Operador
				Rol operador = new Rol("Operador", Rol.Tipos.OPERADOR);
				rolDAO.guardar(operador);
			}
			catch (Exception e)
			{
				System.out.println(e);
				System.out.println("Rol operador ya creado.");
			}
			try
			{
				//Participante
				Rol participante = new Rol("Participante", Rol.Tipos.PARTICIPANTE);
				rolDAO.guardar(participante);
			}
			catch (Exception e)
			{
				System.out.println(e);
				System.out.println("Rol participante ya creado.");
			}
			try
			{
				//Visitante
				Rol visitante = new Rol("Visitante", Rol.Tipos.VISITANTE);
				rolDAO.guardar(visitante);
			}
			catch (Exception e)
			{
				System.out.println(e);
				System.out.println("Rol visitante ya creado.");
			}
			try
			{
				Direccion dir1 = new Direccion("26 nro 118", "La Plata", "Buenos Aires", 1900, -57.98648357391353, -34.92119690351051);
				String pass = Encrypt.encode("admin123");
				Usuario admin = new Usuario( "admin", pass, "Admin", "Admin", 123321, 123456,
						"admin@admin.com", administrador, dir1);
				usuDAO.actualizar(admin);
			}
			catch (Exception e)
			{
				System.out.println(e);
				System.out.println("Error creando usuario admin.");
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println("Error creating roles.");
		}
	}

	@Override
	public boolean configure(FeatureContext context) {
		System.out.println("configure ...");
		return false;
	}
}
