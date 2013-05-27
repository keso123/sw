package com.lvaleromsw.swcine;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lvaleromsw.swcine.dao.ActorDAO;

@SuppressWarnings("serial")
public class ActorDelServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String redirect = "/index.jsp";
		try{
			String str = request.getParameter("actor");
			long key = Long.valueOf(str);
			ActorDAO dao = ActorDAO.getInstance();
			
			if(dao.deleteActor(key)){
				redirect = "/actors.jsp?letter=a";
			}else{
				System.out.println("el actor no existe");
			}
		}catch(Exception e){
			System.out.println("Error al borrar actor");
		}finally{
			response.sendRedirect(redirect);
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String redirect = "/index.jsp";
		try{
			String str = request.getParameter("actor");
			long key = Long.valueOf(str);
			ActorDAO dao = ActorDAO.getInstance();
			
			if(dao.deleteActor(key)){
				redirect = "/actors.jsp?letter=a";
			}else{
				System.out.println("el actor no existe");
			}
		}catch(Exception e){
			System.out.println("Error al borrar actor");
		}finally{
			response.sendRedirect(redirect);
		}
	}
}