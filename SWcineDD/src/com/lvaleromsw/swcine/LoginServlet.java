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
		//response.setContentType("text/html");
		String redirect = "index.jsp";
		String error = "";
		boolean err = false;
		
		try{
		HttpSession sesion = request.getSession(true);
		String name = request.getParameter("username").trim();
		String passwd = request.getParameter("passwd").trim();
		String url = (String) sesion.getAttribute("url");
		
		if(name == null || name.equals("")){
			redirect = "error.jsp";
			error = "El nombre de usuario no puede ser vacio";
			err = true;
			redirect += "?error="+error;
			response.sendRedirect(redirect);
			return;
		}
		
		if(passwd == null || passwd.equals("")){
			redirect = "error.jsp";
			error = "La password no puede ser vacia";
			err = true;
			redirect += "?error="+error;
			response.sendRedirect(redirect);
			return;
		}
			
		if(!err){
			UserDAO dao = UserDAO.getInstance();
			MyUser user = dao.getUser(name,passwd);
			if(user == null){
				redirect = "error.jsp";
				error = "El usuario o la password no son validos";
				redirect += "?error="+error;
				response.sendRedirect(redirect);
				return;
			}else{
				sesion.setAttribute("username",user.getName());
				
				if(user.isAdmin()) sesion.setAttribute("admin","true");
				
				if(url != null && !url.equals("") )
					redirect = url;
				response.sendRedirect(url);
				return;
			}
		}
		
		}catch(java.lang.IllegalArgumentException e){
			redirect = "error.jsp";
			error = "Error interno al hacer login";
			redirect += "?error="+error;
			response.sendRedirect(redirect);
			return;
		}catch(Exception e){
			redirect = "error.jsp";
			error ="Error interno al hacer login";
			err = true;
			redirect += "?error="+error;
			response.sendRedirect(redirect);
			return;
		}/*finally{
			//if(redirect.equals("../error.jsp")) redirect += "?error="+error;
			//response.sendRedirect("../index.jsp");
		}*/
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.sendRedirect("index.jsp");
	}
}

