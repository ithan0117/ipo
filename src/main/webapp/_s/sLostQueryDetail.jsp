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
123顯示會員名稱???
<table border="1">
		<tr>
			<th>會員編號</th>
			<th>文章編號</th>
			<th>區塊</th>
			<th>標題</th>
			<th>建立時間</th>
			<th>影像</th>
			<th>細項編號</th>
			<th>種類</th>
			<th>聯絡人</th>
			<th>電話</th>
			<th>遺失時間</th>
			<th>地點</th>
			<th>敘述</th>
			<th>經度</th>
			<th>緯度</th>
			<th>寵物種類</th>
		</tr>
			<tr>
				<td>${a_head.m_id}</td>
				<th>${a_head.a_id}</th>
				<td>${a_head.a_block}</td>
				<td>${a_head.a_title}</td>
				<td>${a_head.a_createTime}</td>
				<td><img src="<c:url value='/_a/WriteFileServlet?a_id=${a_head.a_id}' />"></td>
				<th>${s_detail.s_id}</th>
				<th>${s_detail.s_type}</th>
				<th>${s_detail.s_name}</th>
				<th>${s_detail.s_conn}</th>
				<th>${s_detail.s_time}</th>
				<th>${s_detail.s_location}</th>
				<th>${s_detail.s_desc}</th>
				<th>${s_detail.s_lat}</th>
				<th>${s_detail.s_lng}</th>
				<th>${s_detail.s_pet_type}</th>
			</tr>
	</table>
</body>
</html>