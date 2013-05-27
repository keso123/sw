<!DOCTYPE html>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../css/index.css">

<title>CINE</title>

</head>

<body>
<%@ page import="com.lvaleromsw.swcine.dao.MovieDAO" %>
<%@ page import="com.lvaleromsw.swcine.dao.DirectorDAO" %>
<%@ page import="com.lvaleromsw.swcine.dao.ActorDAO" %>
<%@ page import="com.lvaleromsw.swcine.persistence.Movie" %>
<%@ page import="com.lvaleromsw.swcine.persistence.Director" %>
<%@ page import="com.lvaleromsw.swcine.persistence.Actor" %>
<%@ page import="java.util.List" %>
<% 
	String searchtext = request.getParameter("s");
	String type = request.getParameter("stype");
	//System.out.println(request.getParameter("stype"));
	List<Movie> movies = null;
	List<Director> dir = null;
	List<Actor> actor = null;
	
	if(type.equals("all") || type.equals("title"))
		movies = MovieDAO.getInstance().searchMovies(searchtext);
	
	if(type.equals("all") || type.equals("director"))
		dir = DirectorDAO.getInstance().searchDirectors(searchtext);
	
	if(type.equals("all") || type.equals("cast"))
		actor = ActorDAO.getInstance().searchActors(searchtext);
	
	session.setAttribute("url","/searchs.jsp?s="+searchtext);
%>

<%@ include file="topbanner.jsp" %>

<div class="cine_content_wrapper">
	<%@ include file="leftmenu.jsp" %>

	<div class="cine_main_wrapper">

		<div class="cine_list_title">
		<h1>Busqueda</h1>
		</div>
		
		<% if(movies == null && dir == null && actor == null){ %>
			<div class="cine_list_pags">
				<p>No se ha encontrado nada</p>
			</div>
		<% } %>
		
		<%
				//List<Movie> list = MovieDAO.getInstance().getMovies();
				if(movies != null)
				for(int i = 0; i < movies.size(); i++) { 
		%>
		
		<div class="cine_list_pags">
			<p>Pel&iacuteculas</p>
		</div>
		<div class="cine_list_content">
			
			<div class="cine_list_content_box">
				<div class="cine_list_content_box_pic">
					<img alt="" src="showimageservlet?movie=<%= movies.get(i).getKey().getId() %>" width="50" height="75">
				</div>
				<div class="cine_list_content_box_text">
					<h1><a href="../movie.jsp?movie=<%out.println(movies.get(i).getKey().getId());%>"><% out.println(movies.get(i).getRealMovieTitle()); %></a></h1>
					<h2><% out.println(movies.get(i).getDirector()); %></h2>
					<p><% out.println(movies.get(i).getCasting()); %></p>
				</div>
				<div class="cine_clear"></div>
			</div>
			
			
		</div>
		
		<% } %>
		
		<%
				//List<Movie> list = MovieDAO.getInstance().getMovies();
				if(dir != null)
				for(int i = 0; i < dir.size(); i++) { 
		%>
		
		<div class="cine_list_pags">
			<p>Directores</p>
		</div>
		<div class="cine_list_content">
			
			<div class="cine_list_content_box">
				<div class="cine_list_content_box_pic">
					<img alt="" src="showimageservlet?director=<%= dir.get(i).getKey().getId() %>" width="50" height="75">
				</div>
				<div class="cine_list_content_box_text">
					<h1><a href="../director.jsp?director=<%out.println(dir.get(i).getKey().getId());%>"><% out.println(dir.get(i).getRealName()); %></a></h1>
					<h2><% out.println(dir.get(i).getOcupation()); %></h2>
					<p><% out.println(dir.get(i).getAwards()); %></p>
				</div>
				<div class="cine_clear"></div>
			</div>
			
			
		</div>
		
		<% } %>
		
		<%
				//List<Movie> list = MovieDAO.getInstance().getMovies();
				if(actor != null)
				for(int i = 0; i < actor.size(); i++) { 
		%>
		
		<div class="cine_list_pags">
			<p>Actores</p>
		</div>
		<div class="cine_list_content">
			
			<div class="cine_list_content_box">
				<div class="cine_list_content_box_pic">
					<img alt="" src="showimageservlet?actor=<%= actor.get(i).getKey().getId() %>" width="50" height="75">
				</div>
				<div class="cine_list_content_box_text">
					<h1><a href="../actor.jsp?actor=<%out.println(actor.get(i).getKey().getId());%>"><% out.println(actor.get(i).getRealName()); %></a></h1>
					<h2><% out.println(actor.get(i).getOcupation()); %></h2>
					<p><% out.println(actor.get(i).getAwards()); %></p>
				</div>
				<div class="cine_clear"></div>
			</div>
			
			
		</div>
		
		<% } %>
		
	</div>
	<div class="cine_clear"></div>
</div>

<%@ include file="bottombanner.jsp" %>

</body>
</html>