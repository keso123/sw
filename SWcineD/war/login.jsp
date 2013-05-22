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

<%@ include file="topbanner.jsp" %>

<!-- ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo -->
<!-- ooooooooooooooooooooooooooooooooooooooooo FIN MENU BANNER ooooooooooooooooooooooooooooooooooooooooo -->
<!-- ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo -->

<div class="cine_content_wrapper">

	<%@ include file="leftmenu.jsp" %>
	
<!-- oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo -->
<!-- ooooooooooooooooooooooooooooooooooooooooo FIN MENU LATERAL ooooooooooooooooooooooooooooooooooooooooo -->
<!-- oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo -->

	<div class="cine_main_wrapper">
		<div class="cine_login_title">
			<h1>Acceso a usuarios</h1>
		</div>
		<div class="cine_login_frame">
			<form action="loginservlet" method="post">
				<div class="cine_login_frame_row">
					<div class="cine_login_frame_colum">
						<h1>Usuario:</h1>
					</div>
					<div class="cine_login_frame_colum">
						<input type="text" name="username" size="20" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_login_frame_row">
					<div class="cine_login_frame_colum">
						<h1>Contrase&ntildea:</h1>
					</div>
					<div class="cine_login_frame_colum">
						<input type="password" name="passwd" size="20" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_login_frame_row">
					<input type="submit" id="button-send" value="Enviar">
				</div>
				<div class="cine_clear"></div>
				
			</form>
		</div>
	</div>
	<div class="cine_clear"></div>

</div>

<!-- oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo -->
<!-- ooooooooooooooooooooooooooooooooooooooooo FIN MAIN ooooooooooooooooooooooooooooooooooooooooo -->
<!-- oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo -->

<%@ include file="bottombanner.jsp" %>

</body>

</html>