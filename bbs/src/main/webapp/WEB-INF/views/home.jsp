<%@page import="web.bbs.domain.Nav"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial=1">
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/customStyle.css" rel="stylesheet">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>

<style>
	.carousel-inner img {
    width: 600px;
    height: 300px;
  }
</style>
<body>
 


<nav class="navbar navbar-expand-lg navbar-light bg-light">
 <a class="navbar-brand mr-auto" href="${homeUri}">Navbar</a>
  <button class="navbar-toggler type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>  

  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav" >
      <li class="nav-item active">
        <a class="nav-link" href="${homeUri}">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${bbsUri}">BBS</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${shopUri}">shop</a>
      </li>
     </ul>
     <ul class="navbar-nav ml-auto">    
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle ml-auto" href="#" role="button" data-toggle="dropdown" aria-expanded="true">
          List
        </a>        
        <div class="dropdown-menu ">
        	<c:if test="${sess == null or sessionScope.member == null}">
	          <a class="dropdown-item" href="${logInUri}">LogIn</a>
	          <a class="dropdown-item" href="${signUpUri}">Join</a>
	        </c:if>
	        <c:if test="${sess != null and sessionScope.member != null}">
	        	<button class="dropdown-item" onclick="getAlert()">LogOut</button>
	        </c:if>
	                  
        </div>       
      </li>     
    </ul>
  </div>
  
 <c:if test="${sess != null and sessionScope.member != null}"><a href="/home/memberInfo"> ${sessionScope.member.userId}님</a></c:if>
</nav>
	
	<c:if test="${check}">
		<script>
			alert("로그인 성공")		
		</script>
	</c:if>
		

		<script>
		function getAlert(){			
			var str;
			if(confirm("정말 로그아웃을 하시겠습니까?") == true){			
				window.location.href="/home/logOut";
			}else{
				
			}
			 }
		</script>

			
	<div class=".jumbotron jumbotron-fluid">
		<div class="container align mt-5" align="center">
			<h1>WELLCOME TO MY PROJECT</h1>
			
			<div id="introduction" class="carousel slide" data-ride="carousel">
				<!-- indicators -->
				<ul class="carousel-indicators">
					<li data-target="#introduction" data-slide-to="0" class="active"></li>
					<li data-target="#introduction" data-slide-to="1" ></li>
					<li data-target="#introduction" data-slide-to="2"></li>	
					<li data-target="#introduction" data-slide-to="3"></li>		
				</ul>	
		
			<!-- The slideShow  -->
			<div class="carousel-inner">			
				<div class="carousel-item active">
					<img src ="/img/sea.jpg" class="rounded" width="600" height="300" alt="no image" />
				</div>			
				<div class="carousel-item">
					<img src="/img/cat1.jpg" alt="no image" class="rounded" width="600" height="300">
				</div>
				<div class="carousel-item">
					<img src="/img/home1.jpg" alt="no image" class="rounded" width="600" height="300"/>
				</div>
				<div class="carousel-item">
					<img src="/img/Siamese cat.jpg" alt="no image" class="rounded" width="600" height="300">
				</div>
			</div>
			
			<!-- Left and Light controls -->
			<a class="carousel-control-prev" href="#introduction" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>			
			</a>
			<a class="carousel-control-next" href="#introduction" data-slide="next">
				<span class="carousel-control-next-icon"></span>
			</a>
		
			</div>
			
		</div>
	</div>
	
	
	
	
		
	

</body>
</html>