package br.com.petGoHome.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.petGoHome.Fachada.Fachada;
import br.com.petGoHome.entidades.Tag;

/**
 * Servlet implementation class CarregarTagsJSON
 */
public class CarregarTagsJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarregarTagsJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String filtro = request.getParameter("filtro"); 
		if (filtro != null){
			
		System.out.println("ENtrou no JSON");
		
		//LIsta o Numero total de Pessoas do banco
		List<Tag> tagsListaTotal = new ArrayList<Tag>();
		tagsListaTotal = Fachada.listarTodasTAGS(); // comentei pq abaixo quero usar o JS para paginar
		
		String listadeTags = null;
        
		listadeTags = new Gson().toJson(tagsListaTotal);
		
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(listadeTags);
        
		}else{
			System.out.println("veio sem filtro.");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
