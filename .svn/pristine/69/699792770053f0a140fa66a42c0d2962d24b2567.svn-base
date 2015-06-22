package br.com.petGoHome.Servlets;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import br.com.petGoHome.Fachada.Fachada;
import br.com.petGoHome.entidades.Cachorro;
import br.com.petGoHome.entidades.HistoricoFotosPet;
import br.com.petGoHome.entidades.Pessoa;

/**
 * Servlet implementation class AlterarFoto
 */
public class AlterarFoto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlterarFoto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String idDog = request.getParameter("idDog");
		String idPessoa = request.getParameter("idPessoa");

		String messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Faça o login para realizar essa transação.</h5></div>";

		Pessoa pf = new Pessoa();
		pf = (Pessoa) request.getSession().getAttribute("pessoaLogado");

		if (pf == null) {
			request.getSession().setAttribute("messageErro", messageErro);
			response.sendRedirect("Index.pet");
		} else if (pf != null) {

			// Verifica se a pessoa é a dona do cachorro na sessao.
			if (idDog != null && pf.getId() == Long.parseLong(idPessoa)) {

				Cachorro dog = Fachada.buscarCachorroPorId(Long
						.parseLong(idDog));
				List<HistoricoFotosPet> hps = new ArrayList<HistoricoFotosPet>();

				hps = Fachada.buscarHistoricoPetCompletoPorId(Long
						.parseLong(idDog));

				request.setAttribute("hps", hps);
				request.setAttribute("dog", dog);

				request.getRequestDispatcher("AdminLTE-master/paginas/Editar/EditarFoto.jsp")
						.forward(request, response);
			}else{
				messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Não tem autorização para realizar essa transação.</h5></div>";
				request.getSession().setAttribute("messageErro",
						messageErro);
				response.sendRedirect("Index.pet");
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
		String nomeImagem = "";
		String idDogEditado = request.getParameter("idDogEditado");
		String message = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>x</button><h5>Foto do PET alterada com sucesso...</h5></div>";
		String messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro na alteração da foto! Tente outra vez.</h5></div>";

		Pessoa pf = new Pessoa();
		pf = (Pessoa) request.getSession().getAttribute("pessoaLogado");

		if (pf == null) {
			messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Faça o login para realizar essa transação.</h5></div>";
			request.getSession().setAttribute("messageErro", messageErro);
			response.sendRedirect("Index.pet");
		} else if (pf != null) {

			if (isMultiPart) {
				ServletFileUpload upload = new ServletFileUpload();
				try {
					FileItemIterator itr = upload.getItemIterator(request);
					while (itr.hasNext()) {
						FileItemStream item = itr.next();
						if (item.isFormField()) {
							String fieldName = item.getFieldName();

							InputStream is = item.openStream();
							byte[] b = new byte[is.available()];
							is.read(b);
							String value = new String(b);
							if (fieldName.equals("idDogEditado")) {
								idDogEditado = value;
							}
							System.out.println(fieldName + ":" + value + "!");
						} else {
							// faça o file upload specifico processo
							String path = getServletContext().getRealPath("/");
							// chame o metodo de upload do file
							Cachorro dog = new Cachorro();

							// Buscando cachorro editado
							dog = Fachada.buscarCachorroPorId(new Long(
									idDogEditado));
							nomeImagem = Fachada.processandoArquivo(path, item);
							if (nomeImagem != null && idDogEditado != null && dog.getPessoa().getId() == pf.getId()) {
								System.out.println("File enviado com sucesso.");
								System.out.println("Caminho: " + path);
								System.out.println("Item: " + item);
								// Setando nome da nova foto
								dog.setNomeImagem(nomeImagem);

								// Salvando alteração da foto no PET
								Fachada.alterarPet(dog);

								// Setando foto no historico do PET
								HistoricoFotosPet hp = new HistoricoFotosPet();
								hp.setNomeFoto(nomeImagem);
								hp.setDataAlteracao(new Date(System
										.currentTimeMillis()));
								hp.setPetId(dog.getId());
								Fachada.salvarHistoricoPet(hp);

								System.out.println("Nome Foto Final: "
										+ nomeImagem);

								request.getSession().setAttribute("message",
										message);
								response.sendRedirect("Pets-Cadastrados.pets");

							} else {
								System.out
										.println("Erro no envio do File. Nome Imagem é nulo");
								request.getSession().setAttribute(
										"messageErro", messageErro);
								response.sendRedirect("Index.pet");
							}
						}

					}
				} catch (FileUploadException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
					System.out.println("Erro alterar foto do Pet.");
					request.getSession().setAttribute("messageErro",
							messageErro);
					response.sendRedirect("Index.pet");
				}
			}// else nao faz nada
		}
	}
}
