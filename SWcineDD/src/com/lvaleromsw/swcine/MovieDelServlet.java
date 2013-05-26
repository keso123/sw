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
		try{
			String str = request.getParameter("movie");
			long key = Long.valueOf(str);
			MovieDAO dao = MovieDAO.getInstance();
			
			if(dao.deleteMovie(key)){
				redirect = "/movies.jsp?letter=a";
			}else{
				System.out.println("la pelicula no existe");
			}
		}catch(Exception e){
			System.out.println("Error al borrar pelicula");
		}finally{
			response.sendRedirect(redirect);
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String redirect = "/index.jsp";
		try{
			String str = request.getParameter("movie");
			long key = Long.valueOf(str);
			MovieDAO dao = MovieDAO.getInstance();
			
			if(dao.deleteMovie(key)){
				redirect = "/movies.jsp?letter=a";
			}else{
				System.out.println("la pelicula no existe");
			}
		}catch(Exception e){
			System.out.println("Error al borrar pelicula");
		}finally{
			response.sendRedirect(redirect);
		}
	}
}
