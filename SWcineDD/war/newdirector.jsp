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
		type = "button";
		onclick = "checkMovie()";
	}
%>

<% if(session.getAttribute("admin") == null) response.sendRedirect("../index.jsp");%>

<%@ include file="topbanner.jsp" %>

<div class="cine_content_wrapper">
	<%@ include file="leftmenu.jsp" %>
	
	<div class="cine_main_wrapper">
		<div class="cine_edit_title">
			<h1>Editar</h1>
		</div>
		<div class="cine_edit_frame">
			<form action="#">
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Título:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="stext" size="60" value=" ">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Nombre:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="stext" size="60" value=" ">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Nombre real:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="stext" size="60" value=" ">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Nacimiento:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="stext" size="60" value=" ">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Fallecimiento:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="stext" size="60" value=" ">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Edad:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="stext" size="60" value=" ">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Ocupación:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="stext" size="60" value=" ">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Debut:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="stext" size="60" value=" ">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Premios:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="stext" size="60" value=" ">
					</div>
				</div>
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Filmografía:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="stext" size="60" value=" ">
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