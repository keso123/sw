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
import com.lvaleromsw.swcine.dao.ActorDAO;
import com.lvaleromsw.swcine.persistence.Actor;

@SuppressWarnings("serial")
public class ActorModServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String redirect = "index.jsp";
		String error = "";
		boolean err = false;
		
		try{
			
			String str = request.getParameter("actor");
			redirect = (String) request.getSession(true).getAttribute("url");
			
			String title = request.getParameter("title");
			String name = request.getParameter("name");
			String realName = request.getParameter("realName");
			String birth = request.getParameter("birth");
			String death = request.getParameter("death");
			String age = request.getParameter("age");
			String ocupation = request.getParameter("ocupation");
			String debut = request.getParameter("debut");
			String awards = request.getParameter("awards");
			String filmography = request.getParameter("filmography");
			String imagefile = request.getParameter("imagefile");
			
			if(str == null || str.equals("")){
				redirect = "index.jsp";
				error = "";
				err = true;
			}
			if(redirect == null || redirect.equals("")){
				redirect = "index.jsp";
				error = "";
				//err = true;
			}
			if(!err){
				long key = Long.valueOf(str);
				
				Actor dir = new Actor(title, name, realName, birth, death, age, ocupation, debut, awards, filmography);
	
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
					dir.setImageType(fetchResponseContentType);
					dir.setImage(fetchResponse.getContent());
				}
				
				ActorDAO dao = ActorDAO.getInstance();
				
				if(dao.updateActor(dir,key)){
					//System.out.println("Actor modificado");
				}else{
					//System.out.println("Error al modificar actor");
					redirect = "error.jsp";
					error = "Error al modificar actor";
					err = true;
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
			//request.setAttribute("movie",str);
			if(redirect.equals("error.jsp")) redirect += "?error="+error;
			response.sendRedirect(redirect);
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.sendRedirect("index.jsp");
	}
}
