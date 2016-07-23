package com.event.filters;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest servReq, ServletResponse servResp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)servReq;
		HttpServletResponse resp=(HttpServletResponse)servResp;
		/*if(req.getSession(false)!=null && req.getSession(false).getAttribute("login")!=null){*/
			chain.doFilter(req, resp);
			/*System.out.println("chaining-----------------------");
		}else{
			req.getRequestDispatcher("/pages/LoginPage.jsf").forward(req, resp);
			System.out.println("forwarding---------------------------");
		}*/
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
