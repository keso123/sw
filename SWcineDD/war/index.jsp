<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../css/index.css">

<title>CINE</title>

</head>

<body>

<% 
try{
	//Object user = session.getAttribute("username");
	//Object admin = session.getAttribute("admin");
	session.setAttribute("url","/index.jsp");
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
		<div class="cine_index">
			<h1>Propuestas Sistemas Web</h1>
			<h2>Propuesta de web</h2>
	
	<p>
Descripci&oacute;n: 
Desarrollar una web sobre cine. La idea es que cualquier persona pueda encontrar informaci&oacute;n de pel&iacute;culas, directores, actores, etc. 
Se podr&aacute;n crear usuarios para que estos comenten en las entradas (pel&iacute;culas, directores, etc) y las puntuen. S&oacute;lo se podr&aacute; comentar o puntuar si 
eres un usuario registrado en la web y est&aacute;s logeado en ese momento.
</p>
	
	<p>
En la entrada de un director se encontrar&aacute; una descripci&oacute;n y se enlazar&aacute; una lista con todas sus pel&iacute;culas. En la de un actor se encontrar&aacute; otra 
descripci&oacute;n y otra lista con todas sus pel&iacute;culas. En la entrada de una pel&iacute;cula se encontrar&aacute; toda la informaci&oacute;n relativa a la pel&iacute;cula (director, 
reparto, a&ntilde;o, premios, etc).
	</p>
	
	<p>
Parte p&uacute;blica y privada: 
Cualquier persona podr&aacute; ver todos los contenidos de la p&aacute;gina web. S&oacute;lo usuarios registrados podr&aacute;n comentar y puntuar las entradas de la web. 
Los &uacute;nicos que puede editar los contenidos de las entradas ser&aacute;n los administradores de la web.
	</p>
	
<p>Tipos de usuarios: </p>
<ul>
	<li><p>An&oacute;nimo: Usuarios sin registrar, s&oacute;lo podr&aacute;n visualizar el contenido de la web.</p></li>
	<li><p>Registrado: Usuarios registrados, podr&aacute;n comentar y puntuar todas las entradas.</p></li>
	<li><p>Administradores: Podr&aacute;n crear y administrar todos los contenidos de la web.</p></li>
</ul>

	<p>
Estructura: 
En proceso.
	</p>
	
	<p>
Tecnolog&iacute;as: 
HTML, CSS, y J2EE. Esta informaci&oacute;n se completar&aacute; en un futuro.
	</p>
	
	<p>
Esta informaci&oacute;n es orientativa y esta sujeta a posibles cambios y a&ntilde;adidos.
	</p>
	
	<h2>Propuesta de trabajo</h2>
	
	<p>
Descripci&oacute;n: 
Realizar un peque&ntilde;o tutorial sobre HTML5. Se comparar&aacute; HTML5 con HTML, indicando las similitudes y las diferencias entre ambos. 
Se complementar&aacute; la informaci&oacute;n con ejemplos de c&oacute;digo para que resulte m&aacute;s facil aprender lo b&aacute;sico sobre HTML5.
	</p>
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