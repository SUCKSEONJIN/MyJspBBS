<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	ID가 중복입니다.	
	<button onclick="WindowClose()" >확인</button>
	
	<form method= "POST" action="/home/signUp/form">
		<input type="hidden" name="duplicatedCheck" value="true"/>
		<button type="submit" onclick="WindowClose()"></button>	
	</form>
	
		
	<script>
		function WindowClose(){
			window.close();
		}
	</script>
	
</body>
</html>