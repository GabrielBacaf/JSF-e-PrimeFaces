package com.algaworks.erp.repository;

import com.algaworks.erp.model.Empresa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.internal.build.AllowSysOut;

import java.util.List;

public class SchemaGeneration {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlgaWorksPU");

        EntityManager em = emf.createEntityManager();

        List<Empresa> lista = em.createQuery("from Empresa", Empresa.class).getResultList();

        System.out.println(lista);
        em.close();
        emf.close();
    }
}
