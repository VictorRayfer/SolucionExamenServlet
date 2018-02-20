<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete confirmation</title>
</head>
<body>
	Are you sure to delete this item?

<c:choose>
	<c:when test="${Name != null}">
		<form action="deleteConsole" method="post">
			<input type="text" value="${Name}"> 
			<input type="submit" value="Yes">
		</form>
	</c:when>
	<c:otherwise>
      <form action="deleteVideogame" method="post">
		<input type="text" value="${Title}"> 
		<input type="submit"value="Yes">
	</form>
	</c:otherwise>
</c:choose>
</body>
</html>
