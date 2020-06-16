package com.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.glassfish.hk2.api.Factory;

public class EMFFactory implements Factory<EntityManagerFactory> {

	static private final String PERSISTENCE_UNIT_NAME = "Persistencia";

	private final EntityManagerFactory emf;

	public EMFFactory() {
		emf = Persistence.createEntityManagerFactory(EMFFactory.PERSISTENCE_UNIT_NAME);
	}

	@Override
	public void dispose(EntityManagerFactory arg0) {
		if (arg0.isOpen())
			arg0.close();
	}

	@Override
	public EntityManagerFactory provide() {
		return emf;
	}

}
