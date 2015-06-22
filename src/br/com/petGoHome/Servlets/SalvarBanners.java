package br.com.petGoHome.Servlets;

import java.io.IOException;
import java.io.InputStream;
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
import br.com.petGoHome.banner.Banner;
import br.com.petGoHome.banner.HistoricoBanner;
import br.com.petGoHome.entidades.HistoricoFotosPet;

/**
 * Servlet implementation class SalvarBanners
 */
public class SalvarBanners extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalvarBanners() {
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

		String messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Não foi possível alterar o banner.</h5></div>";
		String message = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>x</button><h5>Banner Alterado com sucesso...</h5></div>";

		String b3 = request.getParameter("banner3");
		String b2 = request.getParameter("banner2");
		String b1 = request.getParameter("banner1");

		Banner banner = new Banner();
		String nomeImagem = "";

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
						if (fieldName.equals("banner1")) { //Verifica da campo do FORM
							b1 = value;
						}
						if (fieldName.equals("banner2")) {
							b2 = value;
						}
						if (fieldName.equals("banner3")) {
							b3 = value;
						}

						System.out.println(fieldName + ":" + value + "!");
					} else {
						// faça o file upload specifico processo
						String path = getServletContext().getRealPath("/");
						// chame o metodo de upload do file
						if (b1 != null && b1.equals("banner1") ) { // <------------------
																	// ALTERAÇÃO
																	// somente
																	// para
																	// Banner 1
							System.out.println("b1 não é nulo. " + b1);
							nomeImagem = Fachada.processandoArquivo(path, item);
							if (nomeImagem != null) {
								System.out.println("File enviado com sucesso.");
								System.out.println("Caminho: " + path);
								System.out.println("Item: " + item);
								banner.setNomeBanner(nomeImagem);
								banner.setId(1); // ALTERANDO O BANNER 1
													// <------------------REQUER
													// ATENÇÃO AQUI pois precisa
													// sobescrever sempre o
													// mesmo Banner ID
								System.out.println("Nome Foto Final: "
										+ nomeImagem);

								HistoricoBanner hb1 = new HistoricoBanner(); // Aqui
																				// tem
																				// que
																				// se
																				// salvar
																				// um
																				// novo
																				// histório
																				// para
																				// ele
																				// gerar
																				// a
																				// lista
																				// de
																				// imagens
																				// ja
																				// add
																				// antes

								hb1.setBannerId(1);
								hb1.setDataAlteracao(new Date(System
										.currentTimeMillis()));
								hb1.setNomeFoto(nomeImagem);

								Fachada.alterarHistoricoBanner(hb1);
								Fachada.alterarBanner(banner);
								
								System.out.println("Alterou o Banner.");
								request.getSession().setAttribute("message",
										message);
								response.sendRedirect("Index.pet");
								}

							

							}
								
								
								
								
								if (b2 != null && b2.equals("banner2")) { // <------------------
																		// ALTERAÇÃO
																		// somente
																		// para
																		// Banner
																		// 1
								System.out.println("b2 não é nulo." + b1);
								nomeImagem = Fachada.processandoArquivo(path,
										item);
								if (nomeImagem != null) {
									System.out
											.println("File enviado com sucesso.");
									System.out.println("Caminho: " + path);
									System.out.println("Item: " + item);
									banner.setNomeBanner(nomeImagem);
									banner.setId(2); // ALTERANDO O BANNER 1
														// <------------------REQUER
														// ATENÇÃO AQUI pois
														// precisa sobescrever
														// sempre o mesmo Banner
														// ID
									System.out.println("Nome Foto Final: "
											+ nomeImagem);

									HistoricoBanner hb2 = new HistoricoBanner(); // Aqui
																					// tem
																					// que
																					// se
																					// salvar
																					// um
																					// novo
																					// histório
																					// para
																					// ele
																					// gerar
																					// a
																					// lista
																					// de
																					// imagens
																					// ja
																					// add
																					// antes

									hb2.setBannerId(2);
									hb2.setDataAlteracao(new Date(System
											.currentTimeMillis()));
									hb2.setNomeFoto(nomeImagem);

									Fachada.alterarHistoricoBanner(hb2);
									Fachada.alterarBanner(banner);


									System.out.println("Alterou o Banner.");
									request.getSession().setAttribute(
											"message", message);
									response.sendRedirect("Index.pet");
								}

								}
									
									
									if (b3 != null && b3.equals("banner3")) { // <------------------
									// ALTERAÇÃO
									// somente
									// para
									// Banner
									// 1
								System.out.println("b3 não é nulo." + b1);
								nomeImagem = Fachada.processandoArquivo(path,
									item);
								if (nomeImagem != null) {
								System.out
										.println("File enviado com sucesso.");
								System.out.println("Caminho: " + path);
								System.out.println("Item: " + item);
								banner.setNomeBanner(nomeImagem);
								banner.setId(3); // ALTERANDO O BANNER 1
													// <------------------REQUER
													// ATENÇÃO AQUI pois
													// precisa sobescrever
													// sempre o mesmo Banner
													// ID
								System.out.println("Nome Foto Final: "
										+ nomeImagem);
								
								HistoricoBanner hb2 = new HistoricoBanner(); // Aqui
																				// tem
																				// que
																				// se
																				// salvar
																				// um
																				// novo
																				// histório
																				// para
																				// ele
																				// gerar
																				// a
																				// lista
																				// de
																				// imagens
																				// ja
																				// add
																				// antes
								
								hb2.setBannerId(3);
								hb2.setDataAlteracao(new Date(System
										.currentTimeMillis()));
								hb2.setNomeFoto(nomeImagem);
								
								Fachada.alterarHistoricoBanner(hb2);
								Fachada.alterarBanner(banner);
								
								
								System.out.println("Alterou o Banner.");
								request.getSession().setAttribute(
										"message", message);
								response.sendRedirect("Index.pet");
								}
								
								}
								
								
								
							}
						}

			} catch (FileUploadException e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				System.out.println("Erro, não Alterou o Banner.");
				request.getSession().setAttribute("messageErro", messageErro);
				response.sendRedirect("Index.pet");
			}
		}// else nao faz nada
	}

}
