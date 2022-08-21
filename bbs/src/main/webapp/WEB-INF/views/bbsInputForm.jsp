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
<title>Insert title here</title>
</head>
<body>


		<form:form action="/home/bbs/write" method="post" modelAttribute="bbsData">
			<div class="form-group">
				<form:label path="title">Title : </form:label> <form:input path="title"/>
			</div>			
			<div class="form-group">		
				<form:label path="text">content : </form:label><br>
				<form:textarea class = "form-control" rows="20" cols="50" path="text"></form:textarea>
			</div>
			<div class="form-group">				
				<form:hidden class="form-control" path="author" value="${member.id}"/>					
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-primary" value="확인">
				<input type="button" class="btn btn-primary" onclick="location.href='/home/bbs'" value="취소"> 
			</div>
		</form:form>		
			
				
	
	</table>
</body>
</html>