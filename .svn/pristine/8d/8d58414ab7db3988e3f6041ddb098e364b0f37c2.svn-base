package br.com.petGoHome.entidades;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
//@SequenceGenerator(name="cachorro_id", sequenceName="cachorro_seq", allocationSize=1)
public class Cachorro extends Pet {
	
	@OneToOne
	private RacaCachorro racaCachorro;
	//Assim o Hibernate cria uma tabela para salvar o id da Raca + id do Pet

	public RacaCachorro getRacaCachorro() {
		return racaCachorro;
	}

	public void setRacaCachorro(RacaCachorro racaCachorro) {
		this.racaCachorro = racaCachorro;
	}
	

	
	//van
	

}
