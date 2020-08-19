package com.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import javax.servlet.ServletContext;

import org.jvnet.hk2.annotations.Contract;

@Contract
public interface IStorage {

	void init(ServletContext servletContext) throws IOException;
	String cargarB64(String originalFName, String slug) throws Exception, IOException;
	Path cargarPath(String originalFName, String slug) throws Exception, IOException;
	String guardar(InputStream inputStream, String filename, String dirname) throws Exception, IOException;
	void borrar(File file);
	void borrarTodos(String dirName);
	void createDirectory(String dir) throws IOException, Exception;

}
