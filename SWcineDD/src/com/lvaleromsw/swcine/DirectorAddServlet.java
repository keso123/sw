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
		String error = "";
		boolean err = false;
		
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
			
			if(title == null || title.equals("")){
				redirect = "../error.jsp";
				error ="El titulo no puede ser vacio";
				err = true;
			}
			if(name == null || name.equals("")){
				redirect = "../error.jsp";
				error ="El nombre no puede ser vacio";
				err = true;
			}
			if(realName == null || realName.equals("")){
				redirect = "../error.jsp";
				error ="El nombre real no puede ser vacio";
				err = true;
			}
			if(birth == null || birth.equals("")){
				redirect = "../error.jsp";
				error ="El nacimiento no puede ser vacio";
				err = true;
			}
			if(death == null || death.equals("")){
				redirect = "../error.jsp";
				error ="LA muerte no puede ser vacio, poner '-' si no esta muerto";
				err = true;
			}
			if(age == null || age.equals("")){
				redirect = "../error.jsp";
				error ="La edad no puede ser vacia";
				err = true;
			}
			if(ocupation == null || ocupation.equals("")){
				redirect = "../error.jsp";
				error ="La ocupacion no puede ser vacia";
				err = true;
			}
			if(debut == null || debut.equals("")){
				redirect = "../error.jsp";
				error ="El debut no puede ser vacio";
				err = true;
			}
			if(awards == null || awards.equals("")){
				redirect = "../error.jsp";
				error ="Los premios no pueden ser vacios, poner '-' si no tiene";
				err = true;
			}
			if(filmography == null || filmography.equals("")){
				redirect = "../error.jsp";
				error ="La filmografia no puede ser vacia";
				err = true;
			}
			if(!err){
				Director dir = new Director(title, name, realName, birth, death, age, ocupation, debut, awards, filmography);
				
				if(request.getParameter("imagefile") != null && !request.getParameter("imagefile").equals("")){
				
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
				}else{
					redirect = "../error.jsp";
					error ="La imagen tiene que ser la url de una imagen";
					err = true;
				}
				
				if(!err){
					DirectorDAO dao = DirectorDAO.getInstance();
					
					if(dao.createDirector(dir)){
						//System.out.println("director creado");
					}else{
						redirect = "../error.jsp";
						error ="El director ya existe";
						err = true;
					}
				}
			}
			
		}catch(java.lang.IllegalArgumentException e){
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
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.sendRedirect("../index.jsp");
	}
}
