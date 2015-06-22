package br.com.petGoHome.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petGoHome.Fachada.Fachada;
import br.com.petGoHome.banner.Banner;
import br.com.petGoHome.banner.HistoricoBanner;
import br.com.petGoHome.entidades.Cachorro;
import br.com.petGoHome.entidades.HistoricoFotosPet;
import br.com.petGoHome.entidades.Pessoa;

/**
 * Servlet implementation class AlterarBanner
 */
public class AlterarBanner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarBanner() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Faça o login para realizar essa transação.</h5></div>";

		Pessoa pf = new Pessoa();
		pf = (Pessoa) request.getSession().getAttribute("pessoaLogado");

		if (pf == null) {
			request.getSession().setAttribute("messageErro", messageErro);
			response.sendRedirect("Index.pet");
		} else if (pf != null) {
			
			Banner b1 = new Banner();
			Banner b2 = new Banner();
			Banner b3 = new Banner();
			
			boolean alterarBanner = (boolean) request.getSession().getAttribute("alterarBanner");
			alterarBanner = true;
			request.getSession().setAttribute("alterarBanner", alterarBanner);

			request.getRequestDispatcher("paginas/Banner/alterar-banner.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String b3 = request.getParameter("banner3");
		String b2 = request.getParameter("banner2");
		String b1 = request.getParameter("banner1");
		
		if(b1 != null && b1.equals("true")){
			
			Banner banner1 = Fachada.buscarBannerPorId(1);
			
			List<HistoricoBanner> hps = new ArrayList<HistoricoBanner>();

			hps = Fachada.buscarHistoricoBannerPorIdBanner(1);
			
			request.setAttribute("banner1", banner1);
			request.setAttribute("hps", hps);

			request.getRequestDispatcher("paginas/Banner/salvar-banner1.jsp")
					.forward(request, response);
		}
		if(b2 != null && b2.equals("true")){
			
			Banner banner2 = Fachada.buscarBannerPorId(2);
			
			List<HistoricoBanner> hps = new ArrayList<HistoricoBanner>();
			
			hps = Fachada.buscarHistoricoBannerPorIdBanner(2);
			
			request.setAttribute("banner2", banner2);
			request.setAttribute("hps", hps);
			
			request.getRequestDispatcher("paginas/Banner/salvar-banner2.jsp")
			.forward(request, response);
		}
		if(b3 != null && b3.equals("true")){
			
			Banner banner3 = Fachada.buscarBannerPorId(3);
			
			List<HistoricoBanner> hps = new ArrayList<HistoricoBanner>();
			
			hps = Fachada.buscarHistoricoBannerPorIdBanner(3);
			
			request.setAttribute("banner3", banner3);
			request.setAttribute("hps", hps);
			
			request.getRequestDispatcher("paginas/Banner/salvar-banner3.jsp")
			.forward(request, response);
		}
	}

}
