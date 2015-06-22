package br.com.petGoHome.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED) 
//@SequenceGenerator(sequenceName="pessoa_seq", name="pessoa_id", allocationSize=1)
public class Pessoa extends AbstractEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pessoa_id") para postgres
	private long id;
	private String nome;
	private String email;
	
	@OneToMany(mappedBy="pessoa", fetch=FetchType.EAGER, cascade = CascadeType.ALL)//EAGER- que quando consultarmos a entidade PessoaFisica, 
	//queremos consultar tamb�m a entidade Cachorro ao mesmo tempo.
	//CascadeType - QUando apagarmos tal pessoa f�sica, apagar� os seus caes.
	private List<Pet> pets;
	
  
	//Dados do Login de Usuario
	@Column(unique = true, nullable=false)
	private String login;
	private String senha;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="Tipo_Usuario")
	private TipoUsuario tipoUsuario;
	
	//ESTADO DA PESSOA
	
	@Temporal(TemporalType.DATE)
	private Date dataCriacao;
	@Temporal(TemporalType.DATE)
	private Date dataUltimaAlteracao;
	
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Pessoa(long id) {
		super();
		this.id = id;
	}
	public Pessoa() {
		super();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public Date getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}
	public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}
	public List<Pet> getPets() {
		return pets;
	}
	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
	
	
	
	
	
	
	
	

}
