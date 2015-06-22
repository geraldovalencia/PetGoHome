package br.com.petGoHome.Servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petGoHome.Fachada.Fachada;
import br.com.petGoHome.entidades.Administrador;
import br.com.petGoHome.entidades.Pessoa;
import br.com.petGoHome.entidades.TipoUsuario;

/**
 * Servlet implementation class CadastroAdmUser
 */
public class CadastroAdmUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroAdmUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String messageErro = "<div id='msgAlerta' style='width:30%' align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Não foi possível realizar a ação.</h5></div>";

		Pessoa p = new Pessoa();
		p = (Pessoa) request.getSession().getAttribute("pessoaLogado");

		if (p == null) {
			messageErro = "<div id='msgAlerta' style='width:30%' align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Faça o login para realizar essa transação.</h5></div>";
			request.getSession().setAttribute("messageErro", messageErro);
			response.sendRedirect("Index.pet");
		} else if (p != null) {
			if (p.getTipoUsuario() == TipoUsuario.ADMINISTRADOR) {
				try {
					
					if (p.getTipoUsuario() != TipoUsuario.ADMINISTRADOR) { // Nada a ver. Mudar isso. foi so p apagar erro
						response.sendRedirect("Index.pet");
						return;
					} else {

						request.getRequestDispatcher(
								"paginas/cadastro-Adm.jsp").forward(
								request, response);
						}
				} catch (Exception e) {
					messageErro = "<div id='msgAlerta' style='width:30%' align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Você não tem autorização para alterar este Usuario.</h5></div>";
					request.getSession().setAttribute("messageErro",
							messageErro);
					System.out.println(e.getMessage());
					response.sendRedirect("Index.pet");
				}
				

			}else{
				messageErro = "<div id='msgAlerta' style='width:30%' align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Você não tem autorização para alterar este Usuario.</h5></div>";
				request.getSession().setAttribute("messageErro",
						messageErro);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String message = "<div id='msgAlerta' style='width:30%' align='center' class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>x</button><h5>Usuário [Administrador] cadastrado com sucesso...</h5></div>";
		String messageErro = "<div id='msgAlerta' style='width:30%' align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Não foi possível realizar a ação.</h5></div>";

		String tagCadastro = "Tag";
		
		String nomeAdm = request.getParameter("nome");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");


		Pessoa p = new Pessoa();
		p = (Pessoa) request.getSession().getAttribute("pessoaLogado");

		if (p == null) {
			messageErro = "<div id='msgAlerta' style='width:30%' align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Faça o login para realizar essa transação.</h5></div>";
			request.getSession().setAttribute("messageErro", messageErro);
			response.sendRedirect("Index.pet");
		} else if (p != null) {
			if (p.getTipoUsuario() == TipoUsuario.ADMINISTRADOR) {
				try {
					
					if (p.getTipoUsuario() != TipoUsuario.ADMINISTRADOR) { // Nada a ver. Mudar isso. foi so p apagar erro
						response.sendRedirect("Index.pet");
						return;
					} else {
						
						Administrador adm = new Administrador();
						
						Date dataHoje = new Date();
						dataHoje = new Date(System.currentTimeMillis());
						
						adm.setDataCriacao(dataHoje);
						adm.setEmail(email);
						adm.setFuncaoNoSistema("administração");
						adm.setLogin(login);
						adm.setSenha(senha);
						adm.setTipoUsuario(TipoUsuario.ADMINISTRADOR);

						request.setAttribute("tagCadastro", tagCadastro);
						
						Fachada.salvarPessoa(adm);
						
						request.getSession().setAttribute("message",
								message);
						response.sendRedirect("Index.pet");
						}
				} catch (Exception e) {
					messageErro = "<div id='msgAlerta' style='width:30%' align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Você não tem autorização para alterar este Usuario.</h5></div>";
					request.getSession().setAttribute("messageErro",
							messageErro);
					System.out.println(e.getMessage());
					response.sendRedirect("Index.pet");
				}
				

			}else{
				messageErro = "<div id='msgAlerta' style='width:30%' align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Você não tem autorização para alterar este Usuario.</h5></div>";
				request.getSession().setAttribute("messageErro",
						messageErro);
			}
		}
		
	}

}
