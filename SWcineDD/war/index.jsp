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
Descripci&oacuten: 
Desarrollar una web sobre cine. La idea es que cualquier persona pueda encontrar informaci&oacuten de pel&iacuteculas, directores, actores, etc. 
Se podr&aacuten crear usuarios para que estos comenten en las entradas (pel&iacuteculas, directores, etc) y las puntuen. S&oacutelo se podr&aacute comentar o puntuar si 
eres un usuario registrado en la web y est&aacutes logeado en ese momento.
</p>
	
	<p>
En la entrada de un director se encontrar&aacute una descripci&oacuten y se enlazar&aacute una lista con todas sus pel&iacuteculas. En la de un actor se encontrar&aacute otra 
descripci&oacuten y otra lista con todas sus pel&iacuteculas. En la entrada de una pel&iacutecula se encontrar&aacute toda la informaci&oacuten relativa a la pel&iacutecula (director, 
reparto, a&ntildeo, premios, etc).
	</p>
	
	<p>
Parte p&uacuteblica y privada: 
Cualquier persona podr&aacute ver todos los contenidos de la p&aacutegina web. S&oacutelo usuarios registrados podr&aacuten comentar y puntuar las entradas de la web. 
Los &uacutenicos que puede editar los contenidos de las entradas ser&aacuten los administradores de la web.
	</p>
	
<p>Tipos de usuarios: </p>
<ul>
	<li><p>An&oacutenimo: Usuarios sin registrar, s&oacutelo podr&aacuten visualizar el contenido de la web.</p></li>
	<li><p>Registrado: Usuarios registrados, podr&aacuten comentar y puntuar todas las entradas.</p></li>
	<li><p>Administradores: Podr&aacuten crear y administrar todos los contenidos de la web.</p></li>
</ul>

	<p>
Estructura: 
En proceso.
	</p>
	
	<p>
Tecnolog&iacuteas: 
HTML, CSS, y J2EE. Esta informaci&oacuten se completar&aacute en un futuro.
	</p>
	
	<p>
Esta informaci&oacuten es orientativa y esta sujeta a posibles cambios y a&ntildeadidos.
	</p>
	
	<h2>Propuesta de trabajo</h2>
	
	<p>
Descripci&oacuten: 
Realizar un peque&ntildeo tutorial sobre HTML5. Se comparar&aacute HTML5 con HTML, indicando las similitudes y las diferencias entre ambos. 
Se complementar&aacute la informaci&oacuten con ejemplos de c&oacutedigo para que resulte m&aacutes facil aprender lo b&aacutesico sobre HTML5.
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
}catch(Exception e){
	response.sendRedirect("../index.jsp");	
}
%>
</body>

</html>