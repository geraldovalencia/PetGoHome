package br.com.petGoHome.Servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petGoHome.Fachada.Fachada;
import br.com.petGoHome.entidades.Tag;

/**
 * Servlet implementation class CadastroTag
 */
public class CadastroTag extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastroTag() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String message = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>x</button><h5>Cadastro da TAG realizado com sucesso...</h5></div>";
		
		String valorTag = request.getParameter("valorTag");

		// Pegando a Data

		Date dataInicioCadastro = new Date( System.currentTimeMillis());

		if (valorTag != null && dataInicioCadastro != null ) {

			try {
				
				Tag tag = new Tag();
				
				// Convertendo a data string para calendar
					tag.setDataCriacao(dataInicioCadastro);
					tag.setValorTag(valorTag);
					Fachada.salvarTAG(tag);
					request.getSession().setAttribute("message", message);
					response.sendRedirect("Index.pet");

			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Erro Na criação da TAG.");

			}

		}
	}

}
