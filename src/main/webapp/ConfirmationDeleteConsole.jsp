<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete consoles.</title>
</head>
<body>
¿Are you sure?

		<form action="deleteConsole" method="post">
			<input type="text" value="${name}">
			<input type="submit" value="Yes">
		</form>
</body>
</html>