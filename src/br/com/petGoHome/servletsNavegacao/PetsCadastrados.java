package br.com.petGoHome.servletsNavegacao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petGoHome.DAO.PetDao;
import br.com.petGoHome.Fachada.Fachada;
import br.com.petGoHome.entidades.Cachorro;
import br.com.petGoHome.entidades.Gato;
import br.com.petGoHome.entidades.Pessoa;
import br.com.petGoHome.entidades.Pet;

/**
 * Servlet implementation class PetsCadastrados
 */
public class PetsCadastrados extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PetsCadastrados() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// COmo uso link para acesar JSP, precisa ser GET
		
		String meusPetsOn = "Meus Pet's";

		Pessoa pf = new Pessoa();

		
		
		if (request.getSession().getAttribute("pessoaLogado") != null) {

			pf = (Pessoa) request.getSession().getAttribute("pessoaLogado");

			System.out.println(pf.getNome());

			List<Cachorro> dogs = Fachada.listarTodosCachorrosPorDono(pf);
			List<Gato> gatos = Fachada.listarTodosGatosPorDono(pf);
			
			int qtListaDog = dogs.size();
			int qtListaCat = gatos.size();
			int qtListaTotal = qtListaDog + qtListaCat;
			
			
			request.setAttribute("qtLista", qtListaTotal);

				if (dogs.size() > 0) {
					for (Cachorro dog : dogs) {
						System.out.println("Nome do Cão: " + dog.getNome());
						System.out.println("Raça do Cão: "
								+ dog.getRacaCachorro().getNomeRacaCachorro());
					}
				} else {
					System.out.println("Você não possui Cãos cadastrados.");
					dogs = null;
				}

				if (gatos.size() > 0) {
					for (Gato gato : gatos) {
						System.out.println("Nome do gato: " + gato.getNome());
						System.out.println("Raça do gato: "
								+ gato.getRacaGato().getNomeRacaGato());
					}
				} else {
					System.out.println("Você não possui gatos cadastrados.");
					gatos = null;
				}

			// Poderia usar o objeto Pet também, contanto fizesse um instanceof
			// para verificar o tipo e em
			// seguida fazer a busca com o id do Pet, para trazer tal objeto e
			// seus dados - atributos

			request.setAttribute("dogs", dogs);
			request.setAttribute("gatos", gatos);
			request.setAttribute("meusPetsOn", meusPetsOn);

			request.getRequestDispatcher("AdminLTE-master/paginas/Listar/petsCadastrados.jsp")
					.forward(request, response);
		} else {
			System.out
					.println("Tentou acessar página de listagem de Pet's sem estar logado.");
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
