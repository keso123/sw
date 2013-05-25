<!DOCTYPE html>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../css/index.css">

<title>CINE</title>

</head>

<body>
<%@ page import="com.lvaleromsw.swcine.dao.MovieDAO" %>
<%@ page import="com.lvaleromsw.swcine.persistence.Movie" %>
<%@ page import="java.util.List" %>
<% 
	String searchtext = request.getParameter("s");
	String type = request.getParameter("stype");
	List<Movie> movies = MovieDAO.getInstance().searchMovies(searchtext);
%>

<%@ include file="topbanner.jsp" %>

<div class="cine_content_wrapper">
	<%@ include file="leftmenu.jsp" %>
	
	<div class="cine_main_wrapper">
	
	<div class="cine_list_title">
		<h1>Busqueda</h1>
		</div>
		<div class="cine_list_pags">
			<p>Pel&iacuteculas</p>
		</div>
		<div class="cine_list_content">
			<%
				//List<Movie> list = MovieDAO.getInstance().getMovies();
				if(movies != null)
				for(int i = 0; i < movies.size(); i++) { %>
			<div class="cine_list_content_box">
				<div class="cine_list_content_box_pic">
					<img alt="" src="../images/Delete.png" width="50" height="75">
				</div>
				<div class="cine_list_content_box_text">
					<h1><a href="../movie.jsp?movie=<%out.println(movies.get(i).getKey().getId());%>"><% out.println(movies.get(i).getRealMovieTitle()); %></a></h1>
					<h2><% out.println(movies.get(i).getDirector()); %></h2>
					<p><% out.println(movies.get(i).getCasting()); %></p>
				</div>
				<div class="cine_clear"></div>
			</div>
			<% }else{ %>
			<div class="cine_list_content_box">
				<div class="cine_list_content_box_pic">
					<img alt="" src="../images/Delete.png" width="50" height="75">
				</div>
				<div class="cine_list_content_box_text">
					<h1>NO HAY PELICULAS</h1>
				</div>
				<div class="cine_clear"></div>
			</div>
			<% } %>
		</div>
	</div>
	<div class="cine_clear"></div>
</div>

<%@ include file="bottombanner.jsp" %>

</body>
</html>