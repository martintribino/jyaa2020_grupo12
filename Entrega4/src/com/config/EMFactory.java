package com.config;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.glassfish.hk2.api.Factory;

public class EMFactory implements Factory<EntityManager> {

    private final EntityManagerFactory emf;

    @Inject
    public EMFactory (EntityManagerFactory emf){
        this.emf = emf;
    }

    @Override
    public EntityManager provide() {
        final EntityManager em = emf.createEntityManager();
        return em;
    }

	@Override
	public void dispose(EntityManager arg0) {
		if (arg0.isOpen())
			arg0.close();
	}

}
