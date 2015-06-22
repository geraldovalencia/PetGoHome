package br.com.petGoHome.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.petGoHome.entidades.Pessoa;
import br.com.petGoHome.entidades.Pet;
import br.com.petGoHome.entidades.Tag;

public class PetDao extends AbstractDao<Pet>{

	public PetDao(EntityManager manager) {
		super(manager);
	}

	@Override
	public Class<Pet> entityClass() {
		// TODO Auto-generated method stub
		return Pet.class;
	}
	
	public List<Pet> listarTodosPetsporDono(Pessoa pessoa){
		Query query = manager.createQuery("Select i FROM Pet i WHERE i.pessoa.id = :pessoa" );
		
		query.setParameter("pessoa", pessoa.getId()); //É aqui no set que o objeto pessoa deve ser manipulado e não na 
		//referencia de string da fórmula acima.
		
		return query.getResultList();
	}
	public List<Pet> buscarPetPorTag(String tag) {

		Query query = manager
				.createQuery("SELECT u FROM Pet u WHERE u.tag.valorTag = :tag");
		query.setParameter("tag", tag);

		return query.getResultList();
	}
	public List<Tag> buscarTagPorPet(Long idPet) {
		
		Query query = manager
				.createQuery("SELECT t FROM Tag t WHERE t.pet.id = :idPet");
		query.setParameter("idPet", idPet);
		
		return query.getResultList();
	}

}
