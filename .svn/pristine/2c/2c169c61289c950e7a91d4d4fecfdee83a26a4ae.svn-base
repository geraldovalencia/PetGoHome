package br.com.petGoHome.entidades;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="raca_cachorro")
//@SequenceGenerator(name="raca_id", sequenceName="raca_seq", allocationSize=1)
public class RacaCachorro extends AbstractEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	// @GeneratedValue(generator="raca_id", strategy=GenerationType.SEQUENCE)
	 @Column(name="id_raca")
	 private long id;
	
	@Column(name="nome", nullable=false)
	 private String nomeRacaCachorro;

	public String getNomeRacaCachorro() {
		return nomeRacaCachorro;
	}

	public void setNomeRacaCachorro(String nomeRacaCachorro) {
		this.nomeRacaCachorro = nomeRacaCachorro;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	
	

}
