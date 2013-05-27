package com.lvaleromsw.swcine;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lvaleromsw.swcine.dao.ActorDAO;
import com.lvaleromsw.swcine.dao.DirectorDAO;
import com.lvaleromsw.swcine.dao.MovieDAO;
import com.lvaleromsw.swcine.persistence.Actor;
import com.lvaleromsw.swcine.persistence.Director;
import com.lvaleromsw.swcine.persistence.Movie;

@SuppressWarnings("serial")
public class ShowImageServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			
			String data = request.getParameter("movie");
			
			if(data != null){
			
				MovieDAO dao = MovieDAO.getInstance();
				
				Movie mov = dao.getMovie(Long.valueOf(request.getParameter("movie")));
				
				response.setContentType(mov.getImageType());
				response.getOutputStream().write(mov.getImage());
				return;
			}
			
			data = request.getParameter("director");
			
			if(data != null){
				DirectorDAO dao = DirectorDAO.getInstance();
				
				Director dir = dao.getDirector(Long.valueOf(data));
				
				response.setContentType(dir.getImageType());
				response.getOutputStream().write(dir.getImage());
				
			}
			
			data = request.getParameter("actor");
			
			if(data != null){
				ActorDAO dao = ActorDAO.getInstance();
				
				Actor actor = dao.getActor(Long.valueOf(data));
				
				response.setContentType(actor.getImageType());
				response.getOutputStream().write(actor.getImage());
				
			}
			
		}catch(Exception e){
			
		}finally{
			
		}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.sendRedirect("../index.jsp");
	}
}
