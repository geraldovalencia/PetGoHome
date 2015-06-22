package br.com.petGoHome.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.petGoHome.entidades.Pessoa;
import br.com.petGoHome.entidades.PessoaFisica;

public class PessoaFisicaDao extends AbstractDao<PessoaFisica> {

	public PessoaFisicaDao(EntityManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<PessoaFisica> entityClass() {
		// TODO Auto-generated method stub
		return PessoaFisica.class;
	}

	public List<PessoaFisica> buscarPessoaFisicaPorCPF(String nome, String cpf){
		
	    
        Query query = manager.createQuery("SELECT u FROM PessoaFisica u WHERE u.nome = :nome AND u.cpf = :cpf ");  
        query.setParameter("nome", nome);  
        query.setParameter("cpf", cpf); 
        
       return query.getResultList();
	}
	public List<PessoaFisica> buscarPessoaFisicaPorCpfeEmail(String cpf, String email){
		
		Query query = manager.createQuery("SELECT u FROM PessoaFisica u WHERE u.email = :email AND u.cpf = :cpf ");  
        query.setParameter("email", email);  
        query.setParameter("cpf", cpf); 
				return query.getResultList();
	}
	
public List<PessoaFisica> buscarPFPorCPF(String cpf){
		
	    
        Query query = manager.createQuery("SELECT u FROM PessoaFisica u WHERE u.cpf = :cpf ");  
        query.setParameter("cpf", cpf); 
        
       return query.getResultList();
	}
	
}
