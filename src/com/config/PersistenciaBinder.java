package com.config;

import java.util.Properties;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.ext.Provider;

import org.glassfish.hk2.api.JustInTimeInjectionResolver;
import org.glassfish.hk2.api.PerLookup;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.process.internal.RequestScoped;

import com.helpers.StorageProperties;

@Provider
public class PersistenciaBinder extends AbstractBinder {

	@Override
    protected void configure() {
		bind(EMFFactory.class).to(EntityManagerFactory.class).in(Singleton.class);
		bind(EMFactory.class).to(EntityManager.class).in(RequestScoped.class);
		bind(JustInTimeServiceResolver.class).to(JustInTimeInjectionResolver.class);
		bind(StorageProperties.class).to(Properties.class);
    }

}
