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

/**
 * Servlet Filter implementation class filtroAcesso
 */
public class filtroAcesso implements Filter {

    /**
     * Default constructor. 
     */
    public filtroAcesso() {
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
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//busca usuário na sessão
		Pessoa p = new Pessoa();
		p = (Pessoa) req.getSession().getAttribute("pessoaLogado");
		
		//se usuário retornar null, redireciona para página de login e não deixa passar no filtro
				if (p == null) {
					System.out.println("Acesso negado! Filro AutenticarFilter");
					String messageErro = "<div id='msgAlerta' style='width:30%' align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>A sessão Expirou. Faça o seu login.</h5></div>";
					req.getSession().setAttribute("messageErro", messageErro);
					resp.sendRedirect("Index.pet");
					return;
				}
		
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
