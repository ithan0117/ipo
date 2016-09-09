<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css' />">
	<link rel="stylesheet" href="<c:url value='/css/bootstrap-theme.min.css' />">
	<link href="https://fonts.googleapis.com/css?family=Exo+2|Oxygen" rel="stylesheet">
	<link rel="stylesheet" href="<c:url value='/css/main.css' />">
	<link rel="Shortcut Icon" type="image/x-icon" href="<c:url value='/images/login2.png' />" />
	<title>IPoLa</title>
</head>
<body>
	<header> <nav class="navbar navbar-fixed-top navbar navbar-inverse ">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header ">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<!-- <a class="navbar-brand" href="#">IPo</a> -->
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav ">
				<a class="navbar-brand" href="#">IPo</a>
				<li class="active"><a href="#">Home <span class="sr-only">(current)</span></a></li>
				
				<li><a href="<c:url value='/_s/sHomepage.jsp' />" class="navText">尋覓</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">浪浪 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value='/_h/HHomeServlet' />">Foot Maps</a></li>
						<li><a href="<c:url value='/_h/hRegister.jsp' />">Insert</a></li>
						<li><a href="<c:url value='/_h/hQueryPut.jsp' />">Detail</a></li>
						
						
						<li><a href="#">Record</a></li>
						<!-- <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li> -->
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">物品 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Group Buy</a></li>
						<li><a href="#">Customer Reviews</a></li>
						<li><a href="#">Second Hand Items</a></li>
						<!-- <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li> -->
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">分享 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Diary</a></li>
						<li><a href="#">Teach</a></li>
						<li><a href="#">Help</a></li>
						<!-- <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li> -->
					</ul></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle brand"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false"
					style="padding-bottom: 0px; padding-top: 5px; height: 50px;"><div
							id="login3"></div> <span class="caret" style="margin-top: 15px;"></span></a>
					<ul class="dropdown-menu">
						<li><a href="<c:url value='/_m/mLogin.jsp' />">Login</a></li>
						<li><a href="<c:url value='/_m/mAccount.jsp' />">Edit</a></li>
						<li><a href="<c:url value='/_m/mRegister.jsp' />">Register</a></li>
						<li><a href="<c:url value='/_m/MLogOutServlet' />">LogOut</a></li>
						<!-- <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li> -->
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav> </header>

	<div class="contanier">
		<div class="row">
			<div class="blockMain col-md-12">
				<div id="title">iPo浪</div>
				<!-- <div id="title3" ><img src="images/title3.png" ></div> -->
				<div id="button">
					<div>
						<input type="image" src="<c:url value='/images/search.png' />"
							onclick="location.href='${pageContext.servletContext.contextPath}/_s/sHomepage.jsp'" id="search" />
							
					</div>
					<div>
						<input type="image" src="<c:url value='/images/stray.png' />" onclick="send();"
							id="stray" />
					</div>
					<div>
						<input type="image" src="<c:url value='/images/item.png' />" onclick="send();"
							id="item" />
					</div>
					<div>
						<input type="image" src="<c:url value='/images/lifepost.png' />" onclick="send();"
							id="lifepost" />
					</div>

					<!--///////////////////////////////////////////////////////////-->

					<div id="carousel-example-generic" class="carousel slide"
						data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-generic" data-slide-to="0"
								class="active"></li>
							<li data-target="#carousel-example-generic" data-slide-to="1"></li>
							<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							<li data-target="#carousel-example-generic" data-slide-to="3"></li>
							<li data-target="#carousel-example-generic" data-slide-to="4"></li>
						</ol>

						<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox">
							
							<div class="item active"
								style="background: url(<c:url value='/images/1.jpg' />) center center; background-size: cover;">
								<!--  <img class="image" src="images/1.jpg"  alt="..."> -->
								<!-- <div class="carousel-caption">
                    meow
                  </div> -->
							</div>
							
							<div class="item"
								style="background: url(<c:url value='/images/2.jpg' />) center center; background-size: cover;">
								<!--  <div class="carousel-caption">
                  </div> -->
							</div>
							
							<div class="item"
								style="background: url(<c:url value='/images/3.jpg' />) center center; background-size: cover;">
								<div class="carousel-caption"></div>
							</div>
							
							<div class="item"
								style="background: url(<c:url value='/images/4.jpg' />) center center; background-size: cover;">
								<!-- <img class="image" src="images/4.jpg" alt="..."> -->
								<div class="carousel-caption"></div>
							</div>

							<div class="item"
								style="background: url(<c:url value='/images/5.jpg' />) center center; background-size: cover;">
								<!-- <img class="image" src="images/5.jpg" alt="..."> -->
								<div class="carousel-caption"></div>
							</div>

						</div>

					</div>

					<!--///////////////////////////////////////////////////////////-->

					<!-- <div><img src="images/cathead.png" width="250px" height="180px" id="cathead"/></div> -->
				</div>

				<div id="subTitle">Some Where We Belong</div>

				<!--  <div>
         <input type="image" src="images/login2.png" onclick="location.href='mLogin.html'" 
         id="login"/></div>      
         <div id="talkbubble" hidden><img src="images/talkbubble.png" >
            <div id="talkMSG"><a href="mLogin.html" >Login </a>or<br> 
            <a href="mRegister.html" >Register</a></div>
         </div>
            </div> -->

				<div>
					<video id="myMovie" src="<c:url value='/video/cat.mp4' />" autoplay loop
						style="opacity:0.8;"></video>
				</div>
			</div>
		</div>

		<footer class="footer navbar-inverse">
		<div class="contanier-fuild">
			<div class="row">
				<div class="col-md-12">
					<p>Copyright c National Taipei University of Technology.
						Taipei, Taiwan; all rights reserved.</p>
					<p>1, Sec. 3, Zhongxiao E. Rd., Taipei 10608 Taiwan, R.O.C.</p>

				</div>
			</div>
		</div>

		</footer>


		<!-- <div id="title">iPo浪</div>
        <div id="button">
            <div><input type="image" src="images/search.png" onclick="location.href='sHomepage.html'" id="search"/></div>
            <div><input type="image" src="images/stray.png" onclick="send();" id="stray"/></div>
            <div><input type="image" src="images/item.png" onclick="send();" id="item"/></div>
            <div><input type="image" src="images/lifepost.png" onclick="send();" id="lifepost"/></div>
            <div><img src="images/cathead.png" width="250px" height="180px" id="cathead"/></div>
        </div>
        <div>
            <video id="myMovie" src="video/cat.mp4" autoplay loop style="opacity:0.8;" ></video>
        </div>
        <div id="subTitle">Some Where We Belong</div>
         <div><input type="image" src="images/login2.png" onclick="location.href='mLogin.html'" id="login"/></div>      
         <div id="talkbubble" hidden><img src="images/talkbubble.png" >
            <div id="talkMSG"><a href="mLogin.html" >Login </a>or<br> 
			<a href="mRegister.html" >Register</a></div>
         </div> -->

		
		<script src="<c:url value='/js/jquery-3.1.0.min.js' />"></script>
		<script src="<c:url value='/js/bootstrap.min.js' />"></script>
		<script src="<c:url value='/js/ipo.js' />"></script>
</body>
</html>
