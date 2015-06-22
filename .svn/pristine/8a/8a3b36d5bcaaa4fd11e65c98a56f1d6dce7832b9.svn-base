package br.com.petGoHome.servletsNavegacao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petGoHome.entidades.Pessoa;
import br.com.petGoHome.entidades.Uf;

/**
 * Servlet implementation class CadastroPaginaPetShop
 */
public class CadastroPaginaPetShop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroPaginaPetShop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		Pessoa pf = new Pessoa();
		pf = (Pessoa) request.getSession().getAttribute("pessoaLogado");
		
		if(pf == null){
			
			response.sendRedirect("Index.pet");
		}else if(pf != null){
			request.setAttribute("ufs", Uf.values());
			request.getRequestDispatcher("paginas/PetShop/cadastro-PetShop.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
