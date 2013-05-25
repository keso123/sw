<!DOCTYPE html>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../css/index.css">

<title>CINE</title>

</head>

<body>

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
			<p><a href="../html/directorlist.html">Directores</a></p>
			<p><a href="../html/actorlist.html">Actores</a></p>
		</div>
		<div class="cine_left_menu_box">
			<h1>Mapa</h1>
			<p><a href="../html/sitemap.html">Mapa del sitio</a></p>
		</div>
		<div class="cine_left_menu_box">
			<h1>Tutoriales</h1>
			<p><a href="../html/tutorial.html">html5</a></p>
		</div>
		<div class="cine_left_menu_box"></div>
	</div>

</body>
</html>