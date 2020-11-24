package com.config;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.ext.Provider;

import org.glassfish.hk2.api.JustInTimeInjectionResolver;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.process.internal.RequestScoped;

@Provider
public class PersistenciaBinder extends AbstractBinder {

	@Override
    protected void configure() {
		bindFactory(EMFFactory.class).to(EntityManagerFactory.class).in(Singleton.class);
		bindFactory(EMFactory.class).to(EntityManager.class).in(RequestScoped.class);
		bind(JustInTimeServiceResolver.class).to(JustInTimeInjectionResolver.class);
    }

}
