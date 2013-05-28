<!DOCTYPE html>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../css/index.css">

<script type="text/javascript" src="../js/jquery-2.0.1.min.js"></script>
<script type="text/javascript" src="/js/checkmovie.js"></script>

<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.9.1.min.js"></script> -->

<title>CINE</title>

</head>

<body>

<% 
try{
	
	//Object user = session.getAttribute("username");
	//Object admin = session.getAttribute("admin");
	String mov  = request.getParameter("movie");
	String mode = request.getParameter("c");
	String servlet = "movieaddservlet";
	
	if(mov != null) {
		servlet = "moviemodservlet?movie="+mov;
	}else if(mode != null){ 
		servlet = "movieaddservlet";
	}
	if(mode == null){
		mode="edit";
	}
	
	//System.out.println(mode);
	//System.out.println(mov);
	//System.out.println(servlet);
	
	String type = "";
	String onclick = "";
	if(mov != null){
		type = "submit";
		onclick = "";
	}else {
		type = "button";//"button";
		onclick = "checkMovie()";
	}
%>

<% if(session.getAttribute("admin") == null) response.sendRedirect("../index.jsp");%>

<%@ include file="topbanner.jsp" %>

<div class="cine_content_wrapper">
	<%@ include file="leftmenu.jsp" %>
	
	<div class="cine_main_wrapper">
		<div class="cine_edit_title">
			<% if(!mode.equals("add")) {%><h1>Editar</h1>
			<% }else{ %><h1>A&ntilde;adir</h1>
			<% } %>
		</div>
		<div class="cine_edit_frame">
		
			<form name="check_movie" id="check_movie"
			action="<%out.println(servlet);%>" 
			method="post" enctype="mulipart/form-data">
			
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>T&iacute;tulo:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input id="title" type="text" name="title" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>T&iacute;tulo pel&iacute;cula:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input id="movieTitle" type="text" name="movieTitle" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>T&iacute;tulo original:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input id="realMovieTitle" type="text" name="realMovieTitle" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>A&ntildeo:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input id="date" type="text" name="date" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Pa&iacute;s:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input id="country" type="text" name="country" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Director:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input id="director" type="text" name="director" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Reparto:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input id="casting" type="text" name="casting" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>G&eacute;nero:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input id="genre" type="text" name="genre" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Sinopsis:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input id="synopsis" type="text" name="synopsis" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Imagen:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input id="imagefile" type="text" name="imagefile" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<input type=<%=type %> id="button-edit"<% if(mode.equals("add"))out.println("onclick="+onclick); %> value="Aceptar">
				</div>
			</form>
		</div>
	</div>
	
	<div class="cine_clear"></div>
</div>

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