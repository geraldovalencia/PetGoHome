package br.com.petGoHome.Servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ParseConversionEvent;

import br.com.petGoHome.Fachada.Fachada;
import br.com.petGoHome.entidades.Cachorro;
import br.com.petGoHome.entidades.Gato;
import br.com.petGoHome.entidades.Pet;
import br.com.petGoHome.entidades.Tag;
import br.com.petGoHome.entidades.TipoAnimal;

/**
 * Servlet implementation class PequisaTag
 */
public class PequisaTag extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PequisaTag() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String numeroTagOriginal = request.getParameter("numeroTag");
		String numeroTag = "";
		String messageErro = "";
		List<Tag> tags = new ArrayList<Tag>();

		// Esse método trata requests errado apos usar o domínio
		// PETGOHOME.COM.BR
		if (numeroTagOriginal != null) {
			if (numeroTagOriginal.length() > 7) {
				numeroTag = numeroTagOriginal.substring(0, 7);
				System.out
						.println("Numero da Tag tratado se o Rqst for maior que 7: "
								+ numeroTag);
			}
			// Seo numero da tag estiver correto, só igualar as variaveis
			if (numeroTagOriginal.length() == 7) {
				numeroTag = numeroTagOriginal;
				System.out.println("Numero da Tag  de tamanho igual a 7: "
						+ numeroTag);
			}
		}

		try {
			// Interessante sempre que usar Fachada, usar Try para enviar
			// mensagem de erro específica
			tags = Fachada.buscarTagPorNomeDaTag(numeroTag);
			if (tags.size() != 0) {
				Cachorro dog = new Cachorro();
				Gato gato = new Gato();

				String buscaGato = null;
				String buscaCachorro = null;

				for (Tag tag2 : tags) {

					System.out.println("Tag: " + tag2.getValorTag());
					System.out.println("Tag ID: " + tag2.getId());

					if (tag2.getPet() != null) {
						// Abrirá página com os detalhes do Pet
						System.out.println("Pet = " + tag2.getPet().getNome());

						if (tag2.getPet().getTipoAnimal() == TipoAnimal.CACHORRO) {
							dog = Fachada.buscarCachorroPorId(tag2.getPet()
									.getId());
							buscaCachorro = "ok";

							Date data = dog.getDataNascimentoPet();
							if(data != null){
								Date dataAtual = new Date(
										System.currentTimeMillis());

								// Formatando data
								SimpleDateFormat formatarAno = new SimpleDateFormat(
										"yyyy");
								int dataBicho = Integer.parseInt(formatarAno
										.format(data));
								int dataHoje = Integer.parseInt(formatarAno
										.format(dataAtual));

								int idade = dataHoje - dataBicho;
								if (idade != 0) {
									
									//Caso não seja o mesmo ano entra aqui, caulculará anos
									
									String dataIdade = idade + " anos";
									
									request.setAttribute("dataIdade", dataIdade);
									System.out.println("Idade do Bicho: "+ dataIdade);
								}else{
									//Caso seja  o mesmo ano entra aqui, caulculará meses
									SimpleDateFormat formatarMes = new SimpleDateFormat("MM");
									int dataBichoMes =	Integer.parseInt(formatarMes.format(data));
									int dataHojeMes =	Integer.parseInt(formatarMes.format(dataAtual));
									idade = dataHojeMes - dataBichoMes;
									String dataIdade = idade + " meses";
									
									request.setAttribute("dataIdade", dataIdade);
									System.out.println("Idade do Bicho: "+ dataIdade);
								}
							}else{
								String dataIdade = "Sem data cadastrada";
								
								request.setAttribute("dataIdade", dataIdade);
								System.out.println("Idade do Bicho: Não cadastrou.");
							}
							

							request.setAttribute("dog", dog);
							request.setAttribute("tag2", tag2);
							request.setAttribute("buscaCachorro", buscaCachorro);
							request.getRequestDispatcher(
									"paginas/encontrei-um-pet.jsp").forward(
									request, response);
						}
						if (tag2.getPet().getTipoAnimal() == TipoAnimal.GATO) {
							gato = Fachada.buscarGatoPorId(tag2.getPet()
									.getId());
							buscaGato = "ok";

							Date data = gato.getDataNascimentoPet();
							if(data != null){                             //Verifica se a data for nula (Pet cadastrado sem data)
								Date dataAtual = new Date(
										System.currentTimeMillis());

								// Formatando data
								SimpleDateFormat formatar = new SimpleDateFormat(
										"yyyy");
								int dataBicho = Integer.parseInt(formatar
										.format(data));
								int dataHoje = Integer.parseInt(formatar
										.format(dataAtual));

								int idade = dataHoje - dataBicho;
								if (idade != 0) {
									
									//Caso não seja o mesmo ano entra aqui, caulculará anos
									
									String dataIdade = idade + " anos";
									
									request.setAttribute("dataIdade", dataIdade);
									System.out.println("Idade do Bicho: "+ dataIdade);
								}else{
									//Caso seja  o mesmo ano entra aqui, caulculará meses
									SimpleDateFormat formatarMes = new SimpleDateFormat("MM");
									int dataBichoMes =	Integer.parseInt(formatarMes.format(data));
									int dataHojeMes =	Integer.parseInt(formatarMes.format(dataAtual));
									idade = dataHojeMes - dataBichoMes;
									String dataIdade = idade + " meses";
									
									request.setAttribute("dataIdade", dataIdade);
									System.out.println("Idade do Bicho: "+ dataIdade);
								}
							}else{
								String dataIdade = "Sem data cadastrada";
								
								request.setAttribute("dataIdade", dataIdade);
								System.out.println("Idade do Bicho: Não cadastrou.");
							}
							
							request.setAttribute("gato", gato);
							request.setAttribute("tag2", tag2);
							request.setAttribute("buscaGato", buscaGato);
							request.getRequestDispatcher(
									"paginas/encontrei-um-pet.jsp").forward(
									request, response);
						}

					} else {
						System.out.println("Pet Nulo");
						messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-warning'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>A Tag não possui Pet vinculado. <br> Tente outra Tag.</h5></div>";
						request.getSession().setAttribute("messageErro",
								messageErro);
						response.sendRedirect("Index.pet");
					}
				}

			} else {
				messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-warning'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro, Tag "
						+ numeroTag + "inexistente.</h5></div>";
				String message = numeroTag + " e tags size =" + tags.size();
				request.getSession().setAttribute("messageErro", messageErro);
				request.getSession().setAttribute("message", message);
				response.sendRedirect("Index.pet");
			}
		} catch (Exception e) {
			messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro no Servidor.</h5></div>";
			request.getSession().setAttribute("messageErro", messageErro);
			response.sendRedirect("Index.pet");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String numeroTagOriginal = request.getParameter("numeroTag");
		String numeroTag = "";
		String messageErro = "";
		List<Tag> tags = new ArrayList<Tag>();

		// Esse método trata requests errado apos usar o domínio
		// PETGOHOME.COM.BR
		if (numeroTagOriginal != null) {
			if (numeroTagOriginal.length() > 7) {
				numeroTag = numeroTagOriginal.substring(0, 7);
				System.out
						.println("Numero da Tag tratado se o Rqst for maior que 7: "
								+ numeroTag);
			}
			// Seo numero da tag estiver correto, só igualar as variaveis
			if (numeroTagOriginal.length() == 7) {
				numeroTag = numeroTagOriginal;
				System.out.println("Numero da Tag  de tamanho igual a 7: "
						+ numeroTag);
			}
		}

		try {
			// Interessante sempre que usar Fachada, usar Try para enviar
			// mensagem de erro específica
			tags = Fachada.buscarTagPorNomeDaTag(numeroTag);
			if (tags.size() != 0) {
				Cachorro dog = new Cachorro();
				Gato gato = new Gato();

				String buscaGato = null;
				String buscaCachorro = null;

				for (Tag tag2 : tags) {

					System.out.println("Tag: " + tag2.getValorTag());
					System.out.println("Tag ID: " + tag2.getId());

					if (tag2.getPet() != null) {
						// Abrirá página com os detalhes do Pet
						System.out.println("Pet = " + tag2.getPet().getNome());

						if (tag2.getPet().getTipoAnimal() == TipoAnimal.CACHORRO) {
							dog = Fachada.buscarCachorroPorId(tag2.getPet()
									.getId());
							buscaCachorro = "ok";

							Date data = dog.getDataNascimentoPet();
							if(data != null){
								Date dataAtual = new Date(
										System.currentTimeMillis());

								// Formatando data
								SimpleDateFormat formatarAno = new SimpleDateFormat(
										"yyyy");
								int dataBicho = Integer.parseInt(formatarAno
										.format(data));
								int dataHoje = Integer.parseInt(formatarAno
										.format(dataAtual));

								int idade = dataHoje - dataBicho;
								if (idade != 0) {
									
									//Caso não seja o mesmo ano entra aqui, caulculará anos
									
									String dataIdade = idade + " anos";
									
									request.setAttribute("dataIdade", dataIdade);
									System.out.println("Idade do Bicho: "+ dataIdade);
								}else{
									//Caso seja  o mesmo ano entra aqui, caulculará meses
									SimpleDateFormat formatarMes = new SimpleDateFormat("MM");
									int dataBichoMes =	Integer.parseInt(formatarMes.format(data));
									int dataHojeMes =	Integer.parseInt(formatarMes.format(dataAtual));
									idade = dataHojeMes - dataBichoMes;
									String dataIdade = idade + " meses";
									
									request.setAttribute("dataIdade", dataIdade);
									System.out.println("Idade do Bicho: "+ dataIdade);
								}
							}else{
								String dataIdade = "Sem data cadastrada";
								
								request.setAttribute("dataIdade", dataIdade);
								System.out.println("Idade do Bicho: Não cadastrou.");
							}
							

							request.setAttribute("dog", dog);
							request.setAttribute("tag2", tag2);
							request.setAttribute("buscaCachorro", buscaCachorro);
							request.getRequestDispatcher(
									"paginas/encontrei-um-pet.jsp").forward(
									request, response);
						}
						if (tag2.getPet().getTipoAnimal() == TipoAnimal.GATO) {
							gato = Fachada.buscarGatoPorId(tag2.getPet()
									.getId());
							buscaGato = "ok";

							Date data = gato.getDataNascimentoPet();
							if(data != null){                             //Verifica se a data for nula (Pet cadastrado sem data)
								Date dataAtual = new Date(
										System.currentTimeMillis());

								// Formatando data
								SimpleDateFormat formatar = new SimpleDateFormat(
										"yyyy");
								int dataBicho = Integer.parseInt(formatar
										.format(data));
								int dataHoje = Integer.parseInt(formatar
										.format(dataAtual));

								int idade = dataHoje - dataBicho;
								if (idade != 0) {
									
									//Caso não seja o mesmo ano entra aqui, caulculará anos
									
									String dataIdade = idade + " anos";
									
									request.setAttribute("dataIdade", dataIdade);
									System.out.println("Idade do Bicho: "+ dataIdade);
								}else{
									//Caso seja  o mesmo ano entra aqui, caulculará meses
									SimpleDateFormat formatarMes = new SimpleDateFormat("MM");
									int dataBichoMes =	Integer.parseInt(formatarMes.format(data));
									int dataHojeMes =	Integer.parseInt(formatarMes.format(dataAtual));
									idade = dataHojeMes - dataBichoMes;
									String dataIdade = idade + " meses";
									
									request.setAttribute("dataIdade", dataIdade);
									System.out.println("Idade do Bicho: "+ dataIdade);
								}
							}else{
								String dataIdade = "Sem data cadastrada";
								
								request.setAttribute("dataIdade", dataIdade);
								System.out.println("Idade do Bicho: Não cadastrou.");
							}
							
							request.setAttribute("gato", gato);
							request.setAttribute("tag2", tag2);
							request.setAttribute("buscaGato", buscaGato);
							request.getRequestDispatcher(
									"paginas/encontrei-um-pet.jsp").forward(
									request, response);
						}

					} else {
						System.out.println("Pet Nulo");
						messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-warning'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>A Tag não possui Pet vinculado. <br> Tente outra Tag.</h5></div>";
						request.getSession().setAttribute("messageErro",
								messageErro);
						response.sendRedirect("Index.pet");
					}
				}

			} else {
				messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-warning'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro, Tag "
						+ numeroTag + "inexistente.</h5></div>";
				String message = numeroTag + " e tags size =" + tags.size();
				request.getSession().setAttribute("messageErro", messageErro);
				request.getSession().setAttribute("message", message);
				response.sendRedirect("Index.pet");
			}
		} catch (Exception e) {
			messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro no Servidor.</h5></div>";
			request.getSession().setAttribute("messageErro", messageErro);
			response.sendRedirect("Index.pet");
		}
	}

}
