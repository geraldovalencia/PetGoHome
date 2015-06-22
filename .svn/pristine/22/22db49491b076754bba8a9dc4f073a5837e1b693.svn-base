package br.com.petGoHome.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.petGoHome.entidades.Pessoa;


public class PessoaDao extends AbstractDao<Pessoa> {
	
	public PessoaDao(EntityManager manager) {
		super(manager);
	}


	@Override
	public Class<Pessoa> entityClass() {
		return Pessoa.class;
	}
	
	public List<Pessoa> logarPessoa(String login, String senha){
		
	    
        Query query = manager.createQuery("SELECT u FROM Pessoa u WHERE u.login = :login AND u.senha = :senha ");  
        query.setParameter("login", login);  
        query.setParameter("senha", senha); 
        
       return query.getResultList();
	}
	public List<Pessoa> buscarLogin(String login){
		
		
		Query query = manager.createQuery("SELECT u FROM Pessoa u WHERE u.login = :login");  
		query.setParameter("login", login);  
		
		return query.getResultList();
	}
	

}
