package br.com.petGoHome.DAO;

import javax.persistence.EntityManager;

import br.com.petGoHome.entidades.RacaCachorro;

public class RacaCachoroDao extends AbstractDao<RacaCachorro>{

	public RacaCachoroDao(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<RacaCachorro> entityClass() {
		// TODO Auto-generated method stub
		return RacaCachorro.class;
	}

}
