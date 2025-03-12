package com.algaworks.erp.repository;

import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.model.RamoAtividade;
import com.algaworks.erp.model.TipoEmpresa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;
import java.util.List;

public class CamadaPersistencia {

    public static void main (String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlgaWorksPU");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        //Declarando os repositorios

        RamoAtividades ramoAtividades = new RamoAtividades(em);
        Empresas empresas = new Empresas(em);


        //Buscando as informações do banco
        List<RamoAtividade> listDeRamoAtividades = ramoAtividades.pesquisar("");
        List<Empresa> listDeEmpresas = empresas.pesquisar("");
        System.out.println(listDeRamoAtividades);


        //Criando uma empresa

        Empresa empresa = new Empresa();
        empresa.setNomeFantasia("João da Silva");
        empresa.setCnpj("41.952.519/0001-57");
        empresa.setRazaoSocial("João da Silva 41952519000157");
        empresa.setTipo(TipoEmpresa.MEI);
        empresa.setDataFundacao(new Date());
        empresa.setRamoAtividade(listDeRamoAtividades.get(0));

        //Salvando a empresa

        empresas.guardar(empresa);

        em.getTransaction().commit();

        //Verificando se a inserção funcionou

        List<Empresa> listDeEmpresas2 = empresas.pesquisar("");
        System.out.println(listDeEmpresas2);


        em.close();
        emf.close();
    }

}
