package com.config;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.glassfish.hk2.api.Factory;

public class EMFactory implements Factory<EntityManager> {

    private final EntityManager em;

    @Inject
    public EMFactory(EMFFactory emf){
        this.em = emf.provide().createEntityManager();
    }

    @Override
    public EntityManager provide() {
        return em;
    }

	@Override
	public void dispose(EntityManager arg0) {
		if (arg0.isOpen())
			arg0.close();
	}

}
