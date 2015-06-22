package br.com.petGoHome.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.petGoHome.entidades.Cachorro;
import br.com.petGoHome.entidades.Gato;
import br.com.petGoHome.entidades.Pessoa;

public class GatoDao extends AbstractDao<Gato>{

	public GatoDao(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<Gato> entityClass() {
		// TODO Auto-generated method stub
		return Gato.class;
	}
	
	public List<Gato> listarTodosGatosPorDono(Pessoa pessoa){
		Query query = manager.createQuery("Select i FROM Gato i WHERE i.pessoa.id = :pessoa" );
		
		query.setParameter("pessoa", pessoa.getId()); //É aqui no set que o objeto pessoa deve ser manipulado e não na 
		//referencia de string da fórmula acima.
		
		return query.getResultList();
	}

}
