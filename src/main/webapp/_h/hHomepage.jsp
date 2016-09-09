<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改資料</title>
</head>
<body>
	<table border="1">
		<c:forEach var="temp" items="${homelessList}">
			<tr>
				<td>${temp.aBean.a_id}</td>
				<td>${temp.aBean.m_id}</td>
				<td>${temp.aBean.a_block}</td>
				<td>${temp.aBean.a_createTime}</td>
				<td>${temp.hBean.h_id}</td>
				<td>${temp.hBean.a_id}</td>
				<td>${temp.hBean.h_area}</td>
				<td>${temp.hBean.h_pet_type}</td>
				<td>${temp.hBean.h_age}</td>
				<td>${temp.hBean.h_pet_color}</td>
				<td>${temp.hBean.h_name}</td>
				<td>${temp.hBean.h_time}</td>
				<td>${temp.hBean.h_desc}</td>
				<td>${temp.hBean.h_lat}</td>
				<td>${temp.hBean.h_lng}</td>
				<td><img src="HHomeImageServlet?a_id=${temp.aBean.a_id}"></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>