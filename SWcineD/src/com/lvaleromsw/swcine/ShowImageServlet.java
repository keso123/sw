package com.lvaleromsw.swcine;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lvaleromsw.swcine.dao.MovieDAO;
import com.lvaleromsw.swcine.persistence.Movie;

@SuppressWarnings("serial")
public class ShowImageServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			MovieDAO dao = MovieDAO.getInstance();
			
			Movie mov = dao.getMovie(Long.valueOf(request.getParameter("movie")));
			
			response.setContentType(mov.getImageType());
			response.getOutputStream().write(mov.getImage());
			
		}catch(Exception e){
			
		}finally{
			
		}
	}
}
