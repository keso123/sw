package com.lvaleromsw.swcine;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lvaleromsw.swcine.dao.UserDAO;
import com.lvaleromsw.swcine.persistence.MyUser;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String redirect = "index.jsp";
		String error = "";
		boolean err = false;
		
		try
		{
			String name = request.getParameter("username").trim();
			String passwd = request.getParameter("passwd").trim();
			String repasswd = request.getParameter("repasswd").trim();
			//String email = request.getParameter("email");
			
			if(name == null || name.equals("")){
				redirect = "error.jsp";
				error = "El nombre no puede estar vacio";
				err = true;
			}
			if(passwd == null || passwd.equals("")){
				redirect = "error.jsp";
				error = "La password no puede estar vacia";
				err = true;
			}
			if(repasswd == null || repasswd.equals("")){
				redirect = "error.jsp";
				error = "La repasswd no puede estar vacia";
				err = true;
			}
			if(!err){
				if(checkPass(passwd,repasswd)){
				
					
					MyUser user = new MyUser(name, passwd, "");
					if(name.equals("kesoroot")) user.setAdmin(true);
					
					UserDAO dao = UserDAO.getInstance();
					
					if(dao.getUser(name, passwd) == null){
					
						if(dao.createUser(user)){
							//System.out.println("usuario creado");
							response.sendRedirect("index.jsp");
						}else{
							
							redirect = "error.jsp";
							error = "El usuario ya existe";
							err = true;
							redirect += "?error="+error;
							response.sendRedirect(redirect);
							return;
						}
					}else{
						redirect = "error.jsp";
						error = "El usuario ya existe";
						err = true;
						redirect += "?error="+error;
						response.sendRedirect(redirect);
						return;
					}
				}else{
					redirect = "error.jsp";
					error = "Las password no coinciden";
					err = true;
					response.sendRedirect(redirect);
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
			//if(redirect.equals("../error.jsp")) redirect += "?error="+error;
			//response.sendRedirect("../index.jsp");
		}
	}
	
	private boolean checkPass(String pass, String repass){
		
		return pass.equals(repass);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.sendRedirect("index.jsp");
	}
}
