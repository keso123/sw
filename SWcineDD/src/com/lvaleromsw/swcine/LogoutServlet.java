package com.lvaleromsw.swcine;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class LogoutServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		Object username = request.getSession(true).getAttribute("username");
		
		if(username != null){
			request.getSession(true).setAttribute("username", null);
		}
		
		response.sendRedirect("index.jsp");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String redirect = "/index.jsp";
		HttpSession sesion = request.getSession(true);
		Object username = request.getSession(true).getAttribute("username");
		String url = (String) sesion.getAttribute("url");
		
		if(username != null){
			request.getSession(true).setAttribute("username", null);
			request.getSession(true).setAttribute("admin",null);
			redirect = url;
		}
		
		response.sendRedirect(redirect);
	}
}
