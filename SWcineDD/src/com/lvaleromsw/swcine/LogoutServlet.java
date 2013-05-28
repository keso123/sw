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
		String redirect = "index.jsp";
		String error = "";
		
		try{
			HttpSession sesion = request.getSession(true);
			Object username = request.getSession(true).getAttribute("username");
			String url = (String) sesion.getAttribute("url");
			
			if(username != null){
				request.getSession(true).setAttribute("username", null);
				request.getSession(true).setAttribute("admin",null);
				
				if(url != null && !url.equals("") ) 
					redirect = url;
			}
		}catch(java.lang.IllegalArgumentException e){
			//System.out.println("error al crear pelicula");
			redirect = "error.jsp";
			error = "Error interno al crear la pelicula";
		}catch(Exception e){
			redirect = "error.jsp";
			error ="Error interno al crear el actor";
		}finally{
			if(redirect.equals("error.jsp")) redirect += "?error="+error;
			response.sendRedirect(redirect);
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String redirect = "index.jsp";
		String error = "";
		
		try{
			HttpSession sesion = request.getSession(true);
			Object username = request.getSession(true).getAttribute("username");
			String url = (String) sesion.getAttribute("url");
			
			if(username != null){
				request.getSession(true).setAttribute("username", null);
				request.getSession(true).setAttribute("admin",null);
				
				if(url != null && !url.equals("") ) 
					redirect = url;
			}
		}catch(Exception e){
			error = "Error interno al hacer logout";
			redirect = "error.jsp";
		}finally{
			if(redirect.equals("error.jsp")) redirect += "?error="+error;
			response.sendRedirect(redirect);
		}
	}
}
