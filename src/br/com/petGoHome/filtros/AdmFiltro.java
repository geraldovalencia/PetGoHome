package br.com.petGoHome.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.petGoHome.entidades.Pessoa;
import br.com.petGoHome.entidades.TipoUsuario;

/**
 * Servlet Filter implementation class AdmFiltro
 */
public class AdmFiltro implements Filter {

    /**
     * Default constructor. 
     */
    public AdmFiltro() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Acesso negado. Faça o login no sistema.</h5></div>";

		Pessoa p = new Pessoa();
		p = (Pessoa) req.getSession().getAttribute("pessoaLogado");

		// se usuário retornar null, redireciona para página de login e não
		// deixa passar no filtro
		if (p == null) {
			System.out.println("FILTRO ADMIN: USER null aqui");
			req.getSession().setAttribute("messageErro", messageErro);
			resp.sendRedirect(req.getContextPath() + "/Index.pet");
			return;
		}

		if (p != null) {
			System.out.println("Usuário com algum tipo de permissão existe");
			if (p.getTipoUsuario() == TipoUsuario.ADMINISTRADOR) {
				chain.doFilter(request, response);
			}else{
				messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Acesso negado. Não possui permissão de acesso.</h5></div>";
				req.getSession().setAttribute("messageErro", messageErro);
				resp.sendRedirect(req.getContextPath() + "/Index.pet");
			}
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
