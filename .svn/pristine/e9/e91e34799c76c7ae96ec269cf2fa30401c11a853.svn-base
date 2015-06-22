package br.com.petGoHome.servletsNavegacao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petGoHome.Fachada.Fachada;
import br.com.petGoHome.entidades.PessoaFisica;

/**
 * Servlet implementation class EsqueciMinhaSenha
 */
public class EsqueciMinhaSenha extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EsqueciMinhaSenha() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String esquecer = "Esqueci minha senha";

		request.setAttribute("esquecer", esquecer);

		request.getRequestDispatcher("paginas/Senhas/esqueci-minha-senha.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String cpf = request.getParameter("cpf");
		String email = request.getParameter("email");
		String messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Não foi possível enviar o email.</h5></div>";
		String message = "";
		
		
		List<PessoaFisica> fisicas = new ArrayList<PessoaFisica>();
		
		try {
			fisicas = Fachada.buscarPessoafisicaPeloSeuCPFeoEmail(cpf, email);
			
			if(fisicas.size() != 0){
				
				for (PessoaFisica pessoaFisica : fisicas) {
					if(pessoaFisica != null){
						System.out.println("A pessoa fisica que vai enviar email é :" +
									pessoaFisica.getNome());
							if(Fachada.enviarEmailEsqueciSenha(pessoaFisica) == true){
								message = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>x</button><h5>Email enviado com sucesso.<br> Confira o seu correio eletrônico.</h5></div>";
								request.getSession().setAttribute("message", message);
								response.sendRedirect(request.getContextPath()
										+ "/Index.pet");
							}else{
								
								
								request.getSession().setAttribute("messageErro", messageErro);
								response.sendRedirect(request.getContextPath()
										+ "/Index.pet");
							
						}
						
						
					}
				}
			}else{
				messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Dados incorretos.<br> Não foi possível enviar o email.</h5></div>";
				request.getSession().setAttribute("messageErro", messageErro);
				response.sendRedirect(request.getContextPath()
						+ "/Index.pet");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Erro no envio do email");
			request.getSession().setAttribute("messageErro", messageErro);
			response.sendRedirect(request.getContextPath()
					+ "/Index.pet");
		}
	}

}
