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
<link href="/css/AtagProperty.css" rel="stylesheet">
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
	
	<form:form method="post" modelAttribute="shopData" enctype="Multipart/form" class="form-group">
		<div>
			<label for="file">이미지 업로드  </label>
			<input type="file" name="file" id="file">
		</div>
		
		<div class="form-group">
			<form:label path="title" >title : </form:label><form:input path="title" class="form-control"/>
			<form:errors path="title" cssStyle="color:red"></form:errors>
		</div>
		<div class="form-group">
			<form:label path="location" >location : </form:label><form:input path="location" class="form-control"/>
			<form:errors cssStyle="color:red" path="location"></form:errors>
		</div>
		<div class="form-group">
			<form:label path="text"></form:label><form:textarea path="text" class="form-control"/>
			<form:errors path="text" cssStyle="color:red"></form:errors>
		</div>
		
		<form:button name="check" class="btn btn-primary ml-4">등록</form:button>
		<form:button name="cancel">목록</form:button>
		
	</form:form>
			
	
		
	

</body>
</html>