<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	a:link{
		color:black;
		text-decoration: none;
		background-color: transparent;
	}
	a:visited{
		color:blue;
		text-decoration:none;
		background-color: transparent;
	}
	a:active{
		color:green;
		text-decoration:none;
		background-color: transparent;
	}
</style>
</head>
<body>


<div>	

	<form action = "/test/page" method="post">
	<button id="btn1" type= "submit" name="previous">이전</button>
	<input type="hidden" id="btn1" value="${num}" name="count">	
	<input type="hidden" value="${i+num}" name="rest"/>  	
	<c:forEach  var="i" begin="1" end="${pageNumberLast}">		
		<a href="test/page/${i+num}"><c:out value="${i+num}"/></a>
	</c:forEach>		
	<button id="btn2"type="submit" name="next">다음</button>	
	<input type="hidden" value="${originalLast}" name="originalLast"/>
	</form>
	
</div>

<p>
	Button clicked <span id = "display">0 </span> Times
</p>


<script>
	var count = 0;		
	var btn1 = document.getElementById("btn1");
	var btn2 = document.getElementById("btn2"); 
	var disp = document.getElementById("display");
	btn1.onclick =		 function(){		
		count--;			
		disp.innerHTML = count;
		
	}
	
	btn2.onclick = function(){
		count++;
		disp.innerHTML = count;
	}
	

</script>


</body>
</html>