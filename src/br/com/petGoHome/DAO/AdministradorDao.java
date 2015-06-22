package br.com.petGoHome.DAO;

import javax.persistence.EntityManager;

import br.com.petGoHome.entidades.Administrador;

public class AdministradorDao extends AbstractDao<Administrador> {

	public AdministradorDao(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Administrador> entityClass() {
		// TODO Auto-generated method stub
		return Administrador.class;
	}

}
