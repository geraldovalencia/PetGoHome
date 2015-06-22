package br.com.petGoHome.banner;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.petGoHome.entidades.AbstractEntity;

@Entity
@Inheritance(strategy=InheritanceType.JOINED) 
public class HistoricoBanner extends AbstractEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pessoa_id") para postgres
	private long id;
	private String nomeFoto;
	
	@Temporal(TemporalType.DATE)
	private Date dataAlteracao;
	
	private long bannerId;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeFoto() {
		return nomeFoto;
	}

	public void setNomeFoto(String nomeFoto) {
		this.nomeFoto = nomeFoto;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public long getBannerId() {
		return bannerId;
	}

	public void setBannerId(long bannerId) {
		this.bannerId = bannerId;
	}
	
	

}
