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
public class MovieModServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String redirect = "/index.jsp";
		
		try{
			String str = request.getParameter("movie");
			redirect = (String) request.getSession(true).getAttribute("url");
			
			String title = request.getParameter("title");
			String movieTitle = request.getParameter("movieTitle");
			String realMovieTitle = request.getParameter("realMovieTitle");
			String date = request.getParameter("date");
			String country = request.getParameter("country");
			String director = request.getParameter("director");
			String casting = request.getParameter("casting");
			String genre = request.getParameter("genre");
			String synopsis = request.getParameter("synopsis");
			String imagefile = request.getParameter("imagefile");
			
			System.out.println(title);
			System.out.println(movieTitle);
			System.out.println(realMovieTitle);
			System.out.println(date);
			System.out.println(country);
			System.out.println(director);
			System.out.println(casting);
			System.out.println(genre);
			System.out.println(synopsis);
			System.out.println(imagefile);
			
			long key = Long.valueOf(str);
			
			Movie mov = new Movie(title,
								  movieTitle,
								  realMovieTitle,
								  date,
								  country,
								  director,
								  casting,
								  genre,
								  synopsis);
			if(imagefile != null && !imagefile.equals("")){
				URLFetchService fetchService = URLFetchServiceFactory.getURLFetchService();
				
				HTTPResponse fetchResponse = fetchService.fetch(new URL(request.getParameter("imagefile")));
				
				String fetchResponseContentType = null;
				for(HTTPHeader header : fetchResponse.getHeaders()){
					if(header.getName().equalsIgnoreCase("content-type")){
						fetchResponseContentType = header.getValue();
						break;
					}
				}
				mov.setImageType(fetchResponseContentType);
				mov.setImage(fetchResponse.getContent());
			}
			
			MovieDAO dao = MovieDAO.getInstance();
			
			if(dao.updateMovie(mov,key)){
				System.out.println("Pelicula modificada");
			}else{
				System.out.println("Error al modificar pelicula");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al modificar pelicula");
		}finally{
			//request.setAttribute("movie",str);
			response.sendRedirect(redirect);
		}
	}
	
}
