package br.com.petGoHome.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petGoHome.Fachada.Fachada;
import br.com.petGoHome.entidades.Administrador;
import br.com.petGoHome.entidades.Pessoa;
import br.com.petGoHome.entidades.PessoaFisica;
import br.com.petGoHome.entidades.TipoUsuario;
import br.com.petGoHome.entidades.Uf;

/**
 * Servlet implementation class AlterarSenha
 */
public class AlterarSenha extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlterarSenha() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String message = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>x</button><h5>Senha alterada com sucesso...</h5></div>";
		String messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Não foi possível realizar a ação.</h5></div>";

		Pessoa p = new Pessoa();
		p = (Pessoa) request.getSession().getAttribute("pessoaLogado");

		if (p == null) {
			messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Faça o login para realizar essa transação.</h5></div>";
			request.getSession().setAttribute("messageErro", messageErro);
			response.sendRedirect("Index.pet");
		} else if (p != null) {
			if (p.getTipoUsuario() == TipoUsuario.USUARIO) {
				try {

					request.getRequestDispatcher(
							"AdminLTE-master/paginas/Senhas/trocar-senha-user.jsp").forward(
							request, response);
				} catch (Exception e) {
					messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Você não tem autorização para alterar este Usuario.</h5></div>";
					request.getSession().setAttribute("messageErro",
							messageErro);
					response.sendRedirect("Index.pet");
				}
			}
			if (p.getTipoUsuario() == TipoUsuario.ADMINISTRADOR) {
				try {

					request.getRequestDispatcher(
							"AdminLTE-master/paginas/Senhas/trocar-senha-adm.jsp").forward(
							request, response);
				} catch (Exception e) {
					messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Você não tem autorização para alterar este Usuario.</h5></div>";
					request.getSession().setAttribute("messageErro",
							messageErro);
					response.sendRedirect("Index.pet");
				}
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String message = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>x</button><h5>Senha alterada com sucesso...</h5></div>";
		String messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Não foi possível realizar a ação.</h5></div>";

		String senha = request.getParameter("senha");
		String senha2 = request.getParameter("senha2");
		String cpf = request.getParameter("cpf");

		Pessoa p = new Pessoa();
		p = (Pessoa) request.getSession().getAttribute("pessoaLogado");

		if (p == null) {
			messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Faça o login para realizar essa transação.</h5></div>";
			request.getSession().setAttribute("messageErro", messageErro);
			response.sendRedirect("Index.pet");
		} else if (p != null) {
			if (p.getTipoUsuario() == TipoUsuario.USUARIO) {
				
				List<PessoaFisica> pfs = new ArrayList<PessoaFisica>();
				
				try {
				
				pfs = Fachada.buscarPessoaFisicaPorCPF(cpf);
				
				if(pfs.size() != 0){
					
					for (PessoaFisica pessoaFisica : pfs) {
						if(pessoaFisica.getCpf().equals(cpf)){
							pessoaFisica.setSenha(Fachada.criptografarSenhaMd5(senha));
							
							Fachada.alterarPessoa(pessoaFisica);
							System.out.println("Alterou a senha e mergou PF.");
							Fachada.enviarEmailTrocaDeSenha(senha, pessoaFisica);
						}
					}
					request.getSession().setAttribute("message",
							message);
					response.sendRedirect("Index.pet");
				}else{
					
					messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Nenhum usuário encontrado.</h5></div>";
					request.getSession().setAttribute("messageErro",
							messageErro);
					response.sendRedirect("Index.pet");
				}
				
				} catch (Exception e) {
					messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro na alteração da senha.</h5></div>";
					request.getSession().setAttribute("messageErro",
							messageErro);
					response.sendRedirect("Index.pet");
				}
			}
			if (p.getTipoUsuario() == TipoUsuario.ADMINISTRADOR) {
				Pessoa pfs = new Pessoa();
				
				try {
				
				pfs = Fachada.buscarAdministradorPorId(p.getId());
				
				pfs.setSenha(Fachada.criptografarSenhaMd5(senha));
							
							Fachada.alterarPessoa(pfs);
							System.out.println("Alterou a senha e mergou PF.");
							Fachada.enviarEmailTrocaDeSenha(senha, pfs);
					request.getSession().setAttribute("message",
							message);
					response.sendRedirect("Index.pet");
					
				
				} catch (Exception e) {
					messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro na alteração da senha.</h5></div>";
					request.getSession().setAttribute("messageErro",
							messageErro);
					response.sendRedirect("Index.pet");
				}
			}

		}
	}

}
