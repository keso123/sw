<!DOCTYPE html>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../css/index.css">

<title>CINE</title>

</head>

<body>
<%@ page import="com.lvaleromsw.swcine.dao.DirectorDAO" %>
<%@ page import="com.lvaleromsw.swcine.persistence.Director" %>
<%@ page import="java.util.List" %>
<% 
try{
	String letter = request.getParameter("letter");
	List<Director> dir = DirectorDAO.getInstance().getDirectors(letter);
	session.setAttribute("url","/directors.jsp?letter="+letter);
%>

<%@ include file="topbanner.jsp" %>

<div class="cine_content_wrapper">
	<%@ include file="leftmenu.jsp" %>
	
	<div class="cine_main_wrapper">
		<div class="cine_list_title">
		<h1>Lista de directores</h1>
		</div>
		<div class="cine_list_abc_wrapper">
			<div class="cine_list_abc">
			<p><a href="../directors.jsp?letter=*">*</a>
			   <a href="../directors.jsp?letter=0">0-9</a>
			   <a href="../directors.jsp?letter=a">A</a>
			   <a href="../directors.jsp?letter=b">B</a>
			   <a href="../directors.jsp?letter=c">C</a>
			   <a href="../directors.jsp?letter=d">D</a>
			   <a href="../directors.jsp?letter=e">E</a>
			   <a href="../directors.jsp?letter=f">F</a>
			   <a href="../directors.jsp?letter=g">G</a>
			   <a href="../directors.jsp?letter=h">H</a>
			   <a href="../directors.jsp?letter=i">I</a>
			   <a href="../directors.jsp?letter=j">J</a>
			   <a href="../directors.jsp?letter=k">K</a>
			   <a href="../directors.jsp?letter=l">L</a>
			   <a href="../directors.jsp?letter=m">M</a>
			   <a href="../directors.jsp?letter=n">N</a>
			   <a href="../directors.jsp?letter=o">O</a>
			   <a href="../directors.jsp?letter=p">P</a>
			   <a href="../directors.jsp?letter=q">Q</a>
			   <a href="../directors.jsp?letter=r">R</a>
			   <a href="../directors.jsp?letter=s">S</a>
			   <a href="../directors.jsp?letter=t">T</a>
			   <a href="../directors.jsp?letter=u">U</a>
			   <a href="../directors.jsp?letter=v">V</a>
			   <a href="../directors.jsp?letter=w">W</a>
			   <a href="../directors.jsp?letter=x">X</a>
			   <a href="../directors.jsp?letter=y">Y</a>
			   <a href="../directors.jsp?letter=z">Z</a></p>
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
			
				<a href="../directors.jsp?letter=*">Inicio</a>
				<a href="../directors.jsp?letter=<%= prev %>">Anterior</a>
				<a href="../directors.jsp?letter=<%= next %>">Siguiente</a>
				<a href="../directors.jsp?letter=z">Fin</a>
			</p>
		</div>
		<div class="cine_list_content">
			<%
				if(dir != null)
				for(int i = 0; i < dir.size(); i++) { %>
			<div class="cine_list_content_box">
			
				<div class="cine_list_content_box_pic">
					<img alt="" src="showimageservlet?director=<%= dir.get(i).getKey().getId() %>" width="50" height="75">
				</div>
				<div class="cine_list_content_box_text">
					<h1><a href="../director.jsp?director=<%out.println(dir.get(i).getKey().getId());%>"><%out.println(dir.get(i).getRealName()); %></a></h1>
					<h2><%=dir.get(i).getOcupation() %></h2>
					<p><%=dir.get(i).getAwards() %></p>
				</div>
				<div class="cine_clear"></div>
			</div>
			<% }else{ %>
			<div class="cine_list_content_box">
				<div class="cine_list_content_box_pic">
					<img alt="" src="../images/Delete.png" width="50" height="75">
				</div>
				<div class="cine_list_content_box_text">
					<h1>NO HAY DIRECTORES</h1>
				</div>
				<div class="cine_clear"></div>
			</div>
			<% } %>
		</div>
		<div class="cine_list_pags">
			<p>
				<a href="../directors.jsp?letter=*">Inicio</a>
				<a href="../directors.jsp?letter=<%= prev %>">Anterior</a>
				<a href="../directors.jsp?letter=<%= next %>">Siguiente</a>
				<a href="../directors.jsp?letter=z">Fin</a>
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