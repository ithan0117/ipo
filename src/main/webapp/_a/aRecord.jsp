<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Edit</h2><br>
topSelect=${topSelect}<br>
bottomSelect=${bottomSelect}<br>

	<table border="1">
		<tr>
			<th>會員編號</th>
			<th>文章編號</th>
			<th>區塊</th>
			<th>標題</th>
			<th>建立時間</th>
			<th>影像</th>
			<th>編輯</th>
		</tr>
		<c:forEach var="temp" items="${Articles}">
			<tr>
				<td>${temp.m_id}</td>
				<th>${temp.a_id}</th>
				<td>${temp.a_block}</td>
				<td>${temp.a_title}</td>
				<td>${temp.a_createTime}</td>
				<td><img src="<c:url value='/_a/WriteFileServlet?a_id=${temp.a_id}' />"></td>
				<th><a href="SEditServlet?m_id=${temp.m_id}&a_id=${temp.a_id}">編輯</a></th>
			</tr>
		</c:forEach>
	</table>
</body>
</html>