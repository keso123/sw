<!DOCTYPE html>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../css/index.css">

<script type="text/javascript" src="../js/jquery-2.0.1.min.js"></script>
<script type="text/javascript" src="/js/checkmovie.js"></script>

<title>CINE</title>

</head>

<body>

<% 
try{
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
			<h1>Registro</h1>
		</div>
		<div class="cine_login_frame">
			<form name="check_reg" id="check_reg"
			action="registerservlet" method="post">
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
						<h1>Contrase&ntilde;a:</h1>
					</div>
					<div class="cine_login_frame_colum">
						<input type="password" name="passwd" size="20" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_login_frame_row">
					<div class="cine_login_frame_colum">
						<h1>Repetir Contrase&ntilde;a:</h1>
					</div>
					<div class="cine_login_frame_colum">
						<input type="password" name="repasswd" size="20" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<!--  <div class="cine_login_frame_row">
					<div class="cine_login_frame_colum">
						<h1>Email:</h1>
					</div>
					<div class="cine_login_frame_colum">
						<input type="text" name="email" size="20" value="root@gmail.com">
					</div>
				</div>
				<div class="cine_clear"></div>-->
				
				<div class="cine_login_frame_row">
					<input type="button" id="button-send" onclick="checkReg()" value="Enviar">
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
}catch(java.lang.IllegalArgumentException e){
	response.sendRedirect("index.jsp");
}catch(Exception e){
	response.sendRedirect("index.jsp");
}
%>
</body>

</html>