package br.com.petGoHome.servletsNavegacao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petGoHome.Fachada.Fachada;
import br.com.petGoHome.entidades.Cachorro;
import br.com.petGoHome.entidades.Pessoa;
import br.com.petGoHome.entidades.PessoaFisica;
import br.com.petGoHome.entidades.TipoUsuario;

/**
 * Servlet implementation class Profile
 */
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		System.out.println("Abriu a pagina que redireciona para a Edição do Perfil.");

		String message = "<div id='msgAlerta' style='width:30%' align='center' class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>x</button><h5>PET removido com sucesso...</h5></div>";
		String messageErro = "<div id='msgAlerta' style='width:30%' align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Não foi possível realizar a ação.</h5></div>";

		String profile = "Perfil";
		String cpfIncompleto = "";


		Pessoa p = new Pessoa();
		p = (Pessoa) request.getSession().getAttribute("pessoaLogado");

		if (p == null) {
			messageErro = "<div id='msgAlerta' style='width:30%' align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Faça o login para realizar essa transação.</h5></div>";
			request.getSession().setAttribute("messageErro", messageErro);
			response.sendRedirect("Index.pet");
		} else if (p != null) {
			if (p.getTipoUsuario() == TipoUsuario.USUARIO) {
				try {
					
					if (p.getTipoUsuario() != TipoUsuario.USUARIO) { // Nada a ver. Mudar isso. foi so p apagar erro
						response.sendRedirect("Index.pet");
						return;
					} else {
						
						String cpf = new String();

						PessoaFisica pf = new PessoaFisica();
						
						pf = Fachada.buscarPessoaFisicaPorId(p.getId());
						System.out.println("A pessoFis é :"+pf.getNome());
						cpf = pf.getCpf();
						
						
						cpfIncompleto = cpf.substring(0, 4) + "***.***-" + cpf.substring(12, 14);
						System.out.println(cpfIncompleto);

						request.setAttribute("profile", profile);
						request.setAttribute("cpfIncompleto", cpfIncompleto);
						request.getRequestDispatcher(
								"AdminLTE-master/paginas/Editar/EditarUsuario.jsp").forward(
								request, response);
						}
				} catch (Exception e) {
					messageErro = "<div id='msgAlerta' style='width:30%' align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Você não tem autorização para apagar este Usuario.</h5></div>";
					request.getSession().setAttribute("messageErro",
							messageErro);
					response.sendRedirect("Index.pet");
				}
				

			}
			if (p.getTipoUsuario() == TipoUsuario.ADMINISTRADOR) {
				try {
					
					if (p.getTipoUsuario() != TipoUsuario.ADMINISTRADOR) { // Nada a ver. Mudar isso. foi so p apagar erro
						response.sendRedirect("Index.pet");
						return;
					} else {

						request.setAttribute("profile", profile);
						request.getRequestDispatcher(
								"AdminLTE-master/paginas/Editar/EditarUsuarioAdm.jsp").forward(
								request, response);
						}
				} catch (Exception e) {
					messageErro = "<div id='msgAlerta' style='width:30%' align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Você não tem autorização para alterar este Usuario.</h5></div>";
					request.getSession().setAttribute("messageErro",
							messageErro);
					System.out.println(e.getMessage());
					response.sendRedirect("Index.pet");
				}
				

			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
