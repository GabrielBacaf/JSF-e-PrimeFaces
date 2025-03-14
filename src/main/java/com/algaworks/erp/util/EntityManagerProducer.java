package com.algaworks.erp.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class EntityManagerProducer {


    private EntityManagerFactory factory;

    public EntityManagerProducer() {
        this.factory = Persistence.createEntityManagerFactory("AlgaWorksPU");
    }

    @Produces
    @RequestScoped
    public EntityManager createEntityManager(){
        return this.factory.createEntityManager();
    }

    public void closeEntityManager(@Disposes EntityManager manager){
        manager.close();
    }

}
