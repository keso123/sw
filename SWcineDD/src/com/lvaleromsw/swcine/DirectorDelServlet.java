package com.lvaleromsw.swcine;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lvaleromsw.swcine.dao.DirectorDAO;

@SuppressWarnings("serial")
public class DirectorDelServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String redirect = "/index.jsp";
		try{
			String str = request.getParameter("director");
			long key = Long.valueOf(str);
			DirectorDAO dao = DirectorDAO.getInstance();
			
			if(dao.deleteDirector(key)){
				redirect = "/directors.jsp?letter=a";
			}else{
				System.out.println("el director no existe");
			}
		}catch(Exception e){
			System.out.println("Error al borrar director");
		}finally{
			response.sendRedirect(redirect);
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String redirect = "/index.jsp";
		try{
			String str = request.getParameter("director");
			long key = Long.valueOf(str);
			DirectorDAO dao = DirectorDAO.getInstance();
			
			if(dao.deleteDirector(key)){
				redirect = "/directors.jsp?letter=a";
			}else{
				System.out.println("el director no existe");
			}
		}catch(Exception e){
			System.out.println("Error al borrar director");
		}finally{
			response.sendRedirect(redirect);
		}
	}
}
