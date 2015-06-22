package br.com.petGoHome.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.petGoHome.entidades.Cachorro;
import br.com.petGoHome.entidades.Pessoa;

public class CachorroDao extends AbstractDao<Cachorro>{

	public CachorroDao(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Cachorro> entityClass() {
		return Cachorro.class;
	}
	
	public List<Cachorro> listarTodosCachorrosPorDono(Pessoa pessoa){
		Query query = manager.createQuery("Select i FROM Cachorro i WHERE i.pessoa.id = :pessoa" );
		
		query.setParameter("pessoa", pessoa.getId()); //É aqui no set que o objeto pessoa deve ser manipulado e não na 
		//referencia de string da fórmula acima.
		
		return query.getResultList();
	}

}
