package br.com.petGoHome.Servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.petGoHome.Fachada.Fachada;
import br.com.petGoHome.entidades.Administrador;
import br.com.petGoHome.entidades.Endereco;
import br.com.petGoHome.entidades.Pessoa;
import br.com.petGoHome.entidades.PessoaFisica;
import br.com.petGoHome.entidades.Sexo;
import br.com.petGoHome.entidades.TipoUsuario;
import br.com.petGoHome.entidades.Uf;

/**
 * Servlet implementation class EditarUsuarioServlet
 */
public class EditarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarUsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String message = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>x</button><h5>PET removido com sucesso...</h5></div>";
		String messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Não foi possível realizar a ação.</h5></div>";

		String profile = "Perfil";
		String cpfIncompleto = "";
		
		Pessoa p = new Pessoa();
		p = (Pessoa) request.getSession().getAttribute("pessoaLogado");

		if (p == null) {
			messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Faça o login para realizar essa transação.</h5></div>";
			request.getSession().setAttribute("messageErro", messageErro);
			response.sendRedirect("Index.pet");
		} else if (p != null) {
			if (p.getTipoUsuario() == TipoUsuario.USUARIO) {
				try {

					if (p.getTipoUsuario() != TipoUsuario.USUARIO) { 
						response.sendRedirect("Index.pet");
						return;
					} else {
						String cpf = new String();

						PessoaFisica pf = new PessoaFisica();
						
						pf = Fachada.buscarPessoaFisicaPorId(p.getId());
						System.out.println("A pessoFis é :"+pf.getNome());
						cpf = pf.getCpf();
						
						
						cpfIncompleto = cpf.substring(0, 4) + "***.***-" + cpf.substring(12, 14);
						
						
						request.setAttribute("ufs", Uf.values());
						request.setAttribute("profile", profile);
						request.setAttribute("cpfIncompleto", cpfIncompleto);
						request.getRequestDispatcher(
								"AdminLTE-master/paginas/Editar/EditarUsuarioRecadastro.jsp")
								.forward(request, response);
					}
				} catch (Exception e) {
					messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Você não tem autorização para alterar este Usuario.</h5></div>";
					request.getSession().setAttribute("messageErro",
							messageErro);
					response.sendRedirect("Index.pet");
				}
			}
			if (p.getTipoUsuario() == TipoUsuario.ADMINISTRADOR) {
				try {

					if (p.getTipoUsuario() != TipoUsuario.ADMINISTRADOR) { // Nada
																			// a
																			// ver.
																			// Mudar
																			// isso.
																			// foi
																			// so
																			// p
																			// apagar
																			// erro
						response.sendRedirect("Index.pet");
						return;
					} else {
						Date dataHoje = new Date();
						dataHoje = new Date(System.currentTimeMillis());

						request.setAttribute("dataHoje", dataHoje);
						request.setAttribute("ufs", Uf.values());
						request.setAttribute("profile", profile);
						request.getRequestDispatcher(
								"AdminLTE-master/paginas/Editar/EditarUsuarioAdmRecadastro.jsp")
								.forward(request, response);
					}
				} catch (Exception e) {
					messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Você não tem autorização para alterar este Usuario.</h5></div>";
					request.getSession().setAttribute("messageErro",
							messageErro);
					response.sendRedirect("Index.pet");
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String message = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>x</button><h5>Alteração realizada com sucesso...</h5></div>";
		String messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Faça o login para realizar esta ação.</h5></div>";
		HttpSession session = request.getSession(false);
		String idUserEditado = request.getParameter("idUserEditado");

		Pessoa p = new Pessoa();
		p = (Pessoa) request.getSession().getAttribute("pessoaLogado");

		if (p == null) {
			request.getSession().setAttribute("messageErro", messageErro);
			response.sendRedirect("Index.pet");
		} else if (p != null && p.getId() == Long.parseLong(idUserEditado)) {

			if (p.getTipoUsuario() == TipoUsuario.ADMINISTRADOR) {
				Pessoa pessoaLogado = null;

				String nome = request.getParameter("nome");
				String email = request.getParameter("email");
				
				Date dataHoje = new Date();
				dataHoje = new Date(System.currentTimeMillis());
								

				Administrador adm = new Administrador();

				adm = Fachada.buscarPessoaADMPorId(Long
						.parseLong(idUserEditado));

				if (adm == null) {
					messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Usuário inexistente.</h5></div>";
					request.getSession().setAttribute("messageErro",
							messageErro);
					response.sendRedirect("Index.pet");
				} else {
					System.out.println("Abriu o Else de edição total");

					if (nome != null && !nome.equals("")) {

						adm.setNome(nome);
						adm.setEmail(email);
						adm.setDataUltimaAlteracao(dataHoje);
						adm.setTipoUsuario(TipoUsuario.ADMINISTRADOR);

						try {
							session = request.getSession(true);
							Fachada.alterarPessoa(adm);
							pessoaLogado = adm;
							session.setAttribute("message", message);
							request.getSession().setAttribute("pessoaLogado",
									pessoaLogado);
							response.sendRedirect("Index.pet");

						} catch (Exception e) {
							session = request.getSession(true);
							System.out.println(e.getMessage());
							System.out.println("Erro em salvar o Cliente.");
							session.setAttribute("messageErro", messageErro);
							response.sendRedirect("Index.pet");
						}
						return;
					}
				}

			}
			if (p.getTipoUsuario() == TipoUsuario.USUARIO) {
				Pessoa pessoaLogado = null;

				String nome = request.getParameter("nome");
				String email = request.getParameter("email");
				String telefone = request.getParameter("telefone");
				String sexo = request.getParameter("sexo");
				String rua = request.getParameter("rua");
				String cep = request.getParameter("cep");
				String cidade = request.getParameter("cidade");
				String bairro = request.getParameter("bairro");
				String numero = request.getParameter("numero");
				String uf = request.getParameter("uf");
				String cpf = request.getParameter("cpf");

				PessoaFisica pf = new PessoaFisica();

				pf = Fachada.buscarPessoaFisicaPorId(Long
						.parseLong(idUserEditado));

				if (pf == null) {
					messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Usuário inexistente.</h5></div>";
					request.getSession().setAttribute("messageErro",
							messageErro);
					response.sendRedirect("Index.pet");
				} else {
					System.out.println("Abriu o Else de edição total");

					if (nome != null && !nome.equals("")) {
						Endereco end = new Endereco();
						end.setBairro(bairro);
						end.setCep(cep);
						end.setCidade(cidade);
						end.setNumero(numero);
						end.setRua(rua);

						pf.setNome(nome);
						pf.setEmail(email);
						pf.setEndereco(end);
						pf.setCpf(cpf);
						pf.setTipoUsuario(TipoUsuario.USUARIO);

						if (sexo.equals("Masculino")) {
							pf.setSexo(Sexo.MASCULINO);
						} else {
							pf.setSexo(Sexo.FEMININO);
						}

						pf.setDataUltimaAlteracao((new Date(System
								.currentTimeMillis())));
						pf.setTelefone(telefone);

						pf.setUf(Uf.valueOf(uf));
						System.out.println("Estado do usuario: " + pf.getUf());

						try {
							session = request.getSession(true);
							Fachada.alterarPessoa(pf);
							pessoaLogado = pf;
							session.setAttribute("message", message);
							request.getSession().setAttribute("pessoaLogado",
									pessoaLogado);
							response.sendRedirect("Index.pet");

						} catch (Exception e) {
							session = request.getSession(true);
							System.out.println(e.getMessage());
							System.out.println("Erro em salvar o Cliente.");
							session.setAttribute("messageErro", messageErro);
							response.sendRedirect("Index.pet");
						}
						return;
					}
				}

			}

		} else {

			messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Não pode acessar esta página.</h5></div>";
			request.getSession().setAttribute("messageErro", messageErro);
			response.sendRedirect("Index.pet");
		}

	}

}
