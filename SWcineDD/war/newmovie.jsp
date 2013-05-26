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
	String mov  = request.getParameter("movie");
	String mode = request.getParameter("c");
	String servlet = "movieaddservlet";
	if(mov != null) servlet = "moviemodservlet?movie="+mov;
	else if(mode != null) servlet = "movieaddservlet";
	if(mode == null) mode="edit";
	System.out.println(mode);
	System.out.println(mov);
	System.out.println(servlet);
%>

<% if(session.getAttribute("admin") == null) response.sendRedirect("../index.jsp");%>

<%@ include file="topbanner.jsp" %>

<div class="cine_content_wrapper">
	<%@ include file="leftmenu.jsp" %>
	
	<div class="cine_main_wrapper">
		<div class="cine_edit_title">
			<% if(!mode.equals("add")) {%><h1>Editar</h1>
			<% }else{ %><h1>A&ntildeadir</h1>
			<% } %>
		</div>
		<div class="cine_edit_frame">
			<form action="<%out.println(servlet);%>" 
			method="post" enctype="mulipart/form-data">
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>T&iacutetulo:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="title" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>T&iacutetulo pel&iacutecula:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="movieTitle" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>T&iacutetulo original:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="realMovieTitle" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>A&ntildeo:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="date" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Pa&iacutes:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="country" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Director:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="director" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Reparto:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="casting" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>G&eacutenero:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="genre" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Sinopsis:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="synopsis" size="60" value="">
					</div>
				</div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Imagen:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<!-- <input type="file" name="imagefile"> -->
						<input type="text" name="imagefile" size="60" value="">
					</div>
				</div>
				
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<input type="submit" id="button-edit" value="Editar">
				</div>
			</form>
		</div>
	</div>
	
	<div class="cine_clear"></div>
</div>

<%@ include file="bottombanner.jsp" %>

</body>
</html>