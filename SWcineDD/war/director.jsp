<!DOCTYPE html>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../css/index.css">

<title>CINE</title>

</head>

<body>

<%@ page import="com.lvaleromsw.swcine.persistence.Director" %>
<%@ page import="com.lvaleromsw.swcine.dao.DirectorDAO"%>
<%@ page import="com.google.appengine.api.datastore.Key"%>
<%@ page import="java.util.Vector" %>
<%@ page import="java.io.OutputStream" %>

<%
try{
	String d = request.getParameter("director");
	if(d == null) response.sendRedirect("/index.jsp");
	Director dir = DirectorDAO.getInstance().getDirector(Long.valueOf(d));
	if(dir == null) response.sendRedirect("../index.jsp");
	session.setAttribute("url","/director.jsp?director="+d);
%>

<%@ include file="topbanner.jsp" %>

<div class="cine_content_wrapper">
	<%@ include file="leftmenu.jsp" %>
	
	<div class="cine_main_wrapper">
		<div class="cine_moviecard_title">
			<h1><%=dir.getTitle() %></h1>
			<% if(session.getAttribute("admin") != null) { %>
			
			<form action="#"><input type="button" onClick="openEditDirector()" id="button-edit" value="Editar"></form>
			<script>
				function openEditDirector() {
					location.href="../newdirector.jsp?director=<%=dir.getKey().getId()%>";
				}
			</script>
			<form action="#"><input type="button" onClick="openDelDirector()" id="button-del" value="Eliminar"></form>
			<script>
				function openDelDirector() {
					location.href="../directordelservlet?director=<%=dir.getKey().getId()%>";
				}
			</script>
			
			<% } %>
		</div>
		
		<div class="cine_moviecard_content">
			<div class="cine_moviecard_content_info">
				<div class="cine_moviecard_content_info_text">
					<dl>
						<dt>Nombre</dt>
						<dd><%=dir.getName() %></dd>
						<dt>Nombre real</dt>
						<dd><%=dir.getRealName() %></dd>
						<dt>Nacimiento</dt>
						<dd><%=dir.getBirth() %></dd>
						<dt>Fallecimiento</dt>
						<dd><%=dir.getDeath() %></dd>
						<dt>Edad</dt>
						<dd><%=dir.getAge() %></dd>
						<dt>Ocupaci&oacuten</dt>
						<dd><%=dir.getOcupation() %></dd>
						<dt>Debut</dt>
						<dd><%=dir.getDebut() %></dd>
						<dt>Premios</dt>
						<dd><%=dir.getAwards() %></dd>
						<dt>Filmograf&iacutea</dt>
						<dd><%=dir.getFilmography() %></dd>
						<dt>Comentarios</dt>
						<dd>
							<div class="cine_moviecard_comments">
							
								<% 
									Vector<String> comments = dir.getComments();
									for(int i = 0; i < comments.size(); i++) {
								%>
							
								<div class="cine_moviecard_comment">
									<div class="cine_moviecard_comment_text">
										<p>
										<%=comments.get(i) %>
										</p>
									</div>
									<div class="cine_moviecard_comment_author">
										<p>
										<% i = i + 1; out.println(comments.get(i)); %>
										</p>
									</div>
								</div>
								
								<% } %>
								<% if(session.getAttribute("username") != null){ %>
								
								<div class="cine_moviecard_comment_frame">
									<form action="directorcommentaddservlet?director=<%= dir.getKey().getId()%>"
									method="post">
										<input type="text" name="comment" size="63" value="">
										<input type="submit" id="button-coment" value="Comentar">
									</form>
								</div>
								
								<% } %>
								
							</div>
						</dd>
					</dl>
				</div>
				<div class="cine_moviecard_content_info_pic">
					<img alt="" src="showimageservlet?director=<%=d %>" width="100" height="150">
				</div>
				<div class="cine_clear"></div>
			</div>
			<div class="cine_moviecard_content_synopsis">
			</div>
		</div>
		
	</div>
	<div class="cine_clear"></div>
</div>

<%@ include file="bottombanner.jsp" %>
<%
}catch(Exception e){
	response.sendRedirect("../index.jsp");	
}
%>
</body>
</html>