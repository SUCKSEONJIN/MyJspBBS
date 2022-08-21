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
	<form:form action="/home/login/form" ModelAttribute="member">
		<h3 class="mx-auto">sign</h3>
		<div class="form-group">
			<form:label path="login">ID : </form:label>
			<form:input path="login" class="form-control"/>
		</div>
		<div class= "form-group">
			<form:label path="password">password :</form:label>
			<form:password path="password"/>
			<form:errors path="password" cssStyle="color:red" class="form-control"/>
		</div>
		<div class="form-group">
			<form:button class="btn btn-primary">확인</form:button>
		</div>
	
	</form:form>	
			
		
	
		
	
</body>
</html>