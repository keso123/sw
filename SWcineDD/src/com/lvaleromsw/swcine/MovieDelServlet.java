package com.lvaleromsw.swcine;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lvaleromsw.swcine.dao.MovieDAO;

@SuppressWarnings("serial")
public class MovieDelServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String redirect = "/index.jsp";
		String error = "";
		boolean err = false;
		
		try{
			String str = request.getParameter("movie");
			if(str == null || str.equals("")){
				error = "";
				err = true;
				redirect = "../index.jsp";
			}
			if(!err){
				long key = Long.valueOf(str);
				MovieDAO dao = MovieDAO.getInstance();
				
				if(dao.deleteMovie(key)){
					redirect = "/movies.jsp?letter=a";
				}else{
					//System.out.println("la pelicula no existe");
					err = true;
					error ="La pelicula no existe";
					redirect ="../error.jsp";
				}
			}
		}catch(Exception e){
			//System.out.println("Error al borrar pelicula");
			error = "Error interno al borrar pelicula";
			redirect = "../error.jsp";
		}finally{
			if(redirect.equals("../error.jsp")) redirect += "?error="+error;
			response.sendRedirect(redirect);
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String redirect = "/index.jsp";
		String error = "";
		boolean err = false;
		
		try{
			String str = request.getParameter("movie");
			if(str == null || str.equals("")){
				error = "";
				err = true;
				redirect = "../index.jsp";
			}
			if(!err){
				long key = Long.valueOf(str);
				MovieDAO dao = MovieDAO.getInstance();
				
				if(dao.deleteMovie(key)){
					redirect = "/movies.jsp?letter=a";
				}else{
					//System.out.println("la pelicula no existe");
					err = true;
					error ="La pelicula no existe";
					redirect ="../error.jsp";
				}
			}
		}catch(Exception e){
			//System.out.println("Error al borrar pelicula");
			error = "Error interno al borrar pelicula";
			redirect = "../error.jsp";
		}finally{
			if(redirect.equals("../error.jsp")) redirect += "?error="+error;
			response.sendRedirect(redirect);
		}
	}
}
