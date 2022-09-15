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
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="/js/bootstrap.min.js"></script>

<style>
	.form-control[readonly], .form-control[disabled], fieldset[disabled], .form-control{
		background-color:white;
	}
</style>

<title>Insert title here</title>
</head>
<body>

<%
	request.setAttribute("logOutUri",Nav.LOGOUT_NAV);
	request.setAttribute("bbsUri",Nav.BBS_NAV);	
	request.setAttribute("loginUri", Nav.LOGNIN_NAV);
	request.setAttribute("signUpUri", Nav.SIGNUP_NAV);

	
%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
 <a class="navbar-brand mr-auto" href="#">Navbar</a>
  <button class="navbar-toggler type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>  

  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav" >
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${bbsUri}">BBS</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">about</a>
      </li>
     </ul>
     <ul class="navbar-nav ml-auto">    
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle ml-auto" href="#" role="button" data-toggle="dropdown" aria-expanded="true">
          List
        </a>        
        <div class="dropdown-menu ">
        	<c:if test="${sess == null}">
	          <a class="dropdown-item" href="${loginUri}">LogIn</a>
	          <a class="dropdown-item" href="${signUpUri}">Join</a>
	        </c:if>
	        <c:if test="${sess != null}">
	        	<button class="dropdown-item" onclick="getAlert()">LogOut</button>
	        </c:if>
	                  
        </div>       
      </li>     
    </ul>
  </div>
  
 <c:if test="${sess != null}">${member.userId}님</c:if>
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

			

		<form:form action="/home/bbs/modify" method="get" modelAttribute="bbsData">
			<div class="form-group">
				<form:label path="title">Title : </form:label> <form:input path="title" readonly="true" value="${bbsData.title}" class="form-control"></form:input>
			</div>			
			<div class="form-group">		
				<form:label path="text">content : </form:label><br>
				<form:textarea class = "form-control" rows="20" cols="50" path="text" readonly= "true" value="${bbsData.text}" ></form:textarea>
			</div>
			<div class="form-group">				
				<form:hidden class="form-control" path="author" value="${member.userId}"/>							
			</div>
			<div>
				<form:hidden path="id" value="${bbsData.id}"/>
			</div>
			<div><input type="hidden" value="${currentPageNumber}" name="currentPageNumber" ></div>
			<div class="form-group">
				<c:if test="${member.userId == bbsData.author}">
					<input type="submit" class="btn btn-primary" value="수정" name="modify">												
				</c:if>
				<input type="submit" class="btn btn-primary" value="목록" name="list">
			</div>
			<div>
				<form:hidden path="id"></form:hidden>
			</div>
			
		</form:form>		
			
				
	
	
</body>
</html>