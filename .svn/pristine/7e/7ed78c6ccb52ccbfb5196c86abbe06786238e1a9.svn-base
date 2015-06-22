package br.com.petGoHome.servletsNavegacao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petGoHome.entidades.Pessoa;
import br.com.petGoHome.entidades.TipoUsuario;

/**
 * Servlet implementation class CadastroPaginaTag
 */
public class CadastroPaginaTag extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroPaginaTag() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String message = "<div id='msgAlerta' style='width:30%' align='center' class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>x</button><h5>TAG Cadastrada com sucesso...</h5></div>";
		String messageErro = "<div id='msgAlerta' style='width:30%' align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Não foi possível realizar a ação.</h5></div>";

		String tagCadastro = "Tag";


		Pessoa p = new Pessoa();
		p = (Pessoa) request.getSession().getAttribute("pessoaLogado");

		if (p == null) {
			messageErro = "<div id='msgAlerta' style='width:30%' align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Faça o login para realizar essa transação.</h5></div>";
			request.getSession().setAttribute("messageErro", messageErro);
			response.sendRedirect("Index.pet");
		} else if (p != null) {
			if (p.getTipoUsuario() == TipoUsuario.ADMINISTRADOR) {
				try {
					
					if (p.getTipoUsuario() != TipoUsuario.ADMINISTRADOR) { // Nada a ver. Mudar isso. foi so p apagar erro
						response.sendRedirect("Index.pet");
						return;
					} else {

						request.setAttribute("tagCadastro", tagCadastro);
						request.getRequestDispatcher(
								"paginas/Tag/cadastro-da-tag.jsp").forward(
								request, response);
						}
				} catch (Exception e) {
					messageErro = "<div id='msgAlerta' style='width:30%' align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Você não tem autorização para alterar este Usuario.</h5></div>";
					request.getSession().setAttribute("messageErro",
							messageErro);
					System.out.println(e.getMessage());
					response.sendRedirect("Index.pet");
				}
				

			}else{
				messageErro = "<div id='msgAlerta' style='width:30%' align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Você não tem autorização para alterar este Usuario.</h5></div>";
				request.getSession().setAttribute("messageErro",
						messageErro);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
