package com.algaworks.erp.controller;

import java.io.Serializable;

import com.algaworks.erp.model.Empresa;
import com.algaworks.erp.model.TipoEmpresa;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

//named faz com que as intancias dos methodos sejam acessiveis a todas as paginas de html
//@RequestScoped é criado no inicio de uma requisicao e destruido no final dela e não será compartilhado em multiplas requisiçoes do usuario
//viewScoped dura quando o usuario estiver ainda na mesma pagina, é destruido quando o usuario sai da pagina ou recarrega.
//ApplicationScoped é instanciado somente uma vez podendo ser usado entre todas as requisiçõese usuarios e sera usado durante todo o ciclo de vida da aplicação.


@Named 
@ViewScoped
public class GestaoEmpresasBean implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	private Empresa empresa = new Empresa();
	
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public TipoEmpresa[] getTiposEmpresa() {
		return TipoEmpresa.values();
	}
	
	
	public void salvar() {
		System.out.println("Razão social: " + empresa.getRazaoSocial() + " Nome fantasia:" + empresa.getNomeFantasia() + "Tipo: " + empresa.getTipo());
	}
	
	
	
	
	
	
	

}
