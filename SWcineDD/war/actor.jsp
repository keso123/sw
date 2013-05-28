<!DOCTYPE html>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../css/index.css">

<title>CINE</title>

</head>

<body>

<%@ page import="com.lvaleromsw.swcine.persistence.Actor" %>
<%@ page import="com.lvaleromsw.swcine.dao.ActorDAO"%>
<%@ page import="com.google.appengine.api.datastore.Key"%>
<%@ page import="java.util.Vector" %>
<%@ page import="java.io.OutputStream" %>

<%
try{
	String a = request.getParameter("actor");
	if(a == null) response.sendRedirect("/index.jsp");
	Actor actor = ActorDAO.getInstance().getActor(Long.valueOf(a));
	if(actor == null) response.sendRedirect("../index.jsp");
	session.setAttribute("url","/actor.jsp?actor="+a);
%>

<%@ include file="topbanner.jsp" %>

<div class="cine_content_wrapper">
	<%@ include file="leftmenu.jsp" %>
	
	<div class="cine_main_wrapper">
		<div class="cine_moviecard_title">
			<h1><%=actor.getTitle() %></h1>
			<% if(session.getAttribute("admin") != null) { %>
			
			<form action="#"><input type="button" onClick="openEditActor()" id="button-edit" value="Editar"></form>
			<script>
				function openEditActor() {
					location.href="../newactor.jsp?actor=<%=actor.getKey().getId()%>";
				}
			</script>
			<form action="#"><input type="button" onClick="openDelActor()" id="button-del" value="Eliminar"></form>
			<script>
				function openDelActor() {
					location.href="../actordelservlet?actor=<%=actor.getKey().getId()%>";
				}
			</script>
			
			<% } %>
		</div>
		
		<div class="cine_moviecard_content">
			<div class="cine_moviecard_content_info">
				<div class="cine_moviecard_content_info_text">
					<dl>
						<dt>Nombre</dt>
						<dd><%=actor.getName() %></dd>
						<dt>Nombre real</dt>
						<dd><%=actor.getRealName() %></dd>
						<dt>Nacimiento</dt>
						<dd><%=actor.getBirth() %></dd>
						<dt>Fallecimiento</dt>
						<dd><%=actor.getDeath() %></dd>
						<dt>Edad</dt>
						<dd><%=actor.getAge() %></dd>
						<dt>Ocupaci&oacuten</dt>
						<dd><%=actor.getOcupation() %></dd>
						<dt>Debut</dt>
						<dd><%=actor.getDebut() %></dd>
						<dt>Premios</dt>
						<dd><%=actor.getAwards() %></dd>
						<dt>Filmograf&iacutea</dt>
						<dd><%=actor.getFilmography() %></dd>
						<dt>Comentarios</dt>
						<dd>
							<div class="cine_moviecard_comments">
							
								<% 
									Vector<String> comments = actor.getComments();
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
									<form action="actorcommentaddservlet?actor=<%= actor.getKey().getId()%>"
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
					<img alt="" src="showimageservlet?actor=<%=a %>" width="100" height="150">
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
}catch(java.lang.IllegalArgumentException e){
	response.sendRedirect("index.jsp");
}catch(Exception e){
	response.sendRedirect("index.jsp");
}
%>

</body>
</html>