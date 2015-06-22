package br.com.petGoHome.servletsNavegacao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.petGoHome.Fachada.Fachada;
import br.com.petGoHome.banner.Banner;

/**
 * Servlet implementation class Index
 */
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro na comunicação com o Banco.</h5></div>";
		HttpSession session = request.getSession();
		
		if(session == null){
			System.out.println("SessÃ£o Nula, retorna Login");
			session = request.getSession(true);
		}else{
			session = request.getSession(false);
		}
		
		String home = "Inicio";
		//Criando os banners
		
		//Criar um try para forçar o sistema a abir uma pagina alternativa para nao mostrar o erro de falha do banco.
		
		try {
			Banner banner1 = Fachada.buscarBannerPorId(1);
			Banner banner2 = Fachada.buscarBannerPorId(2);
			Banner banner3 = Fachada.buscarBannerPorId(3);
			
			request.getSession().setAttribute("banner1", banner1);
			request.getSession().setAttribute("banner2", banner2);
			request.getSession().setAttribute("banner3", banner3);
			
			//Aqui é o tempo de refresh do servlet
			//response.setIntHeader("Refresh", 5);
			response.setIntHeader("Refresh", 3600); //1 hora
			
			
			request.setAttribute("home", home);
			//request.getRequestDispatcher("index.jsp").forward(
			request.getRequestDispatcher("index.jsp").forward(
					request, response);
		} catch (Exception e) {
			request.setAttribute("home", home);
			request.setAttribute("messageErro", messageErro);
			request.getRequestDispatcher("index.jsp").forward(
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
