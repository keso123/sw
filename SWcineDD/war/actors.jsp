<!DOCTYPE html>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../css/index.css">

<title>CINE</title>

</head>

<body>
<%@ page import="com.lvaleromsw.swcine.dao.ActorDAO" %>
<%@ page import="com.lvaleromsw.swcine.persistence.Actor" %>
<%@ page import="java.util.List" %>
<% 
try{
	String letter = request.getParameter("letter");
	List<Actor> actor = ActorDAO.getInstance().getActors(letter);
	session.setAttribute("url","/actors.jsp?letter="+letter);
%>

<%@ include file="topbanner.jsp" %>

<div class="cine_content_wrapper">
	<%@ include file="leftmenu.jsp" %>
	
	<div class="cine_main_wrapper">
		<div class="cine_list_title">
		<h1>Lista de actores</h1>
		</div>
		<div class="cine_list_abc_wrapper">
			<div class="cine_list_abc">
			<p><a href="../actors.jsp?letter=*">*</a>
			   <a href="../actors.jsp?letter=0">0-9</a>
			   <a href="../actors.jsp?letter=a">A</a>
			   <a href="../actors.jsp?letter=b">B</a>
			   <a href="../actors.jsp?letter=c">C</a>
			   <a href="../actors.jsp?letter=d">D</a>
			   <a href="../actors.jsp?letter=e">E</a>
			   <a href="../actors.jsp?letter=f">F</a>
			   <a href="../actors.jsp?letter=g">G</a>
			   <a href="../actors.jsp?letter=h">H</a>
			   <a href="../actors.jsp?letter=i">I</a>
			   <a href="../ctors.jsp?letter=j">J</a>
			   <a href="../actors.jsp?letter=k">K</a>
			   <a href="../actors.jsp?letter=l">L</a>
			   <a href="../actors.jsp?letter=m">M</a>
			   <a href="../actors.jsp?letter=n">N</a>
			   <a href="../actors.jsp?letter=o">O</a>
			   <a href="../actors.jsp?letter=p">P</a>
			   <a href="../actors.jsp?letter=q">Q</a>
			   <a href="../actors.jsp?letter=r">R</a>
			   <a href="../actors.jsp?letter=s">S</a>
			   <a href="../actors.jsp?letter=t">T</a>
			   <a href="../actors.jsp?letter=u">U</a>
			   <a href="../actors.jsp?letter=v">V</a>
			   <a href="../actors.jsp?letter=w">W</a>
			   <a href="../actors.jsp?letter=x">X</a>
			   <a href="../actors.jsp?letter=y">Y</a>
			   <a href="../actors.jsp?letter=z">Z</a></p>
			</div>
		</div>
		<div class="cine_list_pags">
			<p>
			
				<%
					String prev = "";
					String next = "";
					if(letter.equals("a")){
						prev = "0"; next = "b";
					}else if(letter.equals("z")){
						prev = "y"; next = "z";
					}else if(letter.equals("0")){
						prev = "*"; next = "a";
					}else if(letter.equals("*")){
						prev = "*"; next = "0";
					}else{
						int value = letter.charAt(0);
						prev = String.valueOf((char) (value - 1));
						next = String.valueOf((char) (value + 1));
					}
				%>
			
				<a href="../actors.jsp?letter=*">Inicio</a>
				<a href="../actors.jsp?letter=<%= prev %>">Anterior</a>
				<a href="../actors.jsp?letter=<%= next %>">Siguiente</a>
				<a href="../actors.jsp?letter=z">Fin</a>
			</p>
		</div>
		<div class="cine_list_content">
			<%
				if(actor != null)
				for(int i = 0; i < actor.size(); i++) { %>
			<div class="cine_list_content_box">
			
				<div class="cine_list_content_box_pic">
					<img alt="" src="showimageservlet?actor=<%= actor.get(i).getKey().getId() %>" width="50" height="75">
				</div>
				<div class="cine_list_content_box_text">
					<h1><a href="../actor.jsp?actor=<%out.println(actor.get(i).getKey().getId());%>"><%out.println(actor.get(i).getRealName()); %></a></h1>
					<h2><%=actor.get(i).getOcupation() %></h2>
					<p><%=actor.get(i).getAwards() %></p>
				</div>
				<div class="cine_clear"></div>
			</div>
			<% }else{ %>
			<div class="cine_list_content_box">
				<div class="cine_list_content_box_pic">
					<img alt="" src="../images/Delete.png" width="50" height="75">
				</div>
				<div class="cine_list_content_box_text">
					<h1>NO HAY ACTORES</h1>
				</div>
				<div class="cine_clear"></div>
			</div>
			<% } %>
		</div>
		<div class="cine_list_pags">
			<p>
				<a href="../actors.jsp?letter=*">Inicio</a>
				<a href="../actors.jsp?letter=<%= prev %>">Anterior</a>
				<a href="../actors.jsp?letter=<%= next %>">Siguiente</a>
				<a href="../actors.jsp?letter=z">Fin</a>
			</p>
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