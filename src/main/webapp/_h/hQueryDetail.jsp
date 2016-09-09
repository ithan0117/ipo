<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登記/查詢˙成功</title>
</head>
<body>
	<h1>登記/查詢˙成功</h1>
		地區:${Bean.h_area}<br>
		寵物種類:${Bean.h_pet_type}<br>
		年紀:${Bean.h_age}<br>
		寵物毛色:${Bean.h_pet_color}<br>
		暱稱:${Bean.h_name}<br>
		發生時間:${Bean.h_time}<br>
		描述:${Bean.h_desc}<br>
		緯度:${Bean.h_lat}<br>
		經度:${Bean.h_lng}<br>
		<img src="<c:url value='/_a/WriteFileServlet?a_id=${Bean.a_id}' />"><br>
		帳號:${LoginOK.m_account}<br>
		暱稱:${LoginOK.m_nickname}<br>
		<a href="<c:url value='/homePage.jsp' />">HOMEPAGE</a><br>
</body>
</html>