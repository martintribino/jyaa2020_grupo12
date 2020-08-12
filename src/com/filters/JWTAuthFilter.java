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

import com.dto.responses.DefaultResponse;
import com.security.JWToken;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;

/**
 * Servlet Filter implementation class JWTAuthFilter
 */
@WebFilter(filterName = "jwt-auth-filter", urlPatterns = "/rest/api/*")
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
        HttpServletResponse res = (HttpServletResponse) response;
        if (HttpMethod.OPTIONS.matches(req.getMethod())) {
            chain.doFilter(request, response);
            return;
        }
        String token = JWToken.getToken(req);
        if (token == null) {
            res.setStatus(HttpServletResponse.SC_FORBIDDEN);
            PrintWriter out = response.getWriter();
            DefaultResponse defResp = new DefaultResponse(
            		"Acceso no autorizado",
            		HttpServletResponse.SC_FORBIDDEN,
            		"No token"
        		);
			out.print(defResp.toJSON());
            return;
        }
		try {
			JWToken.validateToken(token);
		} catch  (ExpiredJwtException exp) {
            res.setStatus(HttpServletResponse.SC_FORBIDDEN);
            PrintWriter out = response.getWriter();
            DefaultResponse defResp = new DefaultResponse(
            		"Acceso denegado",
            		HttpServletResponse.SC_FORBIDDEN,
            		"Token expired: " + exp.getMessage()
        		);
			out.print(defResp.toJSON());
            return;
		} catch (JwtException e) {
            res.setStatus(HttpServletResponse.SC_FORBIDDEN);
            PrintWriter out = response.getWriter();
            DefaultResponse defResp = new DefaultResponse(
            		"Acceso denegado",
            		HttpServletResponse.SC_FORBIDDEN,
            		"Error in token: " + e.getMessage()
        		);
			out.print(defResp.toJSON());
            return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
