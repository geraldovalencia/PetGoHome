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
import br.com.petGoHome.entidades.Gato;
import br.com.petGoHome.entidades.Pessoa;
import br.com.petGoHome.entidades.RacaGato;
import br.com.petGoHome.entidades.Sexo;
import br.com.petGoHome.entidades.TipoAnimal;

/**
 * Servlet implementation class EditarGatoServlet
 */
public class EditarGatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarGatoServlet() {
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

		// Como a página de listagem de Pets usa o link <a>, teremos que usar o
		// get para capturar o id.
		String idGato = request.getParameter("idGato");
		String idPessoa = request.getParameter("idPessoa");

		String messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Faça o login para realizar essa transação.</h5></div>";

		Pessoa pf = new Pessoa();
		pf = (Pessoa) request.getSession().getAttribute("pessoaLogado");

		if (pf == null) {
			request.getSession().setAttribute("messageErro", messageErro);
			response.sendRedirect("Index.pet");
		} else if (pf != null) {
			if (idGato != null && pf.getId() == Long.parseLong(idPessoa)) {
				
				String dia = null;
	            String mes = null;
	            String ano = null;

				Gato gatoEditado = new Gato();

				gatoEditado = Fachada.buscarGatoPorId(Long.parseLong(idGato));

				Pessoa p = new Pessoa();

				p = Fachada.buscarPessoaPorId(Long.parseLong(idPessoa));

				List<RacaGato> racas = new ArrayList<RacaGato>();

				racas = Fachada.listarTodasRacaGato();

				try {
					if (gatoEditado.getPessoa().getId() != p.getId()) {
						response.sendRedirect("Index.pet");
						return;
					} else {

						//Pegando a data do Banco
						Date dataBanco = gatoEditado.getDataNascimentoPet();
						
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
						request.setAttribute("cat", gatoEditado);
						request.setAttribute("racas", racas);

						request.getRequestDispatcher(
								"AdminLTE-master/paginas/Editar/EditarGato.jsp").forward(
								request, response);

					}

				} catch (Exception e) {
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

		String message = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>x</button><h5>PET Alterado com sucesso...</h5></div>";
		String messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Tente outra vez.</h5></div>";

		String idGato = request.getParameter("idGatoEditado");
		String nomeGato = request.getParameter("nomeGato");
		String racaGato = request.getParameter("racaGato");
		String sexo = request.getParameter("sexo");

		// Pegando a Data
		String birthday_day = request.getParameter("birthday_day");
		String birthday_month = request.getParameter("birthday_month");
		String birthday_year = request.getParameter("birthday_year");

		String dataNascimento = birthday_day + "-" + birthday_month + "-"
				+ birthday_year;
		
		String cor = request.getParameter("cor");
		String tag = request.getParameter("tag");
		String descricao = request.getParameter("descricao");
		RacaGato rcGato = null;
		Gato gato = new Gato();

		Pessoa p = new Pessoa();
		p = (Pessoa) request.getSession().getAttribute("pessoaLogado");

		if (p == null) {
			request.getSession().setAttribute("messageErro", messageErro);
			response.sendRedirect("IndexUser.pet");
		} else if (p != null) {

			try {

				if (idGato != null) {

					// Se não procurar por ID, slvará um gato novo ao invés de
					// alterar
					gato = Fachada.buscarGatoPorId(Long.parseLong(idGato));

					// Assim faz a mesma coisa de salvar um novo gato
					gato.setNome(nomeGato);
					gato.setCor(cor);
					gato.setDescricao(descricao);

					// Convertendo a data string para calendar
					if (dataNascimento != null) {

						SimpleDateFormat format = new SimpleDateFormat(
								"dd-MM-yyyy");
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

					}
					if (racaGato != null) {

						rcGato = Fachada.buscarRacaGatoPorId((Long
								.parseLong(racaGato)));
						System.out.println("Raca do Cahorro é: "
								+ rcGato.getNomeRacaGato());
						gato.setRacaGato(rcGato);

					}
					if (sexo.equals("Masculino")) {
						gato.setSexo(Sexo.MASCULINO);
					} else {
						gato.setSexo(Sexo.FEMININO);
					}

					gato.setTipoAnimal(TipoAnimal.GATO);

					try {
						Pessoa pf = new Pessoa();

						pf = (Pessoa) request.getSession().getAttribute(
								"pessoaLogado");

						gato.setPessoa(pf);
						Fachada.alterarPet(gato);
						request.getSession().setAttribute("message", message);
						response.sendRedirect("Pets-Cadastrados.pets");

					} catch (Exception e) {
						System.out.println(e.getMessage());
						System.out.println("Erro em salvar o Pet.");
						request.getSession().setAttribute("messageErro",
								messageErro);
						response.sendRedirect("Pets-Cadastrados.pets");
					}
				}

			} catch (Exception e) {
				System.out.println("Erro na alteração do gato.");
				System.out.println(e.getMessage());
				messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><span><img src='img/exclamacao.png' /></span><h5> Tente editar outra vez preenchendo todos os campos.</h5></div>";
				request.getSession().setAttribute("messageErro", messageErro);
				response.sendRedirect(request.getContextPath()
						+ "/Pets-Cadastrados.pets");
			}

		}
	}

}
