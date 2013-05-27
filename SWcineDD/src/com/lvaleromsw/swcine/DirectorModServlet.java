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
import com.lvaleromsw.swcine.dao.MovieDAO;
import com.lvaleromsw.swcine.persistence.Director;
import com.lvaleromsw.swcine.persistence.Movie;

@SuppressWarnings("serial")
public class DirectorModServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String redirect = "/index.jsp";
		
		try{
			
			String str = request.getParameter("director");
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
			
			System.out.println(str);
			
			long key = Long.valueOf(str);
			
			Director dir = new Director(title, name, realName, birth, death, imagefile, ocupation, debut, awards, filmography);

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
			
			DirectorDAO dao = DirectorDAO.getInstance();
			
			if(dao.updateDirector(dir,key)){
				System.out.println("Director modificado");
			}else{
				System.out.println("Error al modificar director");
			}
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Error al modificar director");
		}finally{
			//request.setAttribute("movie",str);
			response.sendRedirect(redirect);
		}
	}
}
