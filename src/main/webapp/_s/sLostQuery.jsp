<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>search</title>
</head>
<body>
<h2>sLostQuery</h2><br>
topSelect=${topSelect}<br>
bottomSelect=${bottomSelect}<br>
<table border="1">
		<tr>
			<th>尋覓編號</th>
			<th>文章編號</th>
			<th>尋找種類</th>
			<th>聯絡人</th>
			<th>電話</th>
			<th>時間</th>
			<th>地點</th>
			<th>敘述</th>
			<th>經度</th>
			<th>緯度</th>
			<th>寵物種類</th>
			<th>圖片</th>
			<th>明細</th>
		</tr>
		<c:forEach var="temp" items="${selectSearchAllType}">
			<tr>
				<td>${temp.s_id}</td>
				<td>${temp.a_id}</td>
				<td>${temp.s_type}</td>
				<td>${temp.s_name}</td>
				<td>${temp.s_conn}</td>
				<td>${temp.s_time}</td>
				<td>${temp.s_location}</td>
				<td>${temp.s_desc}</td>
				<td>${temp.s_lat}</td>
				<td>${temp.s_lng}</td>
				<td>${temp.s_pet_type}</td>
				<td><img src="<c:url value='/_a/WriteFileServlet?a_id=${temp.a_id}' />"></td>
				<td><a href="SQueryServlet?&a_id=${temp.a_id}">明細</a></td>
			</tr>
		</c:forEach>
	</table>


</body>
</html>