package br.com.petGoHome.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="raca_gato")
public class RacaGato extends AbstractEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	// @GeneratedValue(generator="raca_id", strategy=GenerationType.SEQUENCE)
	 @Column(name="id_raca_gato")
	 private long id;
	
	@Column(name="nome", nullable=false)
	 private String nomeRacaGato;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeRacaGato() {
		return nomeRacaGato;
	}

	public void setNomeRacaGato(String nomeRacaGato) {
		this.nomeRacaGato = nomeRacaGato;
	}
	
	
}
