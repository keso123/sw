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
import com.lvaleromsw.swcine.dao.DirectorDAO;
import com.lvaleromsw.swcine.persistence.Director;

@SuppressWarnings("serial")
public class DirectorAddServlet extends HttpServlet {

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
			
			Director dir = new Director(title, name, realName, birth, death, age, ocupation, debut, awards, filmography);
			
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
				
				dir.setImageType(fetchResponseContentType);
				dir.setImage(fetchResponse.getContent());
			}
			
			DirectorDAO dao = DirectorDAO.getInstance();
			
			if(dao.createDirector(dir)){
				System.out.println("director creado");
			}else{
				System.out.println("el director ya existe");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("error al crear director");
		}finally{
			response.sendRedirect(redirect);
		}
	}
}
