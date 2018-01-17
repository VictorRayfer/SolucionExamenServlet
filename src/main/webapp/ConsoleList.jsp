<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.io.*,java.util.*,es.Victor.Model.Console"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Consoles List</title>
</head>
<body>
	<%
		List<Console> console = (List<Console>) request.getAttribute("listAllConsole");
		pageContext.setAttribute("console", console);
	%>

	<form action="dataConsole" method="post">

		<table border="1">
			<thead>
				<tr>
					<td>Name</td>
					<td>Company</td>
					<td><input type=""></td>
				</tr>
			</thead>
			<c:forEach items="${console}" var="console">
				<tr>
					<td><c:out value="${console.Name}" /></td>
					<td><c:out value="${console.CodCompany}" /></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="Load">
	</form>

</body>
</html>