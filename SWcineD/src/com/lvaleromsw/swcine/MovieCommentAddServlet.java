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
		String str = request.getParameter("movie");
		
		try{
			
			String comment = request.getParameter("comment");
			String username = (String) request.getSession(true).getAttribute("username");
			//String str = request.getParameter("movie");
			
			if(comment == null)System.out.println("comentario nulo");
			if(username == null)System.out.println("usuario nulo");
			if(str == null)System.out.println("key nulo");
			
			System.out.println(comment);
			System.out.println(username);
			System.out.println(str);
			
			long key = Long.valueOf(str);
			
			MovieDAO dao = MovieDAO.getInstance();
			
			if(dao.addComment(comment, username, key)){
				redirect = (String) request.getSession(true).getAttribute("url");
			}else{
				System.out.println("la pelicula no existe");
			}
			
		}catch(Exception e){
			System.out.println("error al añadir comentario");
		}finally{
			//request.setAttribute("movie",str);
			response.sendRedirect(redirect);
		}
	}

}
