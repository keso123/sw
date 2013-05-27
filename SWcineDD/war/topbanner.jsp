<!DOCTYPE html>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../css/index.css">

<title>CINE</title>

</head>

<body>

<% 
	//Object user = session.getAttribute("username");
	//Object admin = session.getAttribute("admin");
%>

<div class="cine_top_banner_wrapper">

	<div class="cine_top_banner_title_wrapper">
		
		<div class="cine_top_banner_title_content">
			<div class="cine_top_banner_title_content_title">
			<h1><a href="../index.jsp">SW Cine</a></h1>
			</div>
			<div class="cine_top_banner_title_content_search">
					<form action="searchservlet" method="post">
						<input type="text" name="searchtext" size="20" value="">
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
					    if (session.getAttribute("username") == null) {
				%>
				<p><a href="../login.jsp">Entrar</a>/<a href="../register.jsp">Registro</a></p>
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
							<li><a href="../movies.jsp?letter=a">Pel&iacuteculas</a></li>
							<li><a href="../directors.jsp?letter=a">Directores</a></li>
							<li><a href="../actor.jsp?letter=a">Actores</a></li>
						</ul>
					</li>
					
					<li class="cine_top_banner_menu_content_parent">
						<a href="#">Usuarios</a>
						<ul>
							<% 
					    		if (session.getAttribute("username") == null) {
							%>
							<li><a href="../login.jsp">Entrar</a></li>
							<li><a href="../register.jsp">Registro</a></li>
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
					    if (session.getAttribute("admin") != null) {
					%>
					<li class="cine_top_banner_menu_content_parent">
						<a href="#">A&ntildeadir</a>
						<ul>
							<li><a href="../newmovie.jsp?c=add">Pel&iacutecula</a></li>
							<li><a href="../newdirector.jsp?c=add">Director</a></li>
							<li><a href="../newactor.jsp?c=add">Actor</a></li>
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