package br.com.petGoHome.DAO;

import javax.persistence.EntityManager;

import br.com.petGoHome.entidades.RacaGato;

public class RacaGatoDao extends AbstractDao<RacaGato> {

	public RacaGatoDao(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<RacaGato> entityClass() {
		// TODO Auto-generated method stub
		return RacaGato.class;
	}

}
