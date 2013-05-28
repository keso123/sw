package com.lvaleromsw.swcine;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class SearchServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String redirect = "/index.jsp";
		boolean err = false;
		try{
			String searchtext = request.getParameter("searchtext");
			String type = request.getParameter("stype");
			//request.setAttribute("stype",type);
			
			//System.out.println(type);
			
			if(searchtext == null){
				err = true;
			}
			if(type == null){
				err = true;
			}
			if((type.equals("all") || type.equals("title") || type.equals("director") || type.equals("cast"))
					&& err == false){
				redirect = "/searchs.jsp?stype="+type+"&s="+searchtext;
			}
			
		}catch(java.lang.IllegalArgumentException e){
			
		}catch(Exception e){
			
		}finally{
			response.sendRedirect(redirect);
		}
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.sendRedirect("../index.jsp");
	}
}
