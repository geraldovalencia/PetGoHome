package br.com.petGoHome.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.petGoHome.Fachada.Fachada;
import br.com.petGoHome.entidades.Endereco;
import br.com.petGoHome.entidades.Pessoa;
import br.com.petGoHome.entidades.PessoaFisica;
import br.com.petGoHome.entidades.Sexo;
import br.com.petGoHome.entidades.Uf;
import br.com.petGoHome.entidades.TipoUsuario;


public class CadastroUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastroUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String message = "<div id='msgAlerta' style='width:30%' ' align='center' class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button><h5>Cadastro realizado com sucesso...</h5></div>";
		String messageErro = "<div id='msgAlerta' style='width:30%' ' align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><img src='img/exclamacao.png' /><h5>Erro! Tente cadastrar outro Usuário.</h5></div>";
		HttpSession session = request.getSession(false);
		
		Pessoa pessoaLogado = null;
		
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String sexo = request.getParameter("sexo");
		String rua = request.getParameter("rua");
		String cep = request.getParameter("cep");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String numero = request.getParameter("numero");
		String uf = request.getParameter("uf");
		String cpf = request.getParameter("cpf");
		String login = request.getParameter("login");
		
		if(nome != null && !nome.equals("")){
			PessoaFisica pf = new PessoaFisica();
			Endereco end = new Endereco();
			end.setBairro(bairro);
			end.setCep(cep);
			end.setCidade(cidade);
			end.setNumero(numero);
			end.setRua(rua);
			
			pf.setNome(nome);
			pf.setEmail(email);
			pf.setEndereco(end);
			pf.setCpf(cpf);
			
			List<Pessoa> logins = new ArrayList<Pessoa>();
			
			logins = Fachada.listarLoginsExistentes(login);
			
			if(logins.size() != 0){
				System.out.println("Lista de login, não veio vazia.");
				for (Pessoa p : logins) {
					if(p.getLogin().equals(login)){
						System.out.println("login, já existe: "+login);
						
						String loginExiste= "O login já existe. Por favor preencha novamente";
						
						messageErro = "<div id='msgAlerta' style='width:30%' ' align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><img src='img/exclamacao.png' /><h5>"+loginExiste +"</h5></div>";
						request.setAttribute("messageErro", messageErro);
						request.setAttribute("nome", nome);
						request.setAttribute("loginExiste", loginExiste);
						request.setAttribute("email", email);
						request.setAttribute("telefone", telefone);
						request.setAttribute("sexo", sexo);
						request.setAttribute("cep", cep);
						request.setAttribute("cpf", cpf);
						request.setAttribute("ufs", Uf.values());
						
						request.getRequestDispatcher(
								"paginas/cadastroUsuario.jsp").forward(
								request, response);
					}
				}
				
			}else{
				
				pf.setLogin(login);
				pf.setTipoUsuario(TipoUsuario.USUARIO);
				
				
				if(sexo.equals("Masculino")){
					pf.setSexo(Sexo.MASCULINO);
				}else{
					pf.setSexo(Sexo.FEMININO);
				}
				
				pf.setSenha(senha);
				pf.setDataCriacao(new Date( System.currentTimeMillis()));
				//pf.setCpf(cpf);
				pf.setTelefone(telefone);
				
				pf.setUf(Uf.valueOf(uf));
				System.out.println("Estado do usuario: "+ pf.getUf());
				
				try {
					session = request.getSession(true);
					Fachada.salvarPessoa(pf);
					pessoaLogado = pf;
					session.setAttribute("message", message);
					request.getSession().setAttribute("pessoaLogado", pessoaLogado);
					response.sendRedirect("Index.pet");
					
				} catch(Exception e){
					session = request.getSession(true);
					System.out.println(e.getMessage());
					System.out.println("Erro em salvar o Cliente.");
					session.setAttribute("messageErro", messageErro);
					response.sendRedirect("Index.pet");
				}
				return;
			}
			
			
			
		}
		
	}

}
