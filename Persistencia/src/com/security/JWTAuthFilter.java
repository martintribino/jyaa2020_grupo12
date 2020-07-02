package com.security;

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

/**
 * Servlet Filter implementation class JWTAuthFilter
 */
@WebFilter(filterName = "jwt-auth-filter", urlPatterns = "/api/*")
public class JWTAuthFilter implements Filter {

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
        if (!HttpMethod.OPTIONS.matches(req.getMethod())) {
            HttpServletResponse res = (HttpServletResponse) response;
            res.setContentType("application/json");
            //res.addHeader("Access-Control-Allow-Origin", AppConfig.FRONT_URL);
            String token = JWToken.getToken(req);
            if (token == null) {
                res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                PrintWriter out = response.getWriter();
    			out.print("Intento de acceso no autorizado.");
                return;
            }
        }
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
