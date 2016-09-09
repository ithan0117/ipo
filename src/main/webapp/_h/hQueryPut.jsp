<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>輸入A_ID</title>
</head>
<body>
	<h1>輸入A_ID</h1>
		<form action="../HQueServlet" method="post">
			a_id:<input type="text" name="a_id" /><br>
			<input type="submit" value="送出"/>
			<a href="<c:url value='/homePage.jsp' />">HOMEPAGE</a><br>
		</form>
</body>
</html>