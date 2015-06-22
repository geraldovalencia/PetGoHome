package br.com.petGoHome.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petGoHome.Fachada.Fachada;
import br.com.petGoHome.entidades.Pessoa;
import br.com.petGoHome.entidades.PetShop;
import br.com.petGoHome.entidades.TipoUsuario;

/**
 * Servlet implementation class ListarPetShopServlet
 */
public class ListarPetShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarPetShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Faça o login para realizar essa transação.</h5></div>";
		String valorPag = request.getParameter("pag");
		
		String listagemPetshop = "ok";
		
		Pessoa p = new Pessoa();
		
		try {
			p = (Pessoa) request.getSession().getAttribute("pessoaLogado");

			if (p == null) {
				request.getSession().setAttribute("messageErro", messageErro);
				response.sendRedirect("Index.pet");
			} else if (p != null) {
				
				
			try {
				if (p.getTipoUsuario() == TipoUsuario.ADMINISTRADOR) {
					
					int qtdePag = Fachada.getQtdePagPetShop();

					//Verificando a Paginação vinda do JSP
					System.out.println("Numero de Pagina = "+ qtdePag);
					
					Integer pag = null;
					try{
						if (valorPag == null || valorPag.equals("0")) {
							pag = 0;
							System.out.println("IF - Página igual a null ou 0");
						}
						else{
							pag = Integer.parseInt(valorPag);
							System.out.println("ELSE_ Conversao da Pag-String to INT");
						}
					}
					catch(NumberFormatException e){
						throw new ServletException("Problema com o parâmetro da paginação");
					}
					
					List<PetShop> petshops = new ArrayList<>();
					petshops = Fachada.listarTodosPetShopLimitados(pag);
					
					//LIsta o Numero total de Pessoas do banco
					List<PetShop> petshopsListaTotal = new ArrayList<>();
					petshopsListaTotal = Fachada.listarTodosPetShops();
					
					int qtLista = petshopsListaTotal.size();
					request.setAttribute("qtLista", qtLista);
					
					
					request.setAttribute("p", p);
					request.setAttribute("petshops", petshops);
					request.setAttribute("listagemPetshop", listagemPetshop);
					request.setAttribute("qtdePages", qtdePag);
					request.getRequestDispatcher(
							"AdminLTE-master/paginas/Listar/listar-todos-petshop.jsp").forward(request,
									response);
				}else{
					messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Não Pode acessar esta página.</h5></div>";
					request.getSession().setAttribute("messageErro",
							messageErro);
					response.sendRedirect("Index.pet");
				}
			} catch (Exception e) {
				messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Na verificação do tipo de Usuário.</h5></div>";
				request.getSession().setAttribute("messageErro",
						messageErro);
				response.sendRedirect("Index.pet");
			}
			}
			
		} catch (Exception e) {
			messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Na verificação do Usuário da sessão.</h5></div>";
			request.getSession().setAttribute("messageErro",
					messageErro);
			response.sendRedirect("Index.pet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
