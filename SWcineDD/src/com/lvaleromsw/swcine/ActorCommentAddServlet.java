package com.lvaleromsw.swcine;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lvaleromsw.swcine.dao.ActorDAO;

@SuppressWarnings("serial")
public class ActorCommentAddServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String redirect = "/index.jsp";
		String error ="";
		boolean err = false;
		
		try{
			String str = request.getParameter("actor");
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
				
				ActorDAO dao = ActorDAO.getInstance();
				
				if(dao.addComment(comment, username, key)){
					redirect = (String) request.getSession(true).getAttribute("url");
				}else{
					//System.out.println("el actor no existe");
					err = true;
					error ="El actor no existe";
					redirect ="../error.jsp";
				}
			}
			
		}catch(Exception e){
			error = "Error interno al crear comentario";
			redirect = "../error.jsp";
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
