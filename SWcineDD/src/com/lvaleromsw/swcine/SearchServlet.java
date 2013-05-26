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
			
			if(type.equals("all")){
				//MovieDAO dao = MovieDAO.getInstance();
			}else if(type.equals("title")){
				//response.sendRedirect("/movies.jsp?letter="+searchtext);
				request.setAttribute("stype",type);
				redirect = "/searchs.jsp?s="+searchtext;
			}else if(type.equals("director")){
				
			}else if(type.equals("cast")){
				
			}else{
				
			}
			
		}catch(Exception e){
			
		}finally{
			response.sendRedirect(redirect);
		}
	}
}
