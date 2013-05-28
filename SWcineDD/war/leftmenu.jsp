<!DOCTYPE html>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../css/index.css">

<title>CINE</title>

</head>

<body>
<% try{%>
<div class="cine_left_menu">
		<div class="cine_left_menu_box">
			<h1>Usuarios</h1>
			<% if(session.getAttribute("username") == null){ %>
			<p><a href="../login.jsp">Entrar</a></p>
			<p><a href="../register.jsp">Registro</a></p>
			<% }else{ %>
			<p><a href=<%= request.getContextPath()+"logoutservlet"%>>Salir</a></p>
			<% } %>
		</div>
		<div class="cine_left_menu_box">
			<h1>Secciones</h1>
			<p><a href="../movies.jsp?letter=a">Peliculas</a></p>
			<p><a href="../directors.jsp?letter=a">Directores</a></p>
			<p><a href="../actors.jsp?letter=a">Actores</a></p>
		</div>
		<div class="cine_left_menu_box">
			<h1>Mapa</h1>
			<p><a href="../sitemap.jsp">Mapa del sitio</a></p>
		</div>
		<div class="cine_left_menu_box">
			<h1>Tutoriales</h1>
			<p><a href="../tutorial.html">html5</a></p>
		</div>
		<div class="cine_left_menu_box"></div>
	</div>
<%
}catch(java.lang.IllegalArgumentException e){
	response.sendRedirect("index.jsp");
}catch(Exception e){
	response.sendRedirect("index.jsp");
}
%>
</body>
</html>