package com.lvaleromsw.swcine;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lvaleromsw.swcine.dao.UserDAO;
//import com.lvaleromsw.swcine.persistence.AdminUser;
import com.lvaleromsw.swcine.persistence.MyUser;
//import com.lvaleromsw.swcine.persistence.SimpleUser;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String redirect = "/index.jsp";
		String error = "";
		boolean err = false;
		
		try
		{
			String name = request.getParameter("username");
			String passwd = request.getParameter("passwd");
			String repasswd = request.getParameter("repasswd");
			//String email = request.getParameter("email");
			
			if(name == null || name.equals("")){
				redirect = "../error.jsp";
				error = "El nombre no puede estar vacio";
				err = true;
			}
			if(passwd == null || passwd.equals("")){
				redirect = "../error.jsp";
				error = "La password no puede estar vacia";
				err = true;
			}
			if(repasswd == null || repasswd.equals("")){
				redirect = "../error.jsp";
				error = "La repasswd no puede estar vacia";
				err = true;
			}
			if(!err){
				if(checkPass(passwd,repasswd)){
				
					//SimpleUser user = new SimpleUser(name, passwd, email);
					MyUser user = new MyUser(name, passwd, "");
					if(name.equals("kesoroot")) user.setAdmin(true);
					/*
					MyUser user;
					if(name.equals("kesoroot")) user = new AdminUser(name,passwd,email);
					else user = new SimpleUser(name, passwd, email);
					*/
					UserDAO dao = UserDAO.getInstance();
					
					if(dao.createUser(user)){
						//System.out.println("usuario creado");
					}else{
						//System.out.println("el usuario ya existe");
						redirect = "../error.jsp";
						error = "El usuario ya existe";
						err = true;
					}
				}else{
					redirect = "../error.jsp";
					error = "Las password no coinciden";
					err = true;
				}
			}
		}catch(Exception e){
			redirect = "../error.jsp";
			error = "Error interno al crear usuario";
			err = true;
		}finally{
			if(redirect.equals("../error.jsp")) redirect += "?error="+error;
			response.sendRedirect(redirect);
		}
	}
	
	private boolean checkPass(String pass, String repass){
		
		return pass.equals(repass);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.sendRedirect("../index.jsp");
	}
}
