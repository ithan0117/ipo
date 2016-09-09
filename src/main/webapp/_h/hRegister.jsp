<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>浪浪登記</title>
</head>
<body>
	<h2>浪浪登記</h2>
	<form action="HRegServlet" method="post" ENCTYPE="multipart/form-data">
		地區:<input type="text" name="h_area" value="${Bean.h_area}"/>${errorMsg.errorH_area}<br>
		寵物種類:<input type="text" name="h_pet_type" value="${Bean.h_pet_type}"/>${errorMsg.errorH_pet_type}<br>
		年紀:<input type="text" name="h_age" value="${Bean.h_age}"/>${errorMsg.errorH_age}<br>
		寵物毛色:<input type="text" name="h_pet_color" value="${Bean.h_pet_color}"/>${errorMsg.errorH_pet_color}<br>
		暱稱:<input type="text" name="h_name" value="${Bean.h_name}"/>${errorMsg.errorH_name}<br>
		發生時間:<input type="datetime-local" name="h_time" value="${Bean.h_time}"/>${errorMsg.errorH_time}<br>
		描述:<input type="text" name="h_desc" value="${Bean.h_desc}"/>${errorMsg.errorH_desc}<br>
		緯度:<input type="text" name="h_lat" value="${Bean.h_lat}"/>${errorMsg.errorH_lat}<br>
		經度:<input type="text" name="h_lng" value="${Bean.h_lng}"/>${errorMsg.errorH_lng}<br>
		圖片:<input type="file" name="a_image" multiple="multiple"/><br>
		<input type="submit" value="送出"/>
		<a href="<c:url value='/homePage.jsp' />">HOMEPAGE</a><br>
	</form>
</body>
</html>