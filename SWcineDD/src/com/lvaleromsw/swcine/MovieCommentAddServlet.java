package com.lvaleromsw.swcine;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lvaleromsw.swcine.dao.MovieDAO;

@SuppressWarnings("serial")
public class MovieCommentAddServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String redirect = "/index.jsp";
		String error = "";
		boolean err = false;
		
		try{
			String str = request.getParameter("movie");
			String comment = request.getParameter("comment");
			String username = (String) request.getSession(true).getAttribute("username");
			
			if(comment == null || comment.equals("")){
				err = true;
				error = "El comentario no puede ser vacio";
				redirect = "../error.jsp";
			}
			if(str == null || str.equals("")){
				err = true;
				error = "";
				redirect = "../index.jsp";
			}
			if(username == null || username.equals("")){
				err = true;
				error = "";
				redirect = "../index.jsp";
			}
			
			if(!err){
				long key = Long.valueOf(str);
				
				MovieDAO dao = MovieDAO.getInstance();
				
				if(dao.addComment(comment, username, key)){
					redirect = (String) request.getSession(true).getAttribute("url");
				}else{
					System.out.println("la pelicula no existe");
				}
			}
			
		}catch(java.lang.IllegalArgumentException e){
			//System.out.println("error al crear pelicula");
			redirect = "../error.jsp";
			error = "Error interno al crear la pelicula";
		}catch(Exception e){
			redirect = "../error.jsp";
			error ="Error interno al crear el actor";
			err = true;
		}finally{
			if(redirect.equals("../error.jsp")) redirect += "?error="+error;
			response.sendRedirect(redirect);
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.sendRedirect("../index.jsp");
	}

}
