<!DOCTYPE html>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../css/index.css">

<script type="text/javascript" src="../js/jquery-2.0.1.min.js"></script>
<script type="text/javascript" src="/js/checklogin.js"></script>

<title>CINE</title>

</head>

<body>

<% 
try{
	//Object user = session.getAttribute("username");
	//Object admin = session.getAttribute("admin");
	//String redirect = request.getRequestURI();
	//System.out.print(redirect);
	//request.setAttribute("url",redirect);
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
		
			<form name="check_login" id="check_login"
			action="loginservlet" method="post">
			
				<div class="cine_login_frame_row">
					<div class="cine_login_frame_colum">
						<h1>Usuario:</h1>
					</div>
					<div class="cine_login_frame_colum">
						<input id="username" type="text" name="username" size="20" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_login_frame_row">
					<div class="cine_login_frame_colum">
						<h1>Contrase&ntildea:</h1>
					</div>
					<div class="cine_login_frame_colum">
						<input id="passwd" type="password" name="passwd" size="20" value="">
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
<%
}catch(Exception e){
	response.sendRedirect("../index.jsp");	
}
%>
</body>

</html>