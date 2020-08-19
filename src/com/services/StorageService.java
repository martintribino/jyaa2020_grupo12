package com.services;

import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.xml.bind.DatatypeConverter;

import org.jvnet.hk2.annotations.Service;

import com.helpers.StorageProperties;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class StorageService implements IStorage {

	public static final String SANITIZE = "[^a-zA-Z0-9\\._]+";
	public static Path rootLocation;
	public static final long limit = 1024 * 256;    // 256 KB
	@Inject
	StorageProperties properties;

	public void FileSystemStorageService(ServletContext servletContext) {
		String absoluteFilePath = servletContext.getRealPath(properties.getLocation());
		StorageService.rootLocation = Paths.get(absoluteFilePath);
	}

	public static String sanitizeFileName(String filename) {
		return filename.replaceAll(StorageService.SANITIZE, "_");
	}

	public void init(ServletContext servletContext) throws IOException {
		try {
			FileSystemStorageService(servletContext);
			Files.createDirectories(rootLocation);
		}
		catch (IOException eio) {
			System.out.println(eio);
			throw eio;
		}
	}

	public String guardar(
			InputStream inputStream,
            String filename,
            String dirname
        ) throws Exception, IOException {
		String originalFName = StorageService.sanitizeFileName(filename);
		String pathname = dirname + File.separator + originalFName;
		if (pathname.contains("..")) {
			// This is a security check
			throw new IOException("No se puede guardar el archivo fuera del actual directorio.");
		}
		try {
			this.createDirectory(dirname);
			Path absPath = StorageService.rootLocation.resolve(pathname);
			Files.copy(inputStream, absPath,
				StandardCopyOption.REPLACE_EXISTING);
			return pathname;
		}
		catch (IOException eio) {
			System.out.println(eio);
			throw new IOException("No se pudo guardar el archivo.");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			throw(ex);
		}
	}

	@Override
	public String cargarB64(String slug, String originalFName) throws Exception, IOException {
		try {
			Path path = cargarPath(slug, originalFName);
			String base64 = String.format("data:image/png;base64,%s", DatatypeConverter.printBase64Binary(Files.readAllBytes(path)));
			return base64;
		}
		catch (MalformedURLException e) {
			throw new IOException("No se pudo leer el archivo: " + originalFName, e);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
			throw(ex);
		}
	}

	@Override
	public Path cargarPath(String slug, String originalFName) throws Exception, IOException {
		String filename = slug + File.separator + originalFName;
		try {
			if (filename.startsWith("../") || new File(filename).isAbsolute())
				throw new IOException("Ruta incorrecta");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return rootLocation.resolve(filename);
	}

	@Override
	public void borrar(File file) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrarTodos(String dirName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createDirectory(String dir) throws Exception, IOException {
		Path dirPath = StorageService.rootLocation.resolve(dir);
		try
		{
			Files.createDirectories(dirPath);
		}
		catch (IOException eio) {
			System.out.println(eio);
			throw new IOException("No se pudo guardar el archivo.");
		}
		catch (Exception e)
		{
			System.out.println(e);
			throw e;
		}
	}

}
