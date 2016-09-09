<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value='/css/register.css' />">
        <script src="<c:url value='/js/jquery-1.12.4.min.js' />"></script>
        <script type="text/javascript" src="<c:url value='/js/jquery.validate.min.js' />"></script>
        <script type="text/javascript" src="<c:url value='/js/additional-methods.min.js' />"></script>
        <script type="text/javascript" src="<c:url value='/js/messages_zh_TW.js' />"></script>
        <script src='https://www.google.com/recaptcha/api.js'></script>
        <!-- <script type="text/javascript" src="js/messages_zh_TW.min.js"></script> -->
        
        <script src="<c:url value='/js/regiser.js' />"></script>
		
		<title>註冊會員</title>
</head>
<body style=background-color:#808080;>
        <div>
        <div id="box">
			<center>
            <h1>Sign up</h1>
			</center>
			<hr>
                <form action="MRegServlet" method="post" id="form" >
                    <input type="text" name="m_nickname" id="m_nickname" placeholder="Username"required ><br>
                        <!-- <label for="m_nickname"class="error"></label> -->
                    <input type="email" name="m_account" id="m_account" placeholder="Email" ><br>
                        <!-- <label for="m_account"class="error"></label> -->
					<input type="password" name="m_password" id="m_password" placeholder="Password" ><br>
                        <!-- <label for="m_password"class="error"></label> -->
					<input type="password" name="passwordConfirm" id="passwordConfirm" placeholder="Password Confirm" ><br>
                        <!-- <label for="passwordConfirm"class="error"></label> -->
                    <p>Show password
                    	<input type="checkbox" name="showPassword" id="showPassword">
                    </p>
                    <div class="g-recaptcha" data-sitekey="6LfrsigTAAAAAI9LbEWhjkfK5fpGUQ_a1b-dw3Vx"></div>
                    <input id="signUp" type="submit" name="submit" value="Sign up" ><br>
                </form>
                ${errorMsg.errorM_account}
				${errorMsg.errorM_password}
        </div>
        </div>
	</body>
</html>