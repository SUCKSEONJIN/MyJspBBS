<%@page import="web.bbs.domain.Nav"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
    
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
        <a class="nav-link" href="${shopUri}">Shop</a>
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
  
 <c:if test="${sess != null}">${member.userId}???</c:if>
</nav>
	
	<c:if test="${check}">
		<script>
			alert("????????? ??????")
		</script>
	</c:if>
		

		<script>
		function getAlert(){			
			var str;
			if(confirm("?????? ??????????????? ???????????????????") == true){
				window.location.href="/home/logOut";
			}else{
				
			}
			 }
		</script>

			

		<form:form action="/home/bbs/write" method="post" modelAttribute="bbsData" >
			
		<div class="mx-auto" style="width:50%;" >
			<div class="form-group">
				<form:label path="title">Title : </form:label> <form:input path="title" class="form-control"/>
			</div>			
			<div class="form-group">		
				<form:label path="text">content : </form:label><br>
				<form:textarea class = "form-control" rows="20" cols="50" path="text"></form:textarea>
			</div>
			<div class="form-group">				
				<form:hidden class="form-control" path="author" value="${member.userId}"/>							
			</div>
			<div><input type="hidden" value="${currentPageNumber}" name="currentPageNumber" ></div>
			<div class="form-group">				
				<input type="submit" class="btn btn-primary ml-4 float-right" value="??????" name="cancel" > 			
				<input type="submit" class="btn btn-primary float-right" value="??????" name="check">
			</div>
		</div>
		</form:form>		
			
				
	
	
</body>
</html>