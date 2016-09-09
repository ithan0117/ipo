<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="<c:url value='/css/login.css' />">
        <script src="<c:url value='/js/jquery-1.12.4.min.js' />"></script>
        <script type="text/javascript" src="<c:url value='/js/jquery.validate.min.js' />"></script>
        <script type="text/javascript" src="<c:url value='/js/additional-methods.min.js' />"></script>
        <script type="text/javascript" src="<c:url value='/js/messages_zh_TW.js' />"></script>
        <script src="<c:url value='/js/login.js' />"></script>
		<title>登入會員</title>
</head>
<body style=background-color:#808080;>
        <!-- <div style=border:solid 1px;> -->
        <div id="box">
			<center>
				<h1>Sign in</h1>
			</center>		
				<hr>
                <form action="MLoginServlet" method="post" id="form">
					<!-- <div id="boxInside" > -->
                    <input type="text" name="m_account" id="name" placeholder="Email"><br>
                    <input type="password" name="m_password" id="password" placeholder="Password"><br>
                        <p>Keep me signed in
                    <input type="checkbox" name="remember" id="rememberMe">
                        </p>
                     <input id="signIn" type="submit" name="submit" value="Sign in"   ><br>
					<!-- </div> -->
				</form>
				${errorMsg}
        </div>
        <!-- </div> -->
				
	</body>
</html>