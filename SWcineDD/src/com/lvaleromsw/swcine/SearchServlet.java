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
		try{
			String searchtext = request.getParameter("searchtext");
			String type = request.getParameter("stype");
			//request.setAttribute("stype",type);
			
			System.out.println(type);
			redirect = "/searchs.jsp?stype="+type+"&s="+searchtext;
			
		}catch(Exception e){
			
		}finally{
			response.sendRedirect(redirect);
		}
	}
}
