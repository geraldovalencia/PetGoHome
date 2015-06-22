package br.com.petGoHome.servletsNavegacao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petGoHome.Fachada.Fachada;
import br.com.petGoHome.entidades.Cachorro;
import br.com.petGoHome.entidades.Gato;
import br.com.petGoHome.entidades.Pessoa;
import br.com.petGoHome.entidades.Pet;

/**
 * Servlet implementation class RemoverPetPagina
 */
public class RemoverPetPagina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoverPetPagina() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idDog = request.getParameter("idDog");
		String tipoDog = request.getParameter("tipoDog");
		
		String idGato = request.getParameter("idGato");
		String tipoGato = request.getParameter("tipoGato");
		
		
		String idPessoa = request.getParameter("idPessoa");
		
		System.out.println("ID da PEssoa: " + idPessoa);
		
		
		String messageErro = "<div id='msgAlerta' style='width:30%' align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Não autorizado para realizar a ação.</h5></div>";
		
		if(idPessoa == null || idPessoa.equals("")){
			request.getSession().setAttribute("messageErro", messageErro);
			response.sendRedirect("IndexUser.pet");
		}else{
			Pessoa p = new Pessoa();
			p = (Pessoa) request.getSession().getAttribute("pessoaLogado");

			if (p == null) {
				messageErro = "<div id='msgAlerta' style='width:30%' align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Faça o login para realizar essa transação.</h5></div>";
				request.getSession().setAttribute("messageErro", messageErro);
				response.sendRedirect("Index.pet");
			
			}else 
				if (p != null && idPessoa != null && p.getId() == Integer.parseInt(idPessoa)
					|| !idPessoa.equals("")) {
				
					
				if(tipoDog == null){
					tipoDog = "";
				}
				if(tipoGato == null){
					tipoGato = "";
				}
				
				if(idDog == null){
					idDog = "";
				}
				if(idGato == null){
					idGato = "";
				}
				
				if(!idDog.equals("") && !tipoDog.equals("") ){
					
					Cachorro dog = new Cachorro();
					dog = Fachada.buscarCachorroPorId(Integer.parseInt(idDog));
					
					tipoDog = "cachorro";
					
					request.setAttribute("dog", dog);
					request.setAttribute("tipoDog", tipoDog);
					
					request.getRequestDispatcher("AdminLTE-master/paginas/Remover/removerPet.jsp")
					.forward(request, response);
					
				}
					
					
					if(!idGato.equals("") && !idGato.equals("") ){
						
						Gato gato = new Gato();
						gato = Fachada.buscarGatoPorId(Integer.parseInt(idGato));
						
						tipoGato = "gato";
						
						request.setAttribute("gato", gato);
						request.setAttribute("tipoGato", tipoGato);
						
						request.getRequestDispatcher("AdminLTE-master/paginas/Remover/removerPet.jsp")
						.forward(request, response);
						
					}
					
				
			}
		}
		
		
		
	}

}
