<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.util.*,es.Victor.Model.Videogame"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Videogame List</title>
</head>
<body>
	<%
		List<Videogame> videogame = (List<Videogame>) request.getAttribute("listAllVideogame");
		pageContext.setAttribute("videogame", videogame);
	%>

	<form action="dataGames" method="post">
		<table border="1">
			<thead>
				<tr>
					<td>Title</td>
					<td>Pegi</td>
					<td>ReleaseDate</td>
				</tr>
			</thead>
			<c:forEach items="${videogame}" var="videogame">
				<tr>
					<td><c:out value="${videogame.Title}" /></td>
					<td><c:out value="${videogame.Pegi}" /></td>
					<td><c:out value="${videogame.ReleaseDate}" /></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Load">
	</form>

</body>
</html>