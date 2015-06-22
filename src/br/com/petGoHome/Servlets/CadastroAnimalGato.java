package br.com.petGoHome.Servlets;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import br.com.petGoHome.entidades.Gato;
import br.com.petGoHome.entidades.HistoricoFotosPet;
import br.com.petGoHome.entidades.Pessoa;
import br.com.petGoHome.entidades.RacaCachorro;
import br.com.petGoHome.entidades.RacaGato;
import br.com.petGoHome.entidades.Sexo;
import br.com.petGoHome.entidades.TipoAnimal;

/**
 * Servlet implementation class CadastroAnimalGato
 */
public class CadastroAnimalGato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastroAnimalGato() {
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

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String message = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>x</button><h5>Cadastro do PET realizado com sucesso...</h5></div>";
		String messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Tente outra vez.</h5></div>";

		String nomeGato = request.getParameter("nomeGato");
		String racaGato = request.getParameter("racaGato");
		String sexo = request.getParameter("sexo");
		String cor = request.getParameter("cor");
		String tag = request.getParameter("tag");
		String descricao = request.getParameter("descricao");

		// Pegando a Data
		String birthday_day = request.getParameter("birthday_day");
		String birthday_month = request.getParameter("birthday_month");
		String birthday_year = request.getParameter("birthday_year");

		// String dataNascimento = birthday_day
		// + "-" + birthday_month
		// + "-" + birthday_year;
		RacaGato rcGato = null;
		Gato gato = new Gato();
		String nomeImagem = "";

		// pega o multi part do form

		Pessoa pf = new Pessoa();
		pf = (Pessoa) request.getSession().getAttribute("pessoaLogado");

		if (pf == null) {
			messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Fa�a o login para realizar essa transa��o.</h5></div>";
			request.getSession().setAttribute("messageErro", messageErro);
			response.sendRedirect("Index.pet");
		} else if (pf != null) {

			boolean isMultiPart = ServletFileUpload.isMultipartContent(request);

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
							if (fieldName.equals("nomeGato")) {
								nomeGato = value;
							}
							if (fieldName.equals("racaGato")) {
								racaGato = value;
							}
							if (fieldName.equals("sexo")) {
								sexo = value;
							}
							if (fieldName.equals("cor")) {
								cor = value;
							}
							if (fieldName.equals("tag")) {
								tag = value;
							}
							if (fieldName.equals("descricao")) {
								descricao = value;
							}
							if (fieldName.equals("birthday_day")) {
								birthday_day = value;
							}
							if (fieldName.equals("birthday_month")) {
								birthday_month = value;
							}
							if (fieldName.equals("birthday_year")) {
								birthday_year = value;
							}
							System.out.println(fieldName + ":" + value + "!");
						} else {
							// fa�a o file upload specifico processo
							String path = getServletContext().getRealPath("/");
							// chame o metodo de upload do file
							nomeImagem = Fachada.processandoArquivo(path, item);
							if (nomeImagem != null) {
								System.out.println("File enviado com sucesso.");
								System.out.println("Caminho: " + path);
								System.out.println("Item: " + item);
								gato.setNomeImagem(nomeImagem);
								System.out.println("Nome Foto Final: "
										+ nomeImagem);
							} else {
								System.out.println("Erro no envio do File ou n�o foi enviado foto");

							}
						}

					}
				} catch (FileUploadException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
			}// else nao faz nada

			String dataNascimento = birthday_day + "-" + birthday_month + "-"
					+ birthday_year;

			try {
				gato.setNome(nomeGato);
				gato.setCor(cor);
				gato.setDescricao(descricao);

				// Convertendo a data string para calendar
				if (dataNascimento != null) {

					SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
					try {
						Date dataAnimalNascimento = format
								.parse(dataNascimento);
						gato.setDataNascimentoPet(dataAnimalNascimento);
						System.out.println("Converteu data: "
								+ gato.getDataNascimentoPet().toString());
					} catch (ParseException e) {
						System.out.println(e.getMessage());
						System.out.println("Erro na conversao da data");
						e.printStackTrace();
					}

					// try {
					// DateFormat formatter = new
					// SimpleDateFormat("dd/MM/yyyy");
					// dataAnimalNascimento =
					// (java.util.Date)formatter.parse(dataNascimento);
					// dog.setDataNascimentoPet(dataAnimalNascimento);
					// System.out.println("Converteu data: "+
					// dog.getDataNascimentoPet().toString());
					//
					// } catch (Exception e) {
					// System.out.println("Erro na convers�o da data.");
					// e.getMessage();
					// e.printStackTrace();
					// }
				}
				if (racaGato != null) {

					rcGato = Fachada.buscarRacaGatoPorId(Long
							.parseLong(racaGato));
					System.out.println("Raca do Gato �: "
							+ rcGato.getNomeRacaGato());
					gato.setRacaGato(rcGato);

				}
				if (sexo.equals("Masculino")) {
					gato.setSexo(Sexo.MASCULINO);
				} else {
					gato.setSexo(Sexo.FEMININO);
				}
				System.out.println("Sexo do c�o: " + gato.getSexo());

				gato.setTipoAnimal(TipoAnimal.GATO);

				try {

					gato.setPessoa(pf);
					gato.setIdPessoa(pf.getId());

					HistoricoFotosPet hp = new HistoricoFotosPet();
					hp.setNomeFoto(nomeImagem);
					hp.setDataAlteracao(new Date(System.currentTimeMillis()));
					Fachada.salvarPet(gato);
					hp.setPetId(gato.getId());
					Fachada.salvarHistoricoPet(hp);
					request.getSession().setAttribute("message", message);
					response.sendRedirect("IndexUser.pet");

				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println("Erro em salvar o Pet.");
					request.getSession().setAttribute("messageErro",
							messageErro);
					response.sendRedirect("Index.pet");
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
				messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Tente outra vez preenchendo todos os campos.</h5></div>";
				request.getSession().setAttribute("messageErro", messageErro);
				response.sendRedirect(request.getContextPath()
						+ "/Pets-Cadastrados.pets");
			}

		}
		
	}

}
