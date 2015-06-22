package br.com.petGoHome.Servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.petGoHome.Fachada.Fachada;
import br.com.petGoHome.entidades.Endereco;
import br.com.petGoHome.entidades.Pessoa;
import br.com.petGoHome.entidades.PessoaFisica;
import br.com.petGoHome.entidades.PetShop;
import br.com.petGoHome.entidades.Sexo;
import br.com.petGoHome.entidades.TipoUsuario;
import br.com.petGoHome.entidades.Uf;

/**
 * Servlet implementation class CadastroPetShopServlet
 */
public class CadastroPetShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroPetShopServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String message = "<div id='msgAlerta' style='width:30%' ' align='center' class='alert alert-success'><button type='button' class='close' data-dismiss='alert'>&times;</button><h5>Cadastro realizado com sucesso...</h5></div>";
		String messageErro = "<div id='msgAlerta' style='width:30%' ' align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>&times;</button><img src='img/exclamacao.png' /><h5>Erro! Tente cadastrar outro PetShop.</h5></div>";
		HttpSession session = request.getSession(false);
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String responsavel = request.getParameter("responsavel");
		String telefone = request.getParameter("telefone");
		String cnpj = request.getParameter("cnpj");
		String rua = request.getParameter("rua");
		String cep = request.getParameter("cep");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String numero = request.getParameter("numero");
		String uf = request.getParameter("uf");
		String recebeuTag = request.getParameter("recebeuTag");
		
		if(nome != null && !nome.equals("")){
			PetShop pf = new PetShop();
			Endereco end = new Endereco();
			end.setBairro(bairro);
			end.setCep(cep);
			end.setCidade(cidade);
			end.setNumero(numero);
			end.setRua(rua);
			
			if (recebeuTag.equals("True")) {
				
				pf.setRecebeuTag(true);
			}else{
				pf.setRecebeuTag(false);
			}
			
			pf.setNomePetShop(nome);
			pf.setEmailPetShop(email);
			pf.setEndereco(end);
			pf.setCnpj(cnpj);
			
			
			
			pf.setDataCriacao(new Date( System.currentTimeMillis()));
			//pf.setCpf(cpf);
			pf.setTelefone(telefone);
			pf.setResponsavel(responsavel);
			
			pf.setUf(Uf.valueOf(uf));
			System.out.println("Estado do usuario: "+ pf.getUf());
			
			try {
				session = request.getSession(true);
				Fachada.salvarPetShop(pf);
				session.setAttribute("message", message);
				response.sendRedirect("Index.pet");
				
			} catch(Exception e){
				session = request.getSession(true);
				System.out.println(e.getMessage());
				System.out.println("Erro em salvar o PetShop.");
				session.setAttribute("messageErro", messageErro);
				response.sendRedirect("Index.pet");
			}
			return;
		}
		
	}

}
