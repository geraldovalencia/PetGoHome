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
import br.com.petGoHome.entidades.PetShop;
import br.com.petGoHome.entidades.Uf;

/**
 * Servlet implementation class EditarPetShop
 */
public class EditarPetShop extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditarPetShop() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idPetShop = request.getParameter("idPetShop");
		String idPessoa = request.getParameter("idPessoa");
		
		String messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><span><img src='img/exclamacao.png' /></span><h5>Erro! Faça o login para realizar essa transação.</h5></div>";
		
		Pessoa p = new Pessoa();
		
		try {
			p = (Pessoa) request.getSession().getAttribute("pessoaLogado");
			

			if (p == null) {
				request.getSession().setAttribute("messageErro", messageErro);
				response.sendRedirect("Index.pet");
			} else if (p != null) {
				Administrador adm = new Administrador();
				adm = Fachada.buscarPessoaADMPorId(p.getId());
				
				if(adm != null && adm.getId() == p.getId() && p.getId() == Long.parseLong(idPessoa)){
					
					PetShop pshop = new  PetShop();
					pshop = Fachada.buscarPetShopPorId(Long.parseLong(idPetShop));
					
					request.setAttribute("pshop", pshop);
					request.setAttribute("ufs", Uf.values());
					request.getRequestDispatcher("paginas/PetShop/Editar-PetShop.jsp").forward(request, response);
					
					
				}else{
					messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Não realizar esta ação.</h5></div>";
					request.getSession().setAttribute("messageErro",
							messageErro);
					response.sendRedirect("Index.pet");
				}
				
			}
			}catch (Exception e) {
				System.out.println(e.getMessage());
				messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Erro! Erro na edição do PetShop.</h5></div>";
				request.getSession().setAttribute("messageErro",
						messageErro);
				response.sendRedirect("Index.pet");
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {


		String message = "<div id='msgAlerta' style='width:30%' ' align='center' class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button><h5>Alteração realizada com sucesso...</h5></div>";
		String messageErro = "<div id='msgAlerta' style='width:30%' ' align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><img src='img/exclamacao.png' /><h5>Erro! Tente alterar outro PetShop.</h5></div>";
		HttpSession session = request.getSession(false);
		
		String idPetShopEditado = request.getParameter("idPetShopEditado");
		String nomePetShop = request.getParameter("nomePetShop");
		String emailPetShop = request.getParameter("emailPetShop");
		String responsavel = request.getParameter("responsavel");
		String telefone = request.getParameter("telefone");
		String cnpj = request.getParameter("cnpj");
		String rua = request.getParameter("rua");
		String cep = request.getParameter("cep");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String numero = request.getParameter("numero");
		String uf = request.getParameter("uf");
		
		if(nomePetShop != null && !nomePetShop.equals("") && !idPetShopEditado.equals("")){
			
			PetShop pf = new PetShop();
			pf =Fachada.buscarPetShopPorId(Long.parseLong(idPetShopEditado));
				
			
			Endereco end = new Endereco();
			end.setBairro(bairro);
			end.setCep(cep);
			end.setCidade(cidade);
			end.setNumero(numero);
			end.setRua(rua);
			
			pf.setNomePetShop(nomePetShop);
			pf.setEmailPetShop(emailPetShop);
			pf.setEndereco(end);
			pf.setCnpj(cnpj);
			
			
			
			pf.setDataUltimaAlteracao(new Date( System.currentTimeMillis()));
			//pf.setCpf(cpf);
			pf.setTelefone(telefone);
			pf.setResponsavel(responsavel);
			
			pf.setUf(Uf.valueOf(uf));
			System.out.println("Estado do usuario: "+ pf.getUf());
			
			try {
				Fachada.alterarPetShop(pf);
				session.setAttribute("message", message);
				response.sendRedirect("Listar-PetShop.adm");
				
			} catch(Exception e){
				System.out.println(e.getMessage());
				System.out.println("Erro em salvar o PetShop.");
				session.setAttribute("messageErro", messageErro);
				response.sendRedirect("Index.pet");
			}
			return;
		}
	}

}
