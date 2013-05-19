<!DOCTYPE html>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../index.css">

<title>CINE</title>

</head>

<body>

<div class="cine_top_banner_wrapper">

	<div class="cine_top_banner_title_wrapper">
		
		<div class="cine_top_banner_title_content">
			<div class="cine_top_banner_title_content_title">
			<h1><a href="../index.html">SW Cine</a></h1>
			</div>
			<div class="cine_top_banner_title_content_search">
					<form action="#">
						<input type="text" name="stext" size="20" value=" ">
						<select name="stype">
							<option value="all">Todos</option>
							<option value="title">Título</option>
							<option value="director">Director</option>
							<option value="cast">Reparto</option>
						</select>
						<input type="submit" id="button-search" value="Buscar">
					</form>
			</div>
			<div class="cine_top_banner_title_content_login">
				<p><a href="../html/login.html">Entrar</a>/<a href="../html/register.html">Registrarse</a></p>
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
					<li><a href="../index.html">Inicio</a></li>
					<li class="cine_top_banner_menu_content_parent">
						<a href="#">Usuarios</a>
						<ul>
							<li><a href="../html/login.html">Entrar</a></li>
							<li><a href="../html/register.html">Registarse</a></li>
						</ul>
					</li>
					<li class="cine_top_banner_menu_content_parent">
						<a href="#">Seciones</a>
						<ul>
							<li><a href="../html/movielist.html">Películas</a></li>
							<li><a href="../html/directorlist.html">Directores</a></li>
							<li><a href="../html/actorlist.html">Actores</a></li>
						</ul>
					</li>
					<li class="cine_top_banner_menu_content_parent">
						<a href="#">Añadir</a>
						<ul>
							<li><a href="../html/addmovie.html">Película</a></li>
							<li><a href="../html/adddirector.html">Director</a></li>
							<li><a href="../html/addactor.html">Actor</a></li>
						</ul>
					</li>
				</ul>
			</nav>
			
		</div>
	</div>

</div>

<!-- ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo -->
<!-- ooooooooooooooooooooooooooooooooooooooooo FIN MENU BANNER ooooooooooooooooooooooooooooooooooooooooo -->
<!-- ooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo -->

<div class="cine_content_wrapper">

	<div class="cine_left_menu">
		<div class="cine_left_menu_box">
			<h1>Usuarios</h1>
			<p><a href="../html/login.html">Entrar</a></p>
			<p><a href="../html/register.html">Registrarse</a></p>
		</div>
		<div class="cine_left_menu_box">
			<h1>Secciones</h1>
			<p><a href="../html/movielist.html">Peliculas</a></p>
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
	
<!-- oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo -->
<!-- ooooooooooooooooooooooooooooooooooooooooo FIN MENU LATERAL ooooooooooooooooooooooooooooooooooooooooo -->
<!-- oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo -->

	<div class="cine_main_wrapper">
		<div class="cine_index">
			<h1>Propuestas Sistemas Web</h1>
			<h2>Propuesta de web</h2>
	
	<p>
Descripción: 
Desarrollar una web sobre cine. La idea es que cualquier persona pueda encontrar información de películas, directores, actores, etc. 
Se podrán crear usuarios para que estos comenten en las entradas (películas, directores, etc) y las puntuen. Sólo se podrá comentar o puntuar si 
eres un usuario registrado en la web y estás logeado en ese momento.
</p>
	
	<p>
En la entrada de un director se encontrará una descripción y se enlazará una lista con todas sus películas. En la de un actor se encontrará otra 
descripción y otra lista con todas sus películas. En la entrada de una película se encontrará toda la información relativa a la película (director, 
reparto, año, premios, etc).
	</p>
	
	<p>
Parte pública y privada: 
Cualquier persona podrá ver todos los contenidos de la página web. Sólo usuarios registrados podrán comentar y puntuar las entradas de la web. 
Los único que puede editar los contenidos de las entradas serán los administradores de la web.
	</p>
	
<p>Tipos de usuarios: </p>
<ul>
	<li><p>Anónimo: Usuarios sin registrar, sólo podrán visualizar el contenido de la web.</p></li>
	<li><p>Registrado: Usuarios registrados, podrán comentar y puntuar todas las entradas.</p></li>
	<li><p>Administradores: Podrán crear y administrar todos los contenidos de la web.</p></li>
</ul>

	<p>
Estructura: 
En proceso.
	</p>
	
	<p>
Tecnologías: 
HTML, CSS, y J2EE. Esta información se completará en un futuro.
	</p>
	
	<p>
Esta información es orientativa y esta sujeta a posibles cambios y añadidos.
	</p>
	
	<h2>Propuesta de trabajo</h2>
	
	<p>
Descripción: 
Realizar un pequeño tutorial sobre HTML5. Se comparará HTML5 con HTML, indicando las similitudes y las diferencias entre ambos. 
Se complementará la información con ejemplos de código para que resulte más facil aprender lo básico sobre HTML5.
	</p>
		</div>
	</div>
	<div class="cine_clear"></div>

</div>

<!-- oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo -->
<!-- ooooooooooooooooooooooooooooooooooooooooo FIN MAIN ooooooooooooooooooooooooooooooooooooooooo -->
<!-- oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo -->

<div class="cine_bottom_banner_wrapper">
	<div class="cine_bottom_banner_content">
		<div class="cine_bottom_banner_left">
			<p>
				<a href="http://validator.w3.org/check?uri=http%3A%2F%2Flvaleromsw.appspot.com%2Findex.html">Validador HTML5</a>
		    	<a href="http://jigsaw.w3.org/css-validator/check/referer">
			        <img style="border:0;width:88px;height:31px"
			            src="http://jigsaw.w3.org/css-validator/images/vcss"
			            alt="¡CSS Válido!" />
			    </a>
		    	<a href="http://jigsaw.w3.org/css-validator/check/referer">
				    <img style="border:0;width:88px;height:31px"
				        src="http://jigsaw.w3.org/css-validator/images/vcss-blue"
				        alt="¡CSS Válido!" />
				</a>
			</p>
		</div>
		
		<div class="cine_bottom_banner_center">
		
			<p>
				Copyright (C) 2013 Luis Valero Martín.
				<br />
				<a rel="license" href="http://www.gnu.org/licenses/gpl.html">
				<img src="../images/gplv3-88x31.png" alt="gplv3"></a>
				<br />El código esta bajo una <a rel="license" href="http://www.gnu.org/licenses/gpl.html"> licencia GPLV3</a>
			</p>
			
		</div>
		
		<div class="cine_bottom_banner_right">
			<p>
				<a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/deed.es_ES">
				<img alt="Licencia de Creative Commons" style="border-width:0" src="http://i.creativecommons.org/l/by-sa/3.0/88x31.png" /></a>
				<br />Esta obra está bajo una <a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/deed.es_ES">licencia de Creative Commons Reconocimiento-CompartirIgual 3.0 Unported</a>
			</p>
		</div>
	</div>
</div>

</body>

</html>