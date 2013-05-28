package com.lvaleromsw.swcine;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lvaleromsw.swcine.dao.UserDAO;
import com.lvaleromsw.swcine.persistence.MyUser;
//import com.lvaleromsw.swcine.persistence.SimpleUser;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String redirect = "/index.jsp";
		String error = "";
		boolean err = false;
		
		try{
		HttpSession sesion = request.getSession(true);
		String name = request.getParameter("username");
		String passwd = request.getParameter("passwd");
		String url = (String) sesion.getAttribute("url");
		
		if(name == null || name.equals("")){
			redirect = "../error.jsp";
			error = "El nombre de usuario no puede ser vacio";
			err = true;
			//response.sendRedirect("../error.jsp?error=El%usuario%o%la%password%no%son%validos");
		}
		
		if(passwd == null || passwd.equals("")){
			redirect = "../error.jsp";
			error = "La password no puede ser vacia";
			err = true;
		}
			
		if(!err){
			UserDAO dao = UserDAO.getInstance();
			//SimpleUser user = dao.getUser(name,passwd);
			MyUser user = dao.getUser(name,passwd);
			if(user == null){
				//System.out.println("usuario no valido");
				redirect = "../error.jsp";
				error = "El usuario o la contraseña no son validos";
				//if(redirect.equals("../error.jsp")) redirect += "?error="+error;
				//response.sendRedirect("../error.jsp?error=El%usuario%o%la%password%no%son%validos");
			}else{
				sesion = request.getSession(true);
				sesion.setAttribute("username",user.getName());
				
				if(user.isAdmin()) sesion.setAttribute("admin","true");
				
				//System.out.println("login correcto");
				//System.out.println(url);
				if(url != null && !url.equals("") )
					redirect = url;
				//response.sendRedirect(redirect);
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

