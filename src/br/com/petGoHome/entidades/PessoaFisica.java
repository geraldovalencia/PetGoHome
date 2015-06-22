package br.com.petGoHome.entidades;

import java.util.List;

import javax.persistence.*;

@Entity
public class PessoaFisica extends Pessoa{
	
	@Column(unique = true, length=15, nullable=false)
	private String cpf;
	
	
	private String telefone;
	@Enumerated(EnumType.STRING)	
	private Uf uf;
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@Embedded//faz de um objeto um componente, um componente por si só 
	private Endereco endereco;
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	
	
	
	

}
