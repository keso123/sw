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
public class ActorAddServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String redirect = "/index.jsp";
		try{
			
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
			
			System.out.println(title);
			System.out.println(name);
			System.out.println(realName);
			System.out.println(birth);
			System.out.println(death);
			System.out.println(age);
			System.out.println(ocupation);
			System.out.println(debut);
			System.out.println(awards);
			System.out.println(filmography);
			
			Actor actor = new Actor(title, name, realName, birth, death, age, ocupation, debut, awards, filmography);
			
			if(request.getParameter("imagefile") != null){
			
				URLFetchService fetchService = URLFetchServiceFactory.getURLFetchService();
				
				HTTPResponse fetchResponse = fetchService.fetch(new URL(request.getParameter("imagefile")));
				
				String fetchResponseContentType = null;
				for(HTTPHeader header : fetchResponse.getHeaders()){
					if(header.getName().equalsIgnoreCase("content-type")){
						fetchResponseContentType = header.getValue();
						break;
					}
				}
				
				actor.setImageType(fetchResponseContentType);
				actor.setImage(fetchResponse.getContent());
			}
			
			ActorDAO dao = ActorDAO.getInstance();
			
			if(dao.createActor(actor)){
				System.out.println("actor creado");
			}else{
				System.out.println("el actor ya existe");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("error al crear actor");
		}finally{
			response.sendRedirect(redirect);
		}
	}
}
