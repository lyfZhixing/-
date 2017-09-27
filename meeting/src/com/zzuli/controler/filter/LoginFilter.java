package com.zzuli.controler.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {
	FilterConfig config;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	public static boolean isContains(String container, String[] regs){
		for(String x : regs){
			if(container.indexOf(x) != -1){
				return true;
			}
			
		}
		return false;
	}
	
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		
		String login = config.getInitParameter("login");
		String include = config.getInitParameter("include");
		String redirectPath = request.getContextPath() + config.getInitParameter("redirectPath");
		String disabletestfilter = config.getInitParameter("disabletestfilter");
		
		if(disabletestfilter.toUpperCase().equals("Y")){
			chain.doFilter(arg0, arg1);
		}
		
		String[] loginlist = login.split(";");
		String[] includelist = include.split(";");
		
		if(!isContains(request.getRequestURI(), includelist)){
			chain.doFilter(arg0, arg1);
			return;
		}
		
		if(LoginFilter.isContains(request.getRequestURI(), loginlist)){
			chain.doFilter(arg0, arg1);
			return;
		}
		String user = (String)request.getSession().getAttribute("uname");
		if(user == null){
			response.sendRedirect(redirectPath);
			return;
		}else{
			chain.doFilter(arg0, arg1);
			return;
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		config = arg0;
	}

}
