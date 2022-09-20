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
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="/js/bootstrap.min.js"></script>

<style>
	a:link{
		color:black;
		text-decoration: none;
		background: transparent;		
	}
	a:visited{
		color:black;
		text-decoration: none;
		background-color: transparent;
	}
	a:active{
		color:green;
		text-decoration:none;
		background-color: transparent;
	}
</style>

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
	          <a class="dropdown-item" href="${loginUri}">LogIn</a>
	          <a class="dropdown-item" href="${signUpUri}">Join</a>
	        </c:if>
	        <c:if test="${sess != null and sessionScope.member != null}">
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

			
	
<div class="container">
	<div class="row">
	<table  class="table table-striped table-hover mx-auto mt-5">
		
		<thead>
			<tr>
				<th scope="col">No</th>
				<th scope="col">제목</th>
				<th scope="col">글쓴이</th>
				<th scope="col">작성시간</th>
				<th scope="col">좋아요</th>
			</tr>
		</thead>
		<tbody>					
			<c:forEach items="${bbsDatas}" var="bbsData">																					
				 <tr>
					<td>${bbsData.id}</td>
					<td><a href="/home/bbs/bbsData/${bbsData.id}?currentPageNumber=${currentPageNumber}">${bbsData.title}</a></td>
					<td>${bbsData.author}</td>
					<td>${bbsData.time}</td>
					<td>${bbsData.good}</td>					
				 </tr>				 						 	
				</c:forEach>				
			
		</tbody>
	</table>
			<form action="/home/bbs/page" method="post">
				<button type="submit" name="previous">이전</button>
				<input type="hidden" value="${num}" name="count">
				<input type="hidden" value="${num + i}" name="pageNum">
				<input type="hidden" value="${originalLast}" name="originalLast"/>
				<input type="hidden" value="${currentPageNumber}" name="currentPageNumber"/>
				<c:forEach var="i"  begin="1" end="${pageNumberLast}">
					<a href="/home/bbs/<c:out value='${i+num}'/>"><c:out value="${i+num}"/></a>
				</c:forEach>
				<button type="submit" name="next" >다음</button>
			</form>
		
		<div class="col">
			<form action="/home/bbs/write" method="get">
				<button class="float-right" type="submit" >작성</button>
				<input type="hidden" value="${currentPageNumber}" name="currentPageNumber">
			</form>			
		</div>
		
	</div>
</div>
</body>
</html>