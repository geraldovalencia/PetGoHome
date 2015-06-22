package br.com.petGoHome.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.petGoHome.Fachada.Fachada;
import br.com.petGoHome.entidades.Tag;

/**
 * Servlet implementation class AutocompletarTag
 */
public class AutocompletarTag extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AutocompletarTag() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int quantidadeTAG = 0;
		String valorTag = request.getParameter("valorTag");
		List<Tag> tags = new ArrayList<Tag>();
		Map<String, String> mapa = new LinkedHashMap<String, String>();

		String json = null;

		
		
		//Entra se for usado o campo de TAG
		if (valorTag != null && !valorTag.equals("")) {
			tags = Fachada.buscarTagPorNome(valorTag);
			quantidadeTAG = tags.size();
			if(quantidadeTAG == 0){
				System.out.println("Sem resultado de JSON.");
				mapa.put("0", "Nenhum Resultado");
			}else{
				for (Tag tag : tags) {
					mapa.put(String.valueOf(tag.getId()), tag.getValorTag());
					System.out.println(tag.getId() + " : " + mapa.put(String.valueOf(tag.getId()), tag.getValorTag()));
				}
			}
		
			
		} else {
			tags = Fachada.listarTodasTAGS();
			for (Tag tag : tags) {
				mapa.put(String.valueOf(tag.getId()), tag.getValorTag());
				System.out.println(tag.getId() + " : " + mapa.put(String.valueOf(tag.getId()), tag.getValorTag()));
			}
		}
		
		
		//Envia JSON

		json = new Gson().toJson(mapa);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		// TODO Auto-generated method stub
	}

}
