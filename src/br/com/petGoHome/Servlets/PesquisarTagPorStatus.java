package br.com.petGoHome.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petGoHome.Fachada.Fachada;
import br.com.petGoHome.entidades.Tag;

/**
 * Servlet implementation class PesquisarTagPorStatus
 */
public class PesquisarTagPorStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PesquisarTagPorStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String item = request.getParameter("item");
		String livre = request.getParameter("livre");
		String usado = request.getParameter("usado");
		
		if(item.equals("livre")){
			livre = "livre";
		}else{
			usado = "usado";
		}

		List<String> retornoStatus = new ArrayList<String>();
		String usado2 = "";
		String corDiferente = "";
		String pessoa = "";
		String dataA = "";
		String html = "";
		String readOnly = "readonly='readonly'";

		List<Tag> tags = new ArrayList<Tag>();
		try {
			if (livre != null) {

				tags = Fachada.buscarTagPorStatusLivre();

				for (Tag tag : tags) {

					corDiferente = "<td class='verde'><strong>"
							+ tag.getValorTag() + "</strong></td>";

					usado2 = "<td><span class='badge bg-red'>" + tag.getId()
							+ "</span></td>";
					pessoa = "<td></td>";
					dataA = "<td></td>";

					html = "<tr>" + "<td>" + tag.getId() + "</td>"
							+ corDiferente + "<td>" + tag.getDataCriacao()
							+ "</td>" + dataA + pessoa + usado + "</tr>";

					retornoStatus.add(html);

				}
				
			}
				if (usado != null) {
					tags = Fachada.buscarTagPorStatusUsado();
					
					for (Tag tag : tags) {

						corDiferente = "<td class='laranja'><strong>"
								+ tag.getValorTag() + "</strong></td>";

						usado2 = "<td><span class='badge bg-red'>" + tag.getId()
								+ "</span></td>";
						pessoa = "<td>"+ tag.getPet().getPessoa().getNome() + "</td>";
						dataA = "<td>"+ tag.getDataAtivacao() +"</td>";

						html = "<tr>" + "<td>" + tag.getId() + "</td>"
								+ corDiferente + "<td>" + tag.getDataCriacao()
								+ "</td>" + dataA + pessoa + usado + "</tr>";

						retornoStatus.add(html);

					}
					
					
			}
				String botao = "<div align='left'><a href='Listar-Tags.adm'><button type='button' class='btn btn-primary' role='button'>Limpar Filtro</button></a></div>";
				request.setAttribute("retorno", retornoStatus);
				request.setAttribute("botao", botao);
				request.setAttribute("readOnlyStatus", readOnly);

			
			request.getRequestDispatcher(
					"AdminLTE-master/paginas/Listar/listar-tags.jsp").forward(
					request, response);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			response.sendRedirect("IndexUser.pet");
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
