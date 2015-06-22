package br.com.petGoHome.servletsNavegacao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petGoHome.Fachada.Fachada;

/**
 * Servlet implementation class Contato
 */
public class Contato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contato() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//
		

		boolean contato = true;
		
		request.setAttribute("contato", contato);
		
		request.getRequestDispatcher("contato.jsp").forward(
				request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Variavel usada quando chega email do PET ENCONTRADO
		String emailFindPet = request.getParameter("emailFindPet");
		String emailLocalizaPet = request.getParameter("emailLocalizaPet");
		String tagDoPet = request.getParameter("tagDoPet");
		
		System.out.println(emailFindPet);
		System.out.println(emailLocalizaPet);
		
		String nome = request.getParameter("nome");
		String emailRemetente = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String mensagem = request.getParameter("mensagem");
		
		String message = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>x</button><h5>Mensagem enviada com sucesso.<br> Aguarde o nosso contato. Obrigado!</h5></div>";
		String messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Não foi possível realizar a ação.</h5></div>";
		
		if(telefone == null || telefone == ""){
			telefone = "Sem número";
		}
		if(nome == null || nome == ""){
			nome = "Anônimo";
		}
		
		//Se o request vem do Encontrei-Pet, Entra aqui....
		if(emailFindPet != null){
			try {
				Fachada.enviarEmailContato(nome, emailRemetente, telefone, emailLocalizaPet, mensagem, tagDoPet);
				request.getSession().setAttribute("message", message);
				response.sendRedirect("Index.pet");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Erro- não enviou email do Encontrei PET");
				request.getSession().setAttribute("messageErro", messageErro);
				response.sendRedirect("Index.pet");
			}
		}else{//Senão, o request veio do Contato Formulario
			try {
				Fachada.enviarEmailGenerico(nome, emailRemetente, telefone, mensagem);
				request.getSession().setAttribute("message", message);
				response.sendRedirect("Index.pet");
			} catch (Exception e) {
				System.out.println(e.getMessage());
				request.getSession().setAttribute("messageErro", messageErro);
				response.sendRedirect("Index.pet");
			}
		}
	}

}
