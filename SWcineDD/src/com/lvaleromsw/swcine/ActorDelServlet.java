package com.lvaleromsw.swcine;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lvaleromsw.swcine.dao.ActorDAO;

@SuppressWarnings("serial")
public class ActorDelServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String redirect = "index.jsp";
		String error = "";
		boolean err = false;
		
		try{
			String str = request.getParameter("actor");
			if(str == null || str.equals("")){
				error = "";
				err = true;
				redirect = "index.jsp";
			}
			if(!err){
				long key = Long.valueOf(str);
				ActorDAO dao = ActorDAO.getInstance();
				
				if(dao.deleteActor(key)){
					redirect = "actors.jsp?letter=a";
				}else{
					//System.out.println("el actor no existe");
					err = true;
					error ="El actor no existe";
					redirect ="error.jsp";
				}
			}
		}catch(java.lang.IllegalArgumentException e){
			//System.out.println("error al crear pelicula");
			redirect = "error.jsp";
			error = "Error interno al crear la pelicula";
		}catch(Exception e){
			redirect = "error.jsp";
			error ="Error interno al crear el actor";
			err = true;
		}finally{
			if(redirect.equals("error.jsp")) redirect += "?error="+error;
			response.sendRedirect(redirect);
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String redirect = "index.jsp";
		String error = "";
		boolean err = false;
		
		try{
			String str = request.getParameter("actor");
			if(str == null || str.equals("")){
				error = "";
				err = true;
				redirect = "index.jsp";
			}
			if(!err){
				long key = Long.valueOf(str);
				ActorDAO dao = ActorDAO.getInstance();
				
				if(dao.deleteActor(key)){
					redirect = "actors.jsp?letter=a";
				}else{
					//System.out.println("el actor no existe");
					err = true;
					error ="El actor no existe";
					redirect ="error.jsp";
				}
			}
		}catch(java.lang.IllegalArgumentException e){
			//System.out.println("error al crear pelicula");
			redirect = "error.jsp";
			error = "Error interno al crear la pelicula";
		}catch(Exception e){
			redirect = "error.jsp";
			error ="Error interno al crear el actor";
			err = true;
		}finally{
			if(redirect.equals("error.jsp")) redirect += "?error="+error;
			response.sendRedirect(redirect);
		}
	}
}