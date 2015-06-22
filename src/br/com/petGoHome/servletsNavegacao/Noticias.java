package br.com.petGoHome.servletsNavegacao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Noticias
 */
public class Noticias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Noticias() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String id1 = request.getParameter("id1");
		String id2 = request.getParameter("id2");
		String id3 = request.getParameter("id3");
		String id4 = request.getParameter("id4");
		
		if(id1 != null && id1.equals("PY$X6LDD")){
			
			System.out.println("O ID é: "+id1);
			request.getSession().setAttribute("id1", id1);
			request.getRequestDispatcher("paginas/Noticias/noticia-1.jsp").forward(
					request, response);
		}
		if(id2 != null && id2.equals("3JRROL8Z")){
			
		    response.sendRedirect("Cadastro-do-seu.pet");
			
		//	request.getSession().setAttribute("id2", id2);
		//	request.getRequestDispatcher("paginas/Noticias/noticia-2.jsp").forward(
		//			request, response);
		}
		if(id3 != null && id3.equals("ZS8BM03C")){
			
			response.sendRedirect("Como-funciona.pet");
		}
		if(id4 != null && id4.equals("O1FHKYCB")){
			
			response.sendRedirect("Contato.pet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
