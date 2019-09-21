package ttps.clasificados;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class FiltroLenguajeCliente
 */
@WebFilter(description = "Filtro Lenguaje Cliente", urlPatterns = { "/Login", "/LoginMultilenguaje" })
public class FiltroLenguajeCliente implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroLenguajeCliente() {
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
		String language = "textos_es";
		Locale lang = request.getLocale();
		ServletRequest req = request;
		if (lang.getLanguage().toLowerCase() == "en")
			language = "textos_en";
		req.setAttribute("leng", language);
		// pass the request along the filter chain
		chain.doFilter(req, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
