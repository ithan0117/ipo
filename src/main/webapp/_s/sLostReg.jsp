<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>sLostReg</h2><br>
topSelect=${topSelect}<br>
bottomSelect=${bottomSelect}<br>


<form action="sRegServlet" enctype="multipart/form-data" method="post" >
	種類:
	狗<input id='s_pet_type' type="radio" name="s_pet_type" value="d" checked>
	貓<input id='s_pet_type' type="radio" name="s_pet_type" value="c">
	其他<input id='s_pet_type' type="radio" name="s_pet_type" value="o"><br>
	聯絡人:<input id='s_name' type="text" name="s_name" value="張君雅">${MsgMap.errorName}<br>
	電話:<input id='s_conn' type="text" name="s_conn" value="09123456789">${MsgMap.errorConnEmpty}<br>
	時間:<input id='s_time' type="datetime-local" name="s_time" value="1988-12-31">${MsgMap.errorTimeEmpty}<br>
	地點:<input id='s_location' type="text" name="s_location" value="台北">${MsgMap.errorLocation}<br>
	敘述:<input id='s_desc' type="text" name="s_desc" value="小黃">${MsgMap.errorDesc}<br>
	緯度:<input id='s_lat' type="text" name="s_lat" value="25.1249527"><br>
	經度:<input id='s_lng' type="text" name="s_lng" value="121.574654187"><br>
	圖片:<input id='s_img' type="file" name="s_img" value="">${MsgMap.errPicture}<br>
	<input type="submit" name="submit" id="submit" value="儲存"/>
    <input type="reset" name="cancel" id="cancel" value="重填">

</form>

</body>
</html>