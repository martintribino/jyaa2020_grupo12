package com.config;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;

import com.IDAO.IArtistaDAO;
import com.IDAO.IEdicionDAO;
import com.IDAO.IEspacioDAO;
import com.IDAO.IRolDAO;
import com.IDAO.IUsuarioDAO;
import com.modelo.Artista;
import com.modelo.Direccion;
import com.modelo.Edicion;
import com.modelo.Espacio;
import com.modelo.Rol;
import com.modelo.Usuario;
import com.security.Encrypt;
import com.services.IStorage;

public class AppInit implements Feature {

	@Context
	ServletContext servletContext;
	@Inject
	IEspacioDAO espacioDAO;
	@Inject
	IEdicionDAO edicionDAO;
	@Inject
	IRolDAO rolDAO;
	@Inject
	IUsuarioDAO usuDAO;
	@Inject
	IArtistaDAO artDAO;
	@Inject
	IStorage storage;
	
	@PostConstruct
	public void init() {
		System.out.println("iniciando ...");
		try {
			storage.init(servletContext);
		} catch (IOException e1) {
			System.out.println(e1);
			System.out.println("Storage fail.");
		}
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
		Rol operador = new Rol("Operador", Rol.Tipos.OPERADOR);
		try
		{
			//Operador
			rolDAO.guardar(operador);
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println("Rol operador ya creado.");
		}
		Rol participante = new Rol("Participante", Rol.Tipos.PARTICIPANTE);
		try
		{
			//Participante
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
		try
		{
			Direccion dir2 = new Direccion("25 nro 118", "La Plata", "Buenos Aires", 1900, -57.98548357391353, -34.92119690351051);
			String pass = Encrypt.encode("operador123");
			Usuario admin = new Usuario( "operador", pass, "Operador", "Operador", 1243321, 1234456,
					"operador@op.com", operador, dir2);
			usuDAO.actualizar(admin);
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println("Error creando usuario operador.");
		}
		try
		{
			Direccion dir3 = new Direccion("28 nro 118", "La Plata", "Buenos Aires", 1900, -57.98548357391353, -34.92159690351051);
			String pass = Encrypt.encode("participante123");
			Usuario admin = new Usuario( "participante", pass, "Participante", "Participante", 1247321, 1734456,
					"participante@part.com", participante, dir3);
			usuDAO.actualizar(admin);
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println("Error creando usuario participante.");
		}
		try
		{
			Artista art = new Artista( "Milo", "Locket", "Milock");
			artDAO.guardar(art);
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println("Error creando artista.");
		}
		try
		{
			Artista art = new Artista( "Leonardo", "Davinci", "Maestro");
			artDAO.guardar(art);
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println("Error creando artista.");
		}
		try
		{
			Direccion dir4 = new Direccion("25 y 32", "La Plata", "Buenos Aires", 1900, -54.98548357391353, -36.92159690351051);
			Espacio esp1 = new Espacio("Estadio Ciudad La Plata", "Estadio Ciudad La Plata",
								35000, Espacio.Estados.ABIERTO, dir4);
			espacioDAO.guardar(esp1);
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println("Error creando espacio.");
		}
		try
		{
			Direccion dir5 = new Direccion("1 y 118", "La Plata", "Buenos Aires", 1900, -54.98548357391378, -36.92159690351078);
			Espacio esp2 = new Espacio("Teatro del lago", "Teatro del lago La Plata",
								5000, Espacio.Estados.ABIERTO, dir5);
			espacioDAO.guardar(esp2);
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println("Error creando espacio.");
		}
		try
		{
			Edicion edicion = new Edicion("Edicion 2019", "Edicion del 2019",
						LocalDateTime.of(2019, 01, 02, 00, 00), LocalDateTime.of(2019, 12, 31, 23, 59));
			edicionDAO.guardar(edicion);
		}
		catch (Exception e)
		{
			System.out.println(e);
			System.out.println("Error creando edicion.");
		}
	}

	@Override
	public boolean configure(FeatureContext context) {
		System.out.println("configure ...");
		return false;
	}
}
