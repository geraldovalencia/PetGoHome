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

import br.com.petGoHome.Fachada.Fachada;
import br.com.petGoHome.entidades.Pessoa;
import br.com.petGoHome.entidades.Tag;

import com.google.gson.Gson;

/**
 * Servlet implementation class AutoCompletarPessoa
 */
public class AutoCompletarPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoCompletarPessoa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int quantidadeTAG = 0;
		String nomePessoa = request.getParameter("nomePessoa");
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		Map<String, String> mapa = new LinkedHashMap<String, String>();

		String json = null;

		
		
		//Entra se for usado o campo de TAG
		if (nomePessoa != null && !nomePessoa.equals("")) {
			pessoas = Fachada.buscarPessoaPorNome(nomePessoa);
			quantidadeTAG = pessoas.size();
			if(quantidadeTAG == 0){
				System.out.println("Sem resultado de JSON.");
				mapa.put("0", "Nenhum Resultado");
			}else{
				for (Pessoa pessoa : pessoas) {
					mapa.put(String.valueOf(pessoa.getId()), pessoa.getNome());
					System.out.println(pessoa.getId() + " : " + mapa.put(String.valueOf(pessoa.getId()), pessoa.getNome()));
				}
			}
		
			
		}
		
		
		//Envia JSON

		json = new Gson().toJson(mapa);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
