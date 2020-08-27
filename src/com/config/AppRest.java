package com.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/rest/*")
public class AppRest extends ResourceConfig {

	public AppRest() {
		System.out.println("init api rest");
		register(new PersistenciaBinder());
		register(MultiPartFeature.class);
		register(AppInit.class);
		packages(true, "com.controllers");
	}
}
