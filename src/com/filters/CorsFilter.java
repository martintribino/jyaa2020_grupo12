package com.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CorsFilter
 */
//@WebFilter(filterName = "cors-filter", urlPatterns = "/rest/*")
public class CorsFilter /*implements Filter*/ {

	public static final String FRONT_URL = "http://localhost:4200";

    /**
     * Default constructor. 
     */
    public CorsFilter() {
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
        HttpServletResponse res = (HttpServletResponse) response;
        res.setContentType("application/json");
        //CORS implement. por ahora aqui
        res.setHeader("Access-Control-Allow-Origin", CorsFilter.FRONT_URL);
        res.setHeader("Access-Control-Allow-Methods","OPTIONS,POST,GET,PUT,DELETE");
        res.setHeader("Access-Control-Allow-Headers","x-requested-with, origin, content-type, accept, authorization");
        res.setHeader("Access-Control-Allow-Credentials","true");
		chain.doFilter(request, res);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
