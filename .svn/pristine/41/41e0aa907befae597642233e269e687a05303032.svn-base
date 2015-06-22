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
import br.com.petGoHome.entidades.Pet;
import br.com.petGoHome.entidades.Tag;

/**
 * Servlet implementation class PesquisarPessoa
 */
public class PesquisarPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PesquisarPessoa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idPessoa = request.getParameter("idPessoa");
		List<String> retorno = new ArrayList<String>();
		String html = "";
		Pessoa p = new Pessoa();
		
		if(!idPessoa.equals("") && idPessoa != null){
			
			List<Pessoa> pessoas = new ArrayList<Pessoa>();
			p = Fachada.buscarPessoaPorId(Integer.parseInt(idPessoa));
			System.out.println("A Pessoa CLICADA FOI: "+p.getNome());
			
			String usado = "";
			String corDiferente = "";
			String pessoa = "";
			String dataA = "" ;
			String readOnly = "readonly='readonly'";
			
		//Validando a Cor do Valor da Pessoa
			List<Pet> pets = new ArrayList<Pet>();
			pets = p.getPets();
			
			for (Pet pet : pets) {
				if(pet.getId() != 0 && pet.getIdTag() != 0){
					
					corDiferente = "<td class='laranja'><strong>"+pet.getTagNumero()+"</strong></td>";
					
					Tag tag = new Tag();
					tag = Fachada.buscarTAGPorId(pet.getIdTag());
					
					usado = "<td><span class='badge bg-red'>"+pet.getIdTag()+"</span></td>";
					pessoa = "<td>"+ p.getNome()+"</td>";
					dataA = "<td>"+tag.getDataAtivacao()+"</td>";
					
					html = "<tr>"
							+ "<td>"+pet.getIdTag()+"</td>"
							+  corDiferente 
							+ "<td>"+tag.getDataCriacao()+"</td>"
							+ dataA
							+ pessoa	
							+  usado
							+ "</tr>";
					
					retorno.add(html);
					
				}else if(pet.getIdTag() != 0){
					corDiferente = "<td class='txt-verde'><strong>"+pet.getTagNumero()+"</strong></td>";
					usado = "<td><span class='badge bg-green'>(livre)</span></td>";
					pessoa = "<td></td>";
					dataA = "<td></td>";
					html = "<tr>"
							+ "<td>"+pet.getTag().getId()+"</td>"
							+  corDiferente 
							+ "<td>"+pet.getTag().getDataCriacao()+"</td>"
							+ dataA
							+ pessoa	
							+  usado
							+ "</tr>";
					
					retorno.add(html);
				}
			}
			
			
			
			String botao = "<div align='left'><a href='Listar-Tags.adm'><button type='button' class='btn btn-primary' role='button'>Limpar Filtro</button></a></div>";
			String filtro = p.getNome();
			
			
			
			request.setAttribute("retorno", retorno);
			request.setAttribute("readOnlyUser", readOnly);
			request.setAttribute("filtroUser", filtro);
			request.setAttribute("botao", botao);
			request.getRequestDispatcher(
					"AdminLTE-master/paginas/Listar/listar-tags.jsp").forward(
					request, response);
			System.out.println(retorno);
		}else{
			response.sendRedirect("Listar-Pessoas.adm");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
