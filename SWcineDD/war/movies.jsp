<!DOCTYPE html>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="../css/index.css">

<title>CINE</title>

</head>

<body>
<%@ page import="com.lvaleromsw.swcine.dao.MovieDAO" %>
<%@ page import="com.lvaleromsw.swcine.persistence.Movie" %>
<%@ page import="java.util.List" %>
<% 
try{
	String letter = request.getParameter("letter");
	List<Movie> movies = MovieDAO.getInstance().getMovies(letter);
	session.setAttribute("url","/movies.jsp?letter="+letter);
%>

<%@ include file="topbanner.jsp" %>

<div class="cine_content_wrapper">
	<%@ include file="leftmenu.jsp" %>
	
	<div class="cine_main_wrapper">
	
	<div class="cine_list_title">
		<h1>Lista de pel&iacute;culas</h1>
		</div>
		<div class="cine_list_abc_wrapper">
			<div class="cine_list_abc">
			<p><a href="../movies.jsp?letter=*">*</a>
			   <a href="../movies.jsp?letter=0">0-9</a>
			   <a href="../movies.jsp?letter=a">A</a>
			   <a href="../movies.jsp?letter=b">B</a>
			   <a href="../movies.jsp?letter=c">C</a>
			   <a href="../movies.jsp?letter=d">D</a>
			   <a href="../movies.jsp?letter=e">E</a>
			   <a href="../movies.jsp?letter=f">F</a>
			   <a href="../movies.jsp?letter=g">G</a>
			   <a href="../movies.jsp?letter=h">H</a>
			   <a href="../movies.jsp?letter=i">I</a>
			   <a href="../movies.jsp?letter=j">J</a>
			   <a href="../movies.jsp?letter=k">K</a>
			   <a href="../movies.jsp?letter=l">L</a>
			   <a href="../movies.jsp?letter=m">M</a>
			   <a href="../movies.jsp?letter=n">N</a>
			   <a href="../movies.jsp?letter=o">O</a>
			   <a href="../movies.jsp?letter=p">P</a>
			   <a href="../movies.jsp?letter=q">Q</a>
			   <a href="../movies.jsp?letter=r">R</a>
			   <a href="../movies.jsp?letter=s">S</a>
			   <a href="../movies.jsp?letter=t">T</a>
			   <a href="../movies.jsp?letter=u">U</a>
			   <a href="../movies.jsp?letter=v">V</a>
			   <a href="../movies.jsp?letter=w">W</a>
			   <a href="../movies.jsp?letter=x">X</a>
			   <a href="../movies.jsp?letter=y">Y</a>
			   <a href="../movies.jsp?letter=z">Z</a></p>
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
			
				<a href="../movies.jsp?letter=*">Inicio</a>
				<a href="../movies.jsp?letter=<%= prev %>">Anterior</a>
				<a href="../movies.jsp?letter=<%= next %>">Siguiente</a>
				<a href="../movies.jsp?letter=z">Fin</a>
			</p>
		</div>
		<div class="cine_list_content">
			<%
				//List<Movie> list = MovieDAO.getInstance().getMovies();
				if(movies != null)
				for(int i = 0; i < movies.size(); i++) { %>
			<div class="cine_list_content_box">
				<div class="cine_list_content_box_pic">
					<img alt="" src="showimageservlet?movie=<%= movies.get(i).getKey().getId() %>" width="50" height="75">
				</div>
				<div class="cine_list_content_box_text">
					<h1><a href="../movie.jsp?movie=<%out.println(movies.get(i).getKey().getId());%>"><% out.println(movies.get(i).getRealMovieTitle()); %></a></h1>
					<h2><% out.println(movies.get(i).getDirector()); %></h2>
					<p><% out.println(movies.get(i).getCasting()); %></p>
				</div>
				<div class="cine_clear"></div>
			</div>
			<% }else{ %>
			<div class="cine_list_content_box">
				<div class="cine_list_content_box_pic">
					<img alt="" src="../images/Delete.png" width="50" height="75">
				</div>
				<div class="cine_list_content_box_text">
					<h1>NO HAY PELICULAS</h1>
				</div>
				<div class="cine_clear"></div>
			</div>
			<% } %>
		</div>
		<div class="cine_list_pags">
			<p>
				<a href="../movies.jsp?letter=*">Inicio</a>
				<a href="../movies.jsp?letter=<%= prev %>">Anterior</a>
				<a href="../movies.jsp?letter=<%= next %>">Siguiente</a>
				<a href="../movies.jsp?letter=z">Fin</a>
			</p>
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