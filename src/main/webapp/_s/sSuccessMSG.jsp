<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value='/css/successMSG.css' />">
        <script src="<c:url value='/js/jquery-1.12.4.min.js' />"></script>
		<title>成功</title>
	</head>
	<script>
		var speed = 3000;
		setTimeout("goto()", speed);

         function goto() {
        		 location = "<c:url value='sHomeSearch' />";
		}
	</script>
	<body style=background-color:#808080;>
        <!-- <div style=border:solid 1px;> -->
        <div id="box">
            <div class="innerDiv">
                <img src="<c:url value='/images/checked.png' />" id="imgTick">
			</div>	
			<div id="textBox" class="innerDiv">
				<h1>登記成功!!</h1>
								
				<h2>即將返回首頁</h2>
            </div>  
        </div>
        <!-- </div> -->
				
	</body>
</html>