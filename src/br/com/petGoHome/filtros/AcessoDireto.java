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
 * Servlet Filter implementation class AcessoDireto
 */
public class AcessoDireto implements Filter {

	/**
	 * Default constructor.
	 */
	public AcessoDireto() {
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
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String requestedURL = httpRequest.getRequestURL().toString();
		String messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Acesso negado. Faça o seu login.</h5></div>";

		if (requestedURL.endsWith(".jsp")) {
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			// httpResponse.sendError(401);
			messageErro = "<div id='msgAlerta' style='width:30%'  align='center' class='alert alert-danger'><button type='button' class='close' data-dismiss='alert'>x</button><img src='img/exclamacao.png' /><h5>Acesso negado.</h5></div>";
			httpRequest.getSession().setAttribute("messageErro", messageErro);
			httpResponse
					.sendRedirect((httpRequest.getContextPath() + "/Index.pet"));
			return;
		}
		// busca usuário na sessão
		Pessoa p = new Pessoa();
		p = (Pessoa) httpRequest.getSession().getAttribute("pessoaLogado");

		// se usuário retornar null, redireciona para página de login e não
		// deixa passar no filtro
		if (p == null) {
			if (requestedURL.endsWith(".txt")) {
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				httpRequest.getSession().setAttribute("messageErro",
						messageErro);
				httpResponse
						.sendRedirect((httpRequest.getContextPath() + "/Index.pet"));
				return;
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
