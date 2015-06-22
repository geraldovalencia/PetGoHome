package br.com.petGoHome.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petGoHome.Fachada.Fachada;
import br.com.petGoHome.entidades.Cachorro;
import br.com.petGoHome.entidades.Gato;
import br.com.petGoHome.entidades.Pessoa;
import br.com.petGoHome.entidades.Tag;

/**
 * Servlet implementation class RemoverCachorroServlet
 */
public class RemoverCachorroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoverCachorroServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Abriu remover Cachorro.");

		String message = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>x</button><h5>PET removido com sucesso...</h5></div>";
		String messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! N�o foi poss�vel realizar a a��o.</h5></div>";

		String idDog = request.getParameter("idDog");
		String idPessoa = request.getParameter("idPessoa");

		System.out.println("Id da pessoa: " + idPessoa);
		System.out.println("Id do DOG: " + idDog);

		// OBSERVAR - Esse servlet est� permitindo a exclus�o de gatos de outras
		// pessoas.

		Pessoa pf = new Pessoa();
		pf = (Pessoa) request.getSession().getAttribute("pessoaLogado");

		if (pf == null) {
			messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Fa�a o login para realizar essa transa��o.</h5></div>";
			request.getSession().setAttribute("messageErro", messageErro);
			response.sendRedirect("Index.pet");
		} else if (pf != null) {
			if (idDog != null && idPessoa != null) {

				Cachorro dogEditado = new Cachorro();

				dogEditado = Fachada.buscarCachorroPorId(Long.parseLong(idDog));

				Pessoa p = new Pessoa();

				p = Fachada.buscarPessoaPorId(Long.parseLong(idPessoa));

				// Impede que qualquer pessoa remova Pets aleat�rios, so apaga o
				// pet
				// que estiver registado no ID da mesma
				
				try {
					
					if (dogEditado.getPessoa().getId() != p.getId()) {
						
						response.sendRedirect("Index.pet");
						return;
					} else {

						try {
							dogEditado.setTag(null);
							dogEditado.setPessoa(null); // Zerar a pessoa tambem
							Fachada.alterarPet(dogEditado);
							
							List<Tag> tags = new ArrayList<Tag>();
							
							tags = Fachada.buscarTAGPeloIdDoPet(dogEditado.getId());
							
							if (tags.size() != 0) {
	
								for (Tag tag : tags) {
									
									if(tag != null && tag.getValorTag().equals(dogEditado.getTagNumero()) ){
										tag.setIdPet(null);
										tag.setPet(null);
										tag.setDataAtivacao(null);
										try {
											
											Fachada.alterarTAG(tag);
											Fachada.excluirPet(Long.parseLong(idDog));
										} catch (Exception e) {
											messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro em desvincular Tag do Pet deletado.</h5></div>";
											System.out.println(e.getMessage());
											System.out.println("N�o setou nulo na Tag vinculada ao Pet que est� sendo apagado.");
											request.getSession().setAttribute("messageErro", messageErro);
											response.sendRedirect("Index.pet");
										}
									}else{
										messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro, n�o � poss�vel apagar o PET, o n�mero da Tag � diferente da registrada para o Pet.</h5></div>";
										System.out.println("N�o pode apagar, pois TAG tem valor diferente do registrado no c�o.");
										request.getSession().setAttribute("messageErro", messageErro);
										response.sendRedirect("Index.pet");
									}
								}
							}else{
								Fachada.excluirPet(Long.parseLong(idDog));
							}
							
							System.out.println("Cachorro removido com sucesso.");
							request.getSession().setAttribute("message", message);
							response.sendRedirect("IndexUser.pet");
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println(e.getMessage());
							System.out.println("Erro em Excluir o PET (Cachorro);");
							request.getSession().setAttribute("messageErro",
									messageErro);
							response.sendRedirect("Index.pet");
						}
					}
				} catch (Exception e) {
					messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Voc� n�o tem autoriza��o para apagar este PET.</h5></div>";
					request.getSession().setAttribute("messageErro",
							messageErro);
					response.sendRedirect("Index.pet");
				}
				

			}
		}
	}

}
