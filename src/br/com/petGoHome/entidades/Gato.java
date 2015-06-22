package br.com.petGoHome.entidades;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Gato extends Pet{

	@OneToOne
	private RacaGato racaGato;
	//Assim o Hibernate cria uma tabela para salvar o id da Raca + id do Pet

	public RacaGato getRacaGato() {
		return racaGato;
	}

	public void setRacaGato(RacaGato racaGato) {
		this.racaGato = racaGato;
	}
	
	
	
}
