package br.com.petGoHome.Servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petGoHome.Fachada.Fachada;
import br.com.petGoHome.entidades.Cachorro;
import br.com.petGoHome.entidades.Gato;
import br.com.petGoHome.entidades.Pessoa;
import br.com.petGoHome.entidades.RacaCachorro;
import br.com.petGoHome.entidades.RacaGato;
import br.com.petGoHome.entidades.Sexo;
import br.com.petGoHome.entidades.TipoAnimal;
import br.com.petGoHome.entidades.Uf;

/**
 * Servlet implementation class EditarCachorroServlet
 */
public class EditarCachorroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarCachorroServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Como será link, usarei o DoGET

		String idDog = request.getParameter("idDog");
		String idPessoa = request.getParameter("idPessoa");

		String messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Faça o login para realizar essa transação.</h5></div>";

		Pessoa pf = new Pessoa();
		pf = (Pessoa) request.getSession().getAttribute("pessoaLogado");

		if (pf == null) {
			request.getSession().setAttribute("messageErro", messageErro);
			response.sendRedirect("Index.pet");
		} else if (pf != null) {

			//Verifica se a pessoa é a dona do cachorro na sessao.
				if (idDog != null && pf.getId() == Long.parseLong(idPessoa)) {
					
					String dia = null;
		            String mes = null;
		            String ano = null;

					Cachorro dogEditado = new Cachorro();

					dogEditado = Fachada.buscarCachorroPorId(Long
							.parseLong(idDog));

					Pessoa p = new Pessoa();

					p = Fachada.buscarPessoaPorId(Long.parseLong(idPessoa));

					List<RacaCachorro> racas = new ArrayList<RacaCachorro>();

					racas = Fachada.listarTodasRacasCachorro();

					try {
						if (dogEditado.getPessoa().getId() != p.getId()) {
							response.sendRedirect("Index.pet");
							return;
						} else {

							
							//Pegando a data do Banco
							Date dataBanco = dogEditado.getDataNascimentoPet();
							
							if(dataBanco == null){
								dia = "00";
					            mes = "00";
					            ano = "xxxx";
								System.out.println("A data de nascimento do pet veio do BD null.");
								System.out.println("Erro do TRY, pq data é nula.");
							}else{
								System.out.println("Data do banco ok: "+ dataBanco.toString());
								 //arqui vamos configurar o simple date formate
					            // d = dia, M (maiusculo) = mes e y = ano (obs: m = minutos)
					            SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
					            
					            SimpleDateFormat formatarDia = new SimpleDateFormat("dd");
					            SimpleDateFormat formatarMes = new SimpleDateFormat("MM");
					            SimpleDateFormat formatarAno = new SimpleDateFormat("yyyy");

					            //imprimir a data
					            //System.out.println(formatar.format(dataBanco));
					            dia = formatarDia.format(dataBanco);
					            mes = formatarMes.format(dataBanco);
					            ano = formatarAno.format(dataBanco);
					 
					            //agora vamos converter a String para Date
					            String dataString = "01/01/1995";
					            dataBanco = formatar.parse(dataString);
					            
					            //Agora envia as datas via requeste para os selects
							}
							
							
				            request.setAttribute("dia", dia);
				            request.setAttribute("mes", mes);
				            request.setAttribute("ano", ano);
							request.setAttribute("dog", dogEditado);
							request.setAttribute("racas", racas);

							request.getRequestDispatcher(
									"AdminLTE-master/paginas/Editar/EditarCachorro.jsp")
									.forward(request, response);

						}
					} catch (Exception e) {
						System.out.println(e.getMessage());	
						messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Não pode Editar este PET.</h5></div>";
						request.getSession().setAttribute("messageErro",
								messageErro);
						response.sendRedirect("Pets-Cadastrados.pets");
					}

				}else{
					
					messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Não pode acessar esta página.</h5></div>";
					request.getSession().setAttribute("messageErro", messageErro);
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
		// O Cachorro está sumindo quando altera e não está logado.

		String message = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>x</button><h5>PET Alterado com sucesso...</h5></div>";
		String messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><h5>Erro! Tente outra vez.</h5></div>";

		String idDog = request.getParameter("idDogEditado");
		String nomeGato = request.getParameter("nomeGato");
		String raca = request.getParameter("raca");
		String sexo = request.getParameter("sexo");

		String cor = request.getParameter("cor");
		String tag = request.getParameter("tag");
		String descricao = request.getParameter("descricao");
		
		
		// Pegando a Data
				String birthday_day = request.getParameter("birthday_day");
				String birthday_month = request.getParameter("birthday_month");
				String birthday_year = request.getParameter("birthday_year");

				String dataNascimento = birthday_day + "-" + birthday_month + "-"
						+ birthday_year;
		
		RacaCachorro rcCachorro = null;
		Cachorro dog = new Cachorro();

		Pessoa p = new Pessoa();
		p = (Pessoa) request.getSession().getAttribute("pessoaLogado");

		if (p == null) {
			messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Faça o login para realizar essa transação.</h5></div>";
			request.getSession().setAttribute("messageErro", messageErro);
			response.sendRedirect("IndexUser.pet");
		} else if (p != null) {// Até aqui é validação caso a pessoa esteja
								// deslogada. Não poderá entrar aqui

			try {

				if (idDog != null) {

					// Se não procurar por ID, slvará um dog novo ao invés de
					// alterar
					dog = Fachada.buscarCachorroPorId(Long.parseLong(idDog));

					// Assim faz a mesma coisa de salvar um novo dog
					dog.setNome(nomeGato);
					dog.setCor(cor);
					dog.setDescricao(descricao);

					// Convertendo a data string para calendar
					if (dataNascimento != null) {

						SimpleDateFormat format = new SimpleDateFormat(
								"dd-MM-yyyy");
						try {
							Date dataAnimalNascimento = format
									.parse(dataNascimento);
							dog.setDataNascimentoPet(dataAnimalNascimento);
							System.out.println("Converteu data: "
									+ dog.getDataNascimentoPet().toString());
						} catch (ParseException e) {
							System.out.println(e.getMessage());
							System.out.println("Erro na conversao da data");
							e.printStackTrace();
						}

					}
					if (raca != null) {

						rcCachorro = Fachada.buscarRacaCachorroPorId((Long
								.parseLong(raca)));
						System.out.println("Raca do Cahorro é: "
								+ rcCachorro.getNomeRacaCachorro());
						dog.setRacaCachorro(rcCachorro);

					}
					if (sexo.equals("Masculino")) {
						dog.setSexo(Sexo.MASCULINO);
					} else {
						dog.setSexo(Sexo.FEMININO);
					}

					// Prestar atenção, é do tipo CACHORRO e não gato
					dog.setTipoAnimal(TipoAnimal.CACHORRO);
					System.out.println("imprime antes do erro");
					try {
						Pessoa pf = new Pessoa();

						pf = (Pessoa) request.getSession().getAttribute(
								"pessoaLogado");

						dog.setPessoa(pf);
						Fachada.alterarPet(dog);
						request.getSession().setAttribute("message", message);
						response.sendRedirect("Pets-Cadastrados.pets");

					} catch (Exception e) {
						System.out.println(e.getMessage());
						System.out.println("Erro em salvar o Pet.");
						request.getSession().setAttribute("messageErro",
								messageErro);
						messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Faça o login para realizar essa transação.</h5></div>";
						response.sendRedirect("Pets-Cadastrados.pets");
					}
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
				messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Tente editar outra vez preenchendo todos os campos.</h5></div>";
				request.getSession().setAttribute("messageErro", messageErro);
				response.sendRedirect(request.getContextPath()
						+ "/Pets-Cadastrados.pets");
			}

		}
	}

}
