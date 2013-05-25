package com.lvaleromsw.swcine;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lvaleromsw.swcine.dao.MovieDAO;
import com.lvaleromsw.swcine.persistence.Movie;

@SuppressWarnings("serial")
public class MovieAddServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String redirect = "/index.jsp";
		try{
			
			String title = request.getParameter("title");
			String movieTitle = request.getParameter("movieTitle");
			String realMovieTitle = request.getParameter("realMovieTitle");
			String date = request.getParameter("date");
			String country = request.getParameter("country");
			String director = request.getParameter("director");
			String casting = request.getParameter("casting");
			String genre = request.getParameter("genre");
			String synopsis = request.getParameter("synopsis");
			//String url = request.getParameter("url");
			
			Movie mov = new Movie(title, movieTitle, realMovieTitle, date, country, director, casting, genre, synopsis);
			
			MovieDAO dao = MovieDAO.getInstance();
			
			if(dao.createMovie(mov)){
				System.out.println("pelicula creada");
			}else{
				System.out.println("la pelicula ya existe");
			}
			
		}catch(Exception e){
			System.out.println("error al crear pelicula");
		}finally{
			response.sendRedirect(redirect);
		}
	}
	
	
}
