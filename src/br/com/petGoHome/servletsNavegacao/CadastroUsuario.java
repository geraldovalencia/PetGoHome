package br.com.petGoHome.servletsNavegacao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.petGoHome.entidades.*;

/**
 * Servlet implementation class CadastroUsuario
 */
public class CadastroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastroUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Servlet de direcionamento de LINK, somente para personalizar URL
		
		Pessoa pf = new Pessoa();
		pf = (Pessoa) request.getSession().getAttribute("pessoaLogado");
		
		if(pf == null){
			boolean cadastroUser = true;
			request.getSession().setAttribute("ufs", Uf.values());
			request.setAttribute("cadastroUser", cadastroUser);
			request.getRequestDispatcher("cadastroUsuario.jsp").forward(
					request, response);
		}else if(pf != null){
			response.sendRedirect("Index.pet");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
