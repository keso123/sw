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
	String dir  = request.getParameter("actor");
	String mode = request.getParameter("c");
	String servlet = "actoraddservlet";
	
	if(dir != null) {
		servlet = "actormodservlet?actor="+dir;
	}else if(mode != null){ 
		servlet = "actoraddservlet";
	}
	if(mode == null){
		mode="edit";
	}
	
	//System.out.println(servlet);
	
	//System.out.println(mode);
	//System.out.println(mov);
	//System.out.println(servlet);
	
	String type = "";
	String onclick = "";
	if(dir != null){
		type = "submit";
		onclick = "";
	}else {
		type = "button";
		onclick = "checkActor()";
	}
%>

<% if(session.getAttribute("admin") == null) response.sendRedirect("../index.jsp");%>

<%@ include file="topbanner.jsp" %>

<div class="cine_content_wrapper">
	<%@ include file="leftmenu.jsp" %>
	
	<div class="cine_main_wrapper">
		<div class="cine_edit_title">
			<% if(!mode.equals("add")) { %>
				<h1>Editar</h1>
			<% }else{ %>
				<h1>A&ntildeadir</h1>
			<% } %>
		</div>
		<div class="cine_edit_frame">
			<form name="cheack_actor" id="check_actor"
			action="<%=servlet %>" method="post" >
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
						<h1>Nombre:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="name" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Nombre real:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="realName" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Nacimiento:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="birth" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Fallecimiento:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="death" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Edad:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="age" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Ocupaci&oacuten:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="ocupation" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Debut:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="debut" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Premios:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="awards" size="60" value="">
					</div>
				</div>
				<div class="cine_clear"></div>
				
				<div class="cine_edit_frame_row">
					<div class="cine_edit_frame_colum_left">
						<h1>Filmograf&iacutea:</h1>
					</div>
					<div class="cine_edit_frame_colum_right">
						<input type="text" name="filmography" size="60" value="">
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
					<input type=<%=type %> id="button-edit" <% if(mode.equals("add"))out.println("onclick="+onclick); %> value="Aceptar">
				</div>
			</form>
		</div>
	</div>
	
	<div class="cine_clear"></div>
</div>

<%@ include file="bottombanner.jsp" %>
<%
}catch(java.lang.IllegalArgumentException e){
	response.sendRedirect("../index.jsp");
}catch(Exception e){
	response.sendRedirect("../index.jsp");
}
%>
</body>
</html>