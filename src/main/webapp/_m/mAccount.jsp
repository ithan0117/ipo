<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="<c:url value='/css/account.css' />">
        <script src="<c:url value='/js/jquery-1.12.4.min.js' />"></script>
        <!-- <script src="js/account.js"></script> -->
		<script>
		 $(document).ready(function(){
			$(".button").hover(function(){
			$(this).css("background-color","#a1f000");
			},function(){		
			$(this).css("background-color","#99ff00")
			});
		});
	/*////↑↑Hover↑↑///*/
		</script>
		<title>登入會員</title>
</head>
<body style=background-color:#808080;>
        <!-- <div style=border:solid 1px;> -->
        <div id="box">
			<center>
				<h1>Account</h1>
			</center>		
				<hr>
                  <!--   <span class="button" ><a href="mEdit.html">Account Setting</a></span>
                    <span class="button" ><a href="">Record</a></span> -->
					<!-- <div id="boxInside" > -->      
                      <!--   <button id="accountSetting" value="Account Setting" href=""></button>
                        <button id="record" value="Record"></button> -->
                        
                        <input class="button" type="button" value="Account Setting" onclick="location.href='mEdit.jsp'" ><br>
                        <input class="button" type="button" value="Record" onclick="location.href=''" ><br>
					<!-- </div> -->
        </div>
        <!-- </div> -->
				
	</body>
</html>