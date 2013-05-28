package com.lvaleromsw.swcine;

import java.io.IOException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.urlfetch.HTTPHeader;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;
import com.lvaleromsw.swcine.dao.MovieDAO;
import com.lvaleromsw.swcine.persistence.Movie;

@SuppressWarnings("serial")
public class MovieAddServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String redirect = "/index.jsp";
		boolean err = false;
		String error = "";
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
			String file = request.getParameter("imagefile");
			//String url = request.getParameter("url");
			
			if(title == null || title.equals("")){
				redirect = "../error.jsp";
				error = "El titulo no puede ser vacio";
				err = true;
			}
			if(movieTitle == null || movieTitle.equals("")){
				redirect = "../error.jsp";
				error = "El titulo de la pelicula no puede ser vacio";
				err = true;
			}
			if(realMovieTitle == null || realMovieTitle.equals("")){
				redirect = "../error.jsp";
				error = "El titulo original de la pelicula no puede ser vacio";
				err = true;
			}
			if(date == null || date.equals("")){
				redirect = "../error.jsp";
				error = "La fecha no puede estar vacia";
				err = true;
			}
			if(country == null || country.equals("")){
				request.setAttribute("error","El pais no puede estar vacio");
				redirect = "../error.jsp";
				error = "El pais no puede estar vacio";
				err = true;
			}
			if(director == null || director.equals("")){
				redirect = "../error.jsp";
				error = "El director no puede estar vacio";
				err = true;
			}
			if(casting == null || casting.equals("")){
				redirect = "../error.jsp";
				error = "El reparto no puede estar vacio";
				err = true;
			}
			if(genre == null || genre.equals("")){
				redirect = "../error.jsp";
				error = "El genero no puede estar vacio";
				err = true;
			}
			if(synopsis == null || synopsis.equals("")){
				redirect = "../error.jsp";
				error = "La sinopsis no puede estar vacia";
				err = true;
			}
			if(file == null || file.equals("")){
				redirect = "../error.jsp";
				error = "La imagen debe ser la url de una imagen";
				err = true;
			}
			
			if(!err){
			
				URLFetchService fetchService = URLFetchServiceFactory.getURLFetchService();
				
				HTTPResponse fetchResponse = fetchService.fetch(new URL(file));
				
				String fetchResponseContentType = null;
				for(HTTPHeader header : fetchResponse.getHeaders()){
					if(header.getName().equalsIgnoreCase("content-type")){
						fetchResponseContentType = header.getValue();
						break;
					}
				}
				
				Movie mov = new Movie(title, movieTitle, realMovieTitle, date, country, director, casting, genre, synopsis);
				mov.setImageType(fetchResponseContentType);
				mov.setImage(fetchResponse.getContent());
				
				MovieDAO dao = MovieDAO.getInstance();
				
				if(dao.createMovie(mov)){
					//System.out.println("pelicula creada");
				}else{
					//System.out.println("la pelicula ya existe");
					redirect = "../error.jsp";
					error = "La pelicula ya existe";
				}
			}
			
		}catch(IllegalArgumentException e){
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
			//request.getRequestDispatcher("../index.jsp").forward(request, response);
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.sendRedirect("../index.jsp");
	}
	
}
