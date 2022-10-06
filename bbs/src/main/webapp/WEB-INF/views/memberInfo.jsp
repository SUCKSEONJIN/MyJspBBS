<%@page import="web.bbs.domain.Nav"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
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
<title>member info</title>

 <style>
 	.form-control[readonly], .form-control[disabled], fieldset[disabled], .form-control{
 	background-color:white;}
 	
 </style>

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

<form:form action="/home/memberInfo" method="Post" modelAttribute="member" >
<div style="width:50%" class= "mx-auto">
<div align="center">
	<h1>Member Info</h1>
</div>
	<div class="form-group">
		<form:label path="name">Name : </form:label><form:input class="form-control" path="name" disabled="true" value="${member.name}"></form:input>
		<form:errors path= "name" cssStyle="color:red"/>
	</div>
	<div class="form-group">
		<form:label path="age">Age : </form:label><form:input class="form-control" path="age" disabled="true" value="${age}"></form:input>
		<form:errors path="age" cssStyle="color:red"/>
	</div>
	<div class="form-group">
		<form:label path="userId">ID : </form:label><form:input path="userId" class="form-control" value="${userId}" disabled="true"></form:input>
		<form:errors path="userId" cssStyle="color:red"/>
	</div>
	
	<div class="form-group">
		<form:label path="password">password : </form:label><form:password path="password" class="form-control" value="${password}"></form:password>
	</div>
	<div class="form-group">
		<form:label path="email">email : </form:label><form:input path="email" class="form-control" placeholder="${email}" ></form:input>
		<form:errors path="email" cssStyle="color:red"/>
	</div>
		<button class="btn btn-primary float-right ml-2" name="home">취소</button>
		<button class="btn btn-primary float-right" onclick="modificationComplete" name="modification">수정</button>
	
	
	</div>


</form:form> 			
	
		<script>
			function modification(){
				alert("수정 완료");
			}
		</script>
	

</body>
</html>