<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="<c:url value='/css/bootstrap.min.css' />">
    <link rel="stylesheet" href="<c:url value='/css/bootstrap-theme.min.css' />">
    <link rel="stylesheet" href="<c:url value='/css/sFoundRegBoostrap.css' />">
    <link href="https://fonts.googleapis.com/css?family=Exo+2|Oxygen" rel="stylesheet">
	<!-- <link rel="stylesheet" href="css/sFoundReg.css"> -->
	<title>登記</title>
</head>
<body>
  <header>
	<nav class="navbar navbar-fixed-top navbar navbar-inverse "   >
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header ">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">IPo</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav ">
      <li><a href="#" class="imSpace"></a></li>
      <li><a href="#" class="imSpace"></a></li>
        <li class="active"><a href="#">Home <span class="sr-only">(current)</span></a></li>
        <li><a href="<c:url value='/_s/sHomepage.jsp' />">尋覓</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">浪浪 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">物品 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">分享 <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>

      

      <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Login <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</header>

	<div class="contanier">
		<div class="row">
			<div class="col-md-8 col-md-offset-2">
        <div class="col-md-6">
          <div class="innerBox" id="innerBoxLeft">
            <form action="????????????">
              <h4>Name</h4><input class="inputLeft" type="text" name="s_name" >
              <h4>Phone / Email</h4><input class="inputLeft" type="text" name="s_conn">
              <h4>Date & Time</h4><input class="inputLeft" type="text" name="s_time">
              <h4>Location</h4><input class="inputLeft" type="text" name="s_location">
              <h4>Comments</h4>
              <textarea name="s_desc" cols="30" rows="5" wrap="virtual"></textarea><br>
              <div id="innerDiv"><input type="file" id="upload" ><a id="fakeUpload">Upload Your Photo</a></div>
              <input type="submit" id="submit" name="send" value="send">

           </form>
    </div>
        </div>
           <div class="col-md-6">
            <div id="frameDiv"><img src="<c:url value='/images/frame3.png' />"  id="frame"></div>
            <div id="photo"><img src="<c:url value='/images/cathead.png' />"  id="image"></div>
            <div id="defaultMSG">No Photo</div>
             <div id="map"></div>
            <div id="location"><input  type="text" name=""></div>
           </div>   
      </div>
		</div>
	</div>

<footer class="footer navbar-inverse">
      <div class="contanier-fuild">
        <div class="row">
          <div class="col-md-12">
          <p>Copyright c 2009國立臺北科技大學進修部推廣教育中心，所刊載內容均受著作權法保護</p>
            <p>10608台北市忠孝東路三段一號 光華館2樓208室 Tel: 02-2771-2171總機1720 Fax:02-2721-9524 信箱：sce@mail.ntut.edu.tw</p>

          </div>
        </div>
      </div>

    </footer>

  <script src="<c:url value='/js/jquery-3.1.0.min.js' />"></script>
  <script src="<c:url value='/js/sFoundReg.js' />"></script>
	<script src="<c:url value='/js/bootstrap.min.js' />"></script>
</body>
</html>