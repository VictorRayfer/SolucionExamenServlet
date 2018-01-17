<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Videogame</title>
</head>
<body>
	<form action="videogame" method="post">
		<span>Title:</span> 
		<input type="text" name="Title"/> <br/>
		<span>Pegi:</span> 
		<input type="text" name="Pegi"/><br/>
		<span>ReleaseDate:</span> 
		<input type="date" name="ReleaseDate"/><br/>
		<input type="submit"/>
	</form>
</body>
</html>