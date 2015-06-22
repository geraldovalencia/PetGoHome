package br.com.petGoHome.servletsNavegacao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.petGoHome.Fachada.Fachada;
import br.com.petGoHome.entidades.RacaCachorro;
import br.com.petGoHome.entidades.RacaGato;

/**
 * Servlet implementation class CadastroPet
 */
public class CadastroPet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroPet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String cao = request.getParameter("cao");
		String gato = request.getParameter("gato");
		
		
		//Caso gato ou cachorro sejam nulos, abre JSP para escolha de um
		if (cao == null && gato == null) {
			request.getRequestDispatcher("AdminLTE-master/paginas/Cadastro/cadastroPet.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Post usado apenas para o request depois da escolha do Cao ou GATO
		String cao = request.getParameter("cao");
		String gato = request.getParameter("gato");
		
		//Entrar· no IF se o usuario quiser cadastrar Cao no cadastroPet.JSP
				if (cao == "cao" || cao != null) {

					List<RacaCachorro> racas = new ArrayList<RacaCachorro>();
					
					racas = Fachada.listarTodasRacasCachorro();
					
					for (RacaCachorro racaCachorro : racas) {
						System.out.println("Ra«a : = " + racaCachorro.getNomeRacaCachorro());
					}
					request.setAttribute("racas", racas);
					
					request.getRequestDispatcher("AdminLTE-master/paginas/Cadastro/cadastroPetCachorro.jsp").forward(
							request, response);
				}
				
				//Entrar· no IF se o usuario quiser cadastrar Cao no cadastroPet.JSP
				if (gato == "gato" || gato != null) {

					List<RacaGato> racas = new ArrayList<RacaGato>();
					
					racas = Fachada.listarTodasRacaGato();
					
					//Carregando as racas de gatos
					for (RacaGato racaGato : racas) {
						System.out.println("Ra«a : = " + racaGato.getNomeRacaGato());
					}
					request.setAttribute("racas", racas);
					
					request.getRequestDispatcher("AdminLTE-master/paginas/Cadastro/cadastroPetGato.jsp").forward(
							request, response);
				}
	}

}
