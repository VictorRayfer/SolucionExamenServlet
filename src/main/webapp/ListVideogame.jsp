<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Videogames.</title>
</head>
<body>

	<form action="listVideogame" method="post">
		<input type="submit" value="see list">
	</form>
	
	<form action="orderByTitle" method="post">
		<input type="submit" value="order list by title" >
	</form>
	
	<form action="orderByReleaseDate" method="post">
		<input type="submit" value="order list by release date" >
	</form>
	
	<table border="1">
		<thead>
			<tr>
				<td>Title</td>
				<td>Pegi</td>
				<td>Release Date</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="videogame" items="${listAllVideogame}">
				<tr>
					<td><c:out value="${videogame.title}"/> </td>
					<td><c:out value="${videogame.pegi}"/> </td>
					<td><c:out value="${videogame.releaseDate}"/> </td>
					<td><a href="/deleteVG?title=${videogame.title}">Delete</a></td>
		    	</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>