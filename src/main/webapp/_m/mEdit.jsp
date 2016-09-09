<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="<c:url value="/css/edit.css" />">
        <script src="<c:url value="/js/jquery-1.12.4.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/js/jquery.validate.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/js/additional-methods.min.js" />"></script>
        <script type="text/javascript" src="<c:url value="/js/messages_zh_TW.js" />"></script>
        <script src="<c:url value="/js/edit.js" />"></script>
		<title>會員資料修改</title>
</head>
<body style=background-color:#808080;>
        <div>
        <div id="box">
			<center>
            <h1>Account Settings</h1>
			</center>
			<hr>
                <form action="MEditServlet" method="post" id="form" >
                    <input type="text" name="m_nickname" id="m_nickname" value="${LoginOK.m_nickname}" placeholder="Username" ><br>
                        <!-- <label for="m_nickname"class="error"></label> -->
                    <input type="password" name="m_password" id="m_password" placeholder="Current Password" ><br>
                        <!-- <label for="m_account"class="error"></label> -->
					<input type="password" name="m_newPassword" id="m_newPassword" placeholder="New Password" ><br>
                        <!-- <label for="m_password"class="error"></label> -->
					<input type="password" name="passwordConfirm" id="passwordConfirm" placeholder="New Password Confirm" ><br>
                        <!-- <label for="passwordConfirm"class="error"></label> -->
                        <p>Show password
                    <input type="checkbox" name="showPassword" id="showPassword">
                        </p>
                        <input id="save" type="submit" name="submit" value="Save Changes" ><br>
                </form>
                ${errorMsg}
        </div>
        </div>
	</body>
</html>