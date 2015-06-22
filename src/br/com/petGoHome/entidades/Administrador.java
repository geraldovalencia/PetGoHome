package br.com.petGoHome.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Administrador extends Pessoa{

	public Administrador() {
	super();
	}
	
	private String FuncaoNoSistema;
//	Assim o Hibernate cria uma tabela para salvar o id da Raca + id do adm

	public String getFuncaoNoSistema() {
		return FuncaoNoSistema;
	}

	public void setFuncaoNoSistema(String funcaoNoSistema) {
		FuncaoNoSistema = funcaoNoSistema;
	}
	
	
}
