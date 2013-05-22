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
	//Object user = session.getAttribute("username");
	//Object admin = session.getAttribute("admin");
%>

<%@ include file="topbanner.jsp" %>

<div class="cine_content_wrapper">
	<%@ include file="leftmenu.jsp" %>
	
	<div class="cine_main_wrapper">
	
	<div class="cine_list_title">
		<h1>Lista de pel&iacuteculas</h1>
		</div>
		<div class="cine_list_abc_wrapper">
			<div class="cine_list_abc">
			<p><a href="#">*</a>
			   <a href="#">0-9</a>
			   <a href="#">A</a>
			   <a href="#">B</a>
			   <a href="#">C</a>
			   <a href="#">D</a>
			   <a href="#">E</a>
			   <a href="#">F</a>
			   <a href="#">G</a>
			   <a href="#">H</a>
			   <a href="#">I</a>
			   <a href="#">J</a>
			   <a href="#">K</a>
			   <a href="#">L</a>
			   <a href="#">M</a>
			   <a href="#">N</a>
			   <a href="#">O</a>
			   <a href="#">P</a>
			   <a href="#">Q</a>
			   <a href="#">R</a>
			   <a href="#">S</a>
			   <a href="#">T</a>
			   <a href="#">U</a>
			   <a href="#">V</a>
			   <a href="#">W</a>
			   <a href="#">X</a>
			   <a href="#">Y</a>
			   <a href="#">Z</a></p>
			</div>
		</div>
		<div class="cine_list_pags">
			<p>
				<a href="#">Inicio</a>
				<a href="#">Anterior</a>
				<a href="#">Siguiente</a>
				<a href="#">Fin</a>
			</p>
		</div>
		<div class="cine_list_content">
			<%
				List<Movie> list = MovieDAO.getInstance().getMovies();
				if(list != null)
				for(int i = 0; i < list.size(); i++) { %>
			<div class="cine_list_content_box">
				<div class="cine_list_content_box_pic">
					<img alt="" src="../images/Delete.png" width="50" height="75">
				</div>
				<div class="cine_list_content_box_text">
					<h1><a href="../html/movie.html"><% out.println(list.get(i).getRealMovieTitle()); %></a></h1>
					<h2><% out.println(list.get(i).getDirector()); %></h2>
					<p><% out.println(list.get(i).getCasting()); %></p>
				</div>
				<div class="cine_clear"></div>
			</div>
			<% } %>
		</div>
		<div class="cine_list_pags">
			<p>
				<a href="#">Inicio</a>
				<a href="#">Anterior</a>
				<a href="#">Siguiente</a>
				<a href="#">Fin</a>
			</p>
		</div>
	
	</div>
	<div class="cine_clear"></div>
</div>

<%@ include file="bottombanner.jsp" %>

</body>
</html>