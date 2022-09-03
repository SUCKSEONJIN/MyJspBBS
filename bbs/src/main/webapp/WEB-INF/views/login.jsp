<%@page import="web.bbs.domain.Nav"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial=1">
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</head>
<body>

<%
	request.setAttribute("bbsUri",Nav.BBS_NAV);	
	request.setAttribute("loginUri", Nav.LOGNIN_NAV);
	request.setAttribute("signUpUri", Nav.SIGNUP_NAV);
%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
 <a class="navbar-brand" href="#">Navbar</a>
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
          <a class="dropdown-item" href="${loginUri}">LogIn</a>
          <a class="dropdown-item" href="${signUpUri}">Join</a>          
        </div>
      </li>
    </ul>
  </div>
</nav>

<div class= container>
<form:form action="/home/login/form?url=${url}" modelAttribute="member" method="Post">
 <div class="row justify-content-center mt-5">
 <div class= "border col-md-6 p-4" >
 	<div class="text-center mb-3">
 		<h3>Login</h3>
 	</div>
	
	<table class= "mx-auto">				
		<tr class="form-group p-3">
			<td><form:label path="userId">ID : </form:label></td>
			<td><form:input path="userId" class="form-control mb-2"/></td>
			<td><form:errors path="userId" cssStyle="color:red"/></td>
		</tr>				
		<tr class= "form-group p-3">
			<td><form:label path="password">password :</form:label></td>
			<td><form:password path="password" class="form-control"/></td>
			<td><form:errors path="password" cssStyle="color:red" /></td>
		</tr>
	</table>

		<div>
			<form:button class="btn btn-primary float-right mt-4">submit</form:button></td>			
		</div>
	
	</div>
	</div>	
</form:form>	
</div>			
		
	
		
	
</body>
</html>