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
 * Servlet implementation class PesquisarFiltroTAG
 */
public class PesquisarFiltroTAG extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PesquisarFiltroTAG() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String idvalorTag = request.getParameter("idvalorTag");
		
		if(!idvalorTag.equals("") && idvalorTag != null){
			
			List<Tag> tags = new ArrayList<Tag>();
			Tag tag = new Tag();
			tag = Fachada.buscarTAGPorId(Integer.parseInt(idvalorTag));
			System.out.println("A TAG CLICADA FOI: "+tag.getValorTag());
			
			String retorno = "";
			String usado = "";
			String corDiferente = "";
			String pessoa = "";
			String dataA = "" ;
			String readOnly = "readonly='readonly'";
			
		//Validando a Cor do Valor da TAG
			if(tag.getPet() != null){
				corDiferente = "<td class='laranja'><strong>"+tag.getValorTag()+"</strong></td>";
				usado = "<td><span class='badge bg-red'>"+tag.getId()+"</span></td>";
				pessoa = "<td>"+ tag.getPet().getPessoa().getNome()+"</td>";
				dataA = "<td>"+ tag.getDataAtivacao()+"</td>";
				
			}else{
				corDiferente = "<td class='txt-verde'><strong>"+tag.getValorTag()+"</strong></td>";
				usado = "<td><span class='badge bg-green'>(livre)</span></td>";
				pessoa = "<td></td>";
				dataA = "<td></td>";
			}
			
			String botao = "<div align='left'><a href='Listar-Tags.adm'><button type='button' class='btn btn-primary' role='button'>Limpar Filtro</button></a></div>";
			String filtro = tag.getValorTag();
			
			retorno = "<tr>"
					+ "<td>"+ tag.getId()+"</td>"
					+  corDiferente 
					+ "<td>"+ tag.getDataCriacao()+"</td>"
					+ dataA
					+ pessoa	
					+  usado
					+ "</tr>";
			
			request.setAttribute("retorno", retorno);
			request.setAttribute("readOnly", readOnly);
			request.setAttribute("filtro", filtro);
			request.setAttribute("botao", botao);
			request.getRequestDispatcher(
					"AdminLTE-master/paginas/Listar/listar-tags.jsp").forward(
					request, response);
			System.out.println(retorno);
		}else{
			response.sendRedirect("Listar-Tags.adm");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		
	}

}
