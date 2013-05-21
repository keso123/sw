<!DOCTYPE html>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../css/index.css">

<title>CINE</title>

</head>

<body>
<div class="cine_top_banner_wrapper">

	<div class="cine_top_banner_title_wrapper">
		
		<div class="cine_top_banner_title_content">
			<div class="cine_top_banner_title_content_title">
			<h1><a href="../index.jsp">SW Cine</a></h1>
			</div>
			<div class="cine_top_banner_title_content_search">
					<form action="#">
						<input type="text" name="stext" size="20" value="">
						<select name="stype">
							<option value="all">Todos</option>
							<option value="title">T&iacutetulo</option>
							<option value="director">Director</option>
							<option value="cast">Reparto</option>
						</select>
						<input type="submit" id="button-search" value="Buscar">
					</form>
			</div>
			<div class="cine_top_banner_title_content_login">
				<% 
						Object user = session.getAttribute("username");
					    if (user == null) {
				%>
				<p><a href="../login.jsp">Entrar</a>/<a href="../register.jsp">Registrarse</a></p>
				<%
					    }else{
				%>
				<p><a href=<%= request.getContextPath()+"logoutservlet"%>>Salir</a></p>
				<%
					    }
				%>
			</div>
			<div class="cine_clear"></div>
		</div>
		
	</div>
	<div class=cine_top_banner_menu_wrapper>
		<div class="cine_top_banner_menu_content">
			<!-- <div class="cine_top_banner_menu_content_box">
				<h1><a href="#">Usuarios</a></h1>
				<div class="cine_top_banner_menu_content_box_hide">
					<h1>entrar</h1>
				</div>
			</div>
			<div class="cine_top_banner_menu_content_box">
				<h1>Secciones</h1>
			</div>
			<div class="cine_top_banner_menu_content_box">
				<h1>Admin</h1>
			</div>
			<div class="cine_clear"></div>  --> 
			
			<nav>
				<ul>
					<li><a href="../index.jsp">Inicio</a></li>
					
					<li class="cine_top_banner_menu_content_parent">
						<a href="#">Secciones</a>
						<ul>
							<li><a href="../html/movielist.html">Pel&iacuteculas</a></li>
							<li><a href="../html/directorlist.html">Directores</a></li>
							<li><a href="../html/actorlist.html">Actores</a></li>
						</ul>
					</li>
					
					<li class="cine_top_banner_menu_content_parent">
						<a href="#">Usuarios</a>
						<ul>
							<% 
					    		if (user == null) {
							%>
							<li><a href="../login.jsp">Entrar</a></li>
							<li><a href="../register.jsp">Registarse</a></li>
							<%
								}else{
							%>
							<li><a href=<%= request.getContextPath()+"logoutservlet"%>>Salir</a></li>
							<%
								}
							%>
						</ul>
					</li>
					
					<% 
						Object admin = session.getAttribute("admin");
					    if (admin != null) {
					%>
					<li class="cine_top_banner_menu_content_parent">
						<a href="#">A&ntildeadir</a>
						<ul>
							<li><a href="../html/addmovie.html">Pel&iacutecula</a></li>
							<li><a href="../html/adddirector.html">Director</a></li>
							<li><a href="../html/addactor.html">Actor</a></li>
						</ul>
					</li>
					<%
						}else{}
					%>
				</ul>
			</nav>
			
		</div>
	</div>

</div>
</body>
</html>