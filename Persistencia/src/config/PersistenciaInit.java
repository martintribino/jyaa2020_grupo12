package config;

import java.time.Duration;
import java.time.LocalDateTime;

import javax.ws.rs.ApplicationPath;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.glassfish.jersey.server.ResourceConfig;

import IDAO.IActividadDAO;
import IDAO.IArtistaDAO;
import IDAO.IEdicionDAO;
import IDAO.IEspacioDAO;
import IDAO.IEtiquetaDAO;
import IDAO.IObraDAO;
import IDAO.IUsuarioDAO;
import modelo.Actividad;
import modelo.Artista;
import modelo.Coordinadas;
import modelo.Direccion;
import modelo.Edicion;
import modelo.Espacio;
import modelo.Etiqueta;
import modelo.Obra;
import modelo.Rol;
import modelo.Usuario;

@ApplicationPath("services")
public class PersistenciaInit extends ResourceConfig {

	private final static Boolean ABMUsuarios = true;
	private final static Boolean ABMArtistas = true;
	private final static Boolean ABMActividades = true;
	private final static Boolean ABMEspacios = true;
	private final static Boolean ABMObras = true;
	private final static Boolean ABMEtiquetas = true;
	private final static Boolean ABMEdiciones = true;

	public PersistenciaInit() {
		ServiceLocator locator = ServiceLocatorUtilities.createAndPopulateServiceLocator();
		ServiceLocatorUtilities.enablePerThreadScope(locator);
		ServiceLocatorUtilities.bind(locator, new PersistenciaBinder());
		if (ABMUsuarios) 
			this.ABMUsuarios(locator, true);
		if (ABMArtistas) 
			this.ABMArtistas(locator, true);
		if (ABMActividades) 
			this.ABMActividades(locator, true);
		if (ABMEspacios) 
			this.ABMEspacios(locator, true);
		if (ABMObras) 
			this.ABMObras(locator, true);
		if (ABMEtiquetas) 
			this.ABMEtiquetas(locator, true);
		if (ABMEdiciones) 
			this.ABMEdiciones(locator, true);
	}
	
	private void ABMEdiciones(ServiceLocator locator, Boolean baja) {
		//Ediciones
		Actividad actividad1 = new Actividad("Actividad 1", "Actividad 1 - 2020", LocalDateTime.of(2020, 01, 02, 00, 00), LocalDateTime.of(2020, 02, 02, 00, 00));
		IEdicionDAO edicionDAO = locator.getService(IEdicionDAO.class);
		Edicion edicion2 = new Edicion("Edicion 2020", "Festival Edición 2020", LocalDateTime.of(2019, 01, 01, 00, 00), LocalDateTime.of(2019, 10, 10, 00, 00));
		Edicion edicion1 = new Edicion("Edicion 2019", "Festival Edición 2019", LocalDateTime.of(2019, 01, 01, 00, 00), LocalDateTime.of(2019, 10, 10, 00, 00));
		edicion2.addActividad(actividad1);
		//Alta
		edicionDAO.guardar(edicion1);
		edicionDAO.guardar(edicion2);
		//Edicion
		edicion1.setNombre("Etiqueta1 eliminar");
		edicion1.setDescripcion("Desc");
		edicionDAO.actualizar(edicion1);
		//Baja
		if (baja)
			edicionDAO.eliminar(edicion1);
	}
	
	private void ABMEtiquetas(ServiceLocator locator, Boolean baja) {
		//Etiqueta
		IEtiquetaDAO etiquetaDAO = locator.getService(IEtiquetaDAO.class);
		Etiqueta etiqueta1 = new Etiqueta("Etiqueta1", "Etiqueta 1 2020");
		Etiqueta etiqueta2 = new Etiqueta("Etiqueta2", "Etiqueta 2 2020");
		//Alta
		etiquetaDAO.guardar(etiqueta1);
		etiquetaDAO.guardar(etiqueta2);
		//Edicion
		etiqueta1.setNombre("Etiqueta1 eliminar");
		etiqueta1.setDescripcion("Desc");
		etiquetaDAO.actualizar(etiqueta1);
		//Baja
		if (baja)
			etiquetaDAO.eliminar(etiqueta1);
	}
	
	private void ABMEspacios(ServiceLocator locator, Boolean baja) {
		//Espacio
		Direccion dir1 = new Direccion("26 nro 128", "La Plata", "Buenos Aires", 1900,
				new Coordinadas(120, 125));
		Direccion dir2 = new Direccion("26 nro 120", "La Plata", "Buenos Aires", 1900,
				new Coordinadas(120, 120));
		IEspacioDAO espacioDAO = locator.getService(IEspacioDAO.class);
		Espacio espacio1 = new Espacio("Espacio1", "Espacio 1 2020", 1500, Espacio.Estados.CERRADO, dir1);
		Espacio espacio2 = new Espacio("Espacio2", "Espacio 2 2020", 1500, Espacio.Estados.ABIERTO, dir2);
		//Alta
		espacioDAO.guardar(espacio1);
		espacioDAO.guardar(espacio2);
		//Edicion
		espacio1.setNombre("Actividad eliminar");
		espacio1.setDescripcion("Desc");
		espacioDAO.actualizar(espacio1);
		//Baja
		if (baja)
			espacioDAO.eliminar(espacio1);
	}
	
	private void ABMObras(ServiceLocator locator, Boolean baja) {
		//Obras
		IObraDAO obraDAO = locator.getService(IObraDAO.class);
		Obra obra1 = new Obra("Obra 1", "Obra 1 - 2020",  Duration.ofMinutes(60));
		Obra obra2 = new Obra("Obra 2", "Obra 2 - 2020",  Duration.ofMinutes(60));
		//Alta
		obraDAO.guardar(obra1);
		obraDAO.guardar(obra2);
		//Edicion
		obra1.setNombre("Actividad eliminar");
		obra1.setDescripcion("Desc");
		obraDAO.actualizar(obra1);
		//Baja
		if (baja)
			obraDAO.eliminar(obra1);
	}
	
	private void ABMActividades(ServiceLocator locator, Boolean baja) {
		//Actividades
		IActividadDAO actividadDAO = locator.getService(IActividadDAO.class);
		Actividad actividad1 = new Actividad("Actividad 1", "Actividad 1 - 2020", LocalDateTime.of(2020, 01, 02, 00, 00), LocalDateTime.of(2020, 02, 02, 00, 00));
		Actividad actividad2 = new Actividad("Actividad 2", "Actividad 2 - 2020", LocalDateTime.of(2020, 02, 03, 00, 00), LocalDateTime.of(2020, 03, 03, 00, 00));
		//Alta
		actividadDAO.guardar(actividad1);
		actividadDAO.guardar(actividad2);
		//Edicion
		actividad1.setNombre("Actividad eliminar");
		actividad1.setDescripcion("Desc");
		actividadDAO.actualizar(actividad1);
		//Baja
		if (baja)
			actividadDAO.eliminar(actividad1);
	}
	
	private void ABMArtistas(ServiceLocator locator, Boolean baja) {
		//Artista
		IArtistaDAO artistaDAO = locator.getService(IArtistaDAO.class);
		Artista artista = new Artista("Nombre Artista", "Apellido Artista", "Apodo Artista");
		//Alta
		artistaDAO.guardar(artista);
		//Edicion
		artista.setNombre("Nombre");
		artista.setApellido("Apellido");
		artistaDAO.actualizar(artista);
		//Baja
		if (baja)
			artistaDAO.eliminar(artista);
	}
	
	private void ABMUsuarios(ServiceLocator locator, Boolean baja) {
		//Rol
		Rol participante = new Rol("Participante", "Participante");
		participante.addPermiso(Rol.Permisos.ALTA_INTERESES.toString());
		participante.addPermiso(Rol.Permisos.ALTA_NOTIFICACIONES.toString());
		participante.addPermiso(Rol.Permisos.ALTA_VALORACIONES.toString());
		participante.addPermiso(Rol.Permisos.BAJA_INTERESES.toString());
		participante.addPermiso(Rol.Permisos.BAJA_NOTIFICACIONES.toString());
		participante.addPermiso(Rol.Permisos.BAJA_VALORACIONES.toString());
		participante.addPermiso(Rol.Permisos.LECTURA_EDICIONES.toString());
		participante.addPermiso(Rol.Permisos.LECTURA_VALORACIONES.toString());
		participante.addPermiso(Rol.Permisos.LECTURA_OBRAS.toString());
		participante.addPermiso(Rol.Permisos.LECTURA_INTERESES.toString());
		participante.addPermiso(Rol.Permisos.LECTURA_EDICIONES.toString());
		participante.addPermiso(Rol.Permisos.LECTURA_ESPACIOS.toString());
		IUsuarioDAO usuarioDAO = locator.getService(IUsuarioDAO.class);
		Direccion dir1 = new Direccion("26 nro 118", "La Plata", "Buenos Aires", 1900,
				new Coordinadas(120, 115));
		Usuario usuario = new Usuario( "participante", "p123", "Nombre1", "Apellido1", 123, 123,
										"part@part.com", participante, dir1);
		//Alta Usuario
		usuarioDAO.guardar(usuario);
		//Edicion usuario
		usuario.setNombre("Nombre");
		usuario.setDni(321);
		usuarioDAO.actualizar(usuario);
		//Baja Usuario
		if (baja)
			usuarioDAO.eliminar(usuario);
	}

}
