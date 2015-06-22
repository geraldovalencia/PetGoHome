package br.com.petGoHome.banner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import br.com.petGoHome.entidades.AbstractEntity;

@Entity
@Inheritance(strategy=InheritanceType.JOINED) 
public class Banner extends AbstractEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pessoa_id") para postgres
	private long id;
	
	private String nomeBanner;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeBanner() {
		return nomeBanner;
	}

	public void setNomeBanner(String nomeBanner) {
		this.nomeBanner = nomeBanner;
	}
	
	

}
