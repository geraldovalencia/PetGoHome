package br.com.petGoHome.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.petGoHome.entidades.PessoaFisica;
import br.com.petGoHome.entidades.PetShop;

public class PetShopDao extends AbstractDao<PetShop> {

	public PetShopDao(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<PetShop> entityClass() {
		return PetShop.class;
	}

	public List<PetShop> buscarPetShopPorCNPJ(String nome, String cnpj) {

		Query query = manager
				.createQuery("SELECT u FROM PessoaFisica u WHERE u.nome = :nome AND u.cnpj = :cnpj ");
		query.setParameter("nome", nome);
		query.setParameter("cnpj", cnpj);

		return query.getResultList();
	}

}
