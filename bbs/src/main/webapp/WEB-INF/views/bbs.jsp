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
<title>Insert title here</title>
</head>
<body>


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
        <a class="nav-link" href="/home/bbs">BBS</a>
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
          <a class="dropdown-item" href="#">LogIn</a>
          <a class="dropdown-item" href="#">Join</a>          
        </div>
      </li>
    </ul>
  </div>
</nav>
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
			<tr>
				<c:forEach items="${bbsDatas}" var="bbsData">
				<td>${bbsData.id}</td>
				<td>${bbsData.title}<td>
				<td>${bbsData.author}</td>
				<td>${bbsData.time}</td>
				<td>${bbsData.good}</td>					
				</c:forEach>				
			</tr>
			
		
			
		</tbody>
	</table>
		<div class="col">
			<button class="float-right" onclick="location.href='/home/bbs/write'" >작성</button>
		</div>
	</div>
</div>
</body>
</html>