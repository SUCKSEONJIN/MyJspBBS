<%@page import="web.bbs.domain.Nav"%>
<%@page import="web.bbs.repository.bbs.BbsHashMapRepository"%>
<%@page import="web.bbs.repository.member.MemberHashMapRepository"%>
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


<style>

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
        <a class="nav-link" href="${shopUri}">Shop</a>
      </li>
     </ul>
     <ul class="navbar-nav ml-auto">    
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle ml-auto" href="#" role="button" data-toggle="dropdown" aria-expanded="true">
          List
        </a>        
        <div class="dropdown-menu">  
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

			
	
<div class="container">		
	<h5 align="left" class="mt-5 mb-3">page <span style="color: blue;">${currentPageNumber}</span>  / ${originalLast}</h5>				
	<div class="row">
	<table  class="table table-striped table-hover mx-auto ">
		
		<thead>
			<tr align="center">
				<th scope="col">No</th>
				<th scope="col">제목</th>
				<th scope="col">글쓴이</th>
				<th scope="col">작성시간</th>
				<th scope="col">조회수</th>
			</tr>
		</thead>
		<tbody>	
			<c:forEach items="${bbsDatas}" var="bbsData">																									
				 <tr align="center">
					<td>${bbsData.id}</td>
					<td><a href="/home/bbs/bbsData/${bbsData.id}?currentPageNumber=${currentPageNumber}">${bbsData.title}</a></td>
					<td>${bbsData.author}</td>
					<td>${bbsData.time}</td>
					<td>${bbsData.views}</td>					
				 </tr>				 						 	
			</c:forEach>							
		</tbody>
	</table>	
			<form action="/home/bbs/page" method="post" align="center">		
				<a href="/home/bbs/minusPageJump/${currentPageNumber}" class="mr-3">&lt&lt</a>						
				<button type="submit" name="previous">이전</button>				
				<input type="hidden" value="${num}" name="count">
				<input type="hidden" value="${num + i}" name="pageNum">
				<input type="hidden" value="${originalLast}" name="originalLast"/>
				<input type="hidden" value="${currentPageNumber}" name="currentPageNumber"/>
				<c:forEach var="i"  begin="${pageNumberFirst}" end="${pageNumberLast}">										
					<c:choose>
					 <c:when test="${currentPageNumber == i+num}">					 
					<a id="${i+num}" href="/home/bbs/<c:out value='${i+num}'/>"><span style="color: blue;">${i+num}</span></a>
					</c:when>
					<c:when test="${currentPageNumber != i+num}">
					<a id="${i+num}" href="/home/bbs/<c:out value='${i+num}'/>">${i+num}</a>
					</c:when>
					</c:choose>					
				</c:forEach>
				<button type="submit" name="next" >다음</button>
				<a href="/home/bbs/plusPageJump/${currentPageNumber}" class="ml-3">&gt&gt</a>			
			</form>
		 <div class="col">
			 <form action="/home/bbs/write" method="get">
				<button class="float-right" type="submit">작성</button>
				<input type="hidden" value="${currentPageNumber}" name="currentPageNumber">
			 </form>			
		 </div>		
	</div>
</div>
</body>
</html>