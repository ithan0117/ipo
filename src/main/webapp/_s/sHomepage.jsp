<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="<c:url value='/css/sMain.css' />">
        <script src="<c:url value='/js/jquery-3.1.0.min.js' />"></script>
        <script>
        $(document).ready(function() {
          $("form input:radio").change(function() {
                if ($(this).val() == "Edit") {
                    $('.bottomRadio').attr('disabled',true);
                    } 
                    else {
                    $(".bottomRadio").attr('disabled', false);   
                     }
                });
                });
        </script>
		<title>尋覓</title>
</head>
<!-- <body style=background-color:#232323> -->
	<body background="<c:url value='/images/sbackground.jpg' />">
        <div id="box">
            <form action="sHomeSearch" method="post">
            <div id="topSelectBox">
                    <div>
                    	<img src="<c:url value='/images/skrew.png' />" id="skrew1">
                        <img src="<c:url value='/images/skrew.png' />" id="skrew2">
                        <img src="<c:url value='/images/skrew.png' />" id="skrew3">
                        <img src="<c:url value='/images/skrew.png' />" id="skrew4">
                    </div>
                   
                    <center>                       
                        <div class="innerDiv" id="divSearch">                
                            <div><input type="radio" name="topSelect" value="search" class="topRadio"></div>
                            <img src="<c:url value='/images/magnifier.png' />" class="image">
                            <div class="text">Search</div>
                        </div>
                        
                        <div class="innerDiv" id="divInsert">
                            <div><input type="radio" name="topSelect" value="insert" class="topRadio"></div>
                            <img src="<c:url value='/images/plus.png' />" class="image">
                            <div class="text">Insert</div>
                        </div>
                        
                        <div class="innerDiv"id="divEdit">
                            <div><input type="radio" name="topSelect" class="topRadio" value="edit" id="Edit"></div>
                            <img src="<c:url value='/images/compose.png' />" class="image">
                            <div class="text">Edit</div>
                        </div>
                    </center>
                    
            </div>
            
            <center><img src="<c:url value='/images/scotchvertical.png' />" id="scotchvertical" ></center>
            
            <div id="bottomSelectBox">
                <center>                       
                        <div class="innerDiv2" id="lost">                
                            <div><input type="radio" name="bottomSelect" value="lost" class="bottomRadio"></div>
                            <img src="<c:url value='/images/halloween-cat.png' />" class="image">
                            <div class="text">Lost</div>
                        </div>
                        
                        <input type="submit" name="" value="Confirm" id="submit">
                        
                        <div class="innerDiv2" id="found">
                            <div><input type="radio" name="bottomSelect" value="found" class="bottomRadio"></div>
                            <img src="<c:url value='/images/male.png' />" class="image">
                            <div class="text">Found</div>
                        </div>
                 <center>
            </div>
            
            </form>
        </div>

        <!-- <script src="js/jquery-3.1.0.min.js"></script> -->
        <!-- <script src="js/sHomepage.js"></script> -->
	</body>
</html>
