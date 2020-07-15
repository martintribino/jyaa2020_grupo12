package com.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.HttpMethod;

import com.security.JWToken;

/**
 * Servlet Filter implementation class JWTAuthFilter
 */
@WebFilter(filterName = "jwt-auth-filter", urlPatterns = "/api/*")
public class JWTAuthFilter implements Filter {

	public static final String FRONT_URL = "http://localhost:4200";

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        res.setContentType("application/json");
        //CORS implement. por ahora aqui
        res.setHeader("Access-Control-Allow-Origin", JWTAuthFilter.FRONT_URL);
        res.setHeader("Access-Control-Allow-Methods","OPTIONS,POST,GET,PUT,DELETE");
        res.setHeader("Access-Control-Allow-Headers","x-requested-with, origin, content-type, accept, authorization");
        res.setHeader("Access-Control-Allow-Credentials","true");
        if (!HttpMethod.OPTIONS.matches(req.getMethod())) {
            String token = JWToken.getToken(req);
            //aun no
            /*if (token == null) {
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                PrintWriter out = response.getWriter();
    			out.print("Intento de acceso no autorizado.");
                return;
            }*/
        }
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
