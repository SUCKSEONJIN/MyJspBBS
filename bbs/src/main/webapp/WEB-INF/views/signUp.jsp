<%@page import="web.bbs.domain.Member"%>
<%@page import="web.bbs.domain.Nav"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial=1">
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/customStyle.css" rel=stylesheet">
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<title>Sign up Window</title>
</head>
<body>



<nav class="navbar navbar-expand-lg navbar-light bg-light">
 <a class="navbar-brand" href="${homeUri}">Navbar</a>
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
          <a class="dropdown-item" href="${logInUri}">LogIn</a>
          <a class="dropdown-item" href="${signUpUri}">Join</a>          
        </div>
      </li>
    </ul>
  </div>
</nav>

<form:form action="/home/signUp/form" method="Post" modelAttribute="member"  >
	<div style="width:50%" class="mx-auto">
			
		<div class= "form-group" align="center">
			<h1>Sign up</h1>
		</div>
		
		<div class="form-group">
			<form:label path="name">Name : </form:label>
			<form:input class= "form-control" path="name" size="100"/>
			<form:errors path="name" cssStyle="color:red"/>		
		</div>
		
		<div class="form-group">	
			<form:label path="age">Age : </form:label>
			<form:input class="form-control" path="age"/>
			<form:errors path="age" cssStyle="color:red"/>
		</div>
		<div class="form-group">
			<form:label path="userId">ID : </form:label>
			<form:input class="form-control" path="userId"/>
			<form:errors path="userId" cssStyle="color:red"/>
					
			<button class="btn" name="du">중복확인</button>
			<c:if test="${status == true }">
				<script type="text/javascript">
					document.write("status :" +  "${check}");	
					function duplicatedAlert(check){
						if(check == "false"){
							alert("중복 입니다. 다른 아이디를 사용하세요.");													
						}else{
							alert("사용 가능한 아이디 입니다.")	
							
						}
				}
					duplicatedAlert("${check}");
				</script>
				
				
			</c:if>
		</div>	
				
		<div class="from-group">	
			<form:label path="password">password : </form:label>
			<form:password path="password" class="form-control"/>
			<form:errors path="password" cssStyle="color:red" />
		</div>
		
		<div class="form-group">
			<form:label path="email">E-mail : </form:label>
			<form:input path="email" class="form-control"></form:input>
			<form:errors path="email" cssStyle="color:red"/>
		</div>
		<div>
			<c:if test="${check == true}">		
				<form:button class="btn btn-primary float-right" onclick="joinCongratulation()">확인</form:button>
			</c:if>			
		</div>
		<div>	
			<c:if test="${check != true }">
			<button class="btn btn-primary float-right" onclick="submitBan()">확인</button>		
			</c:if>
		</div>
	</div>
</form:form>
<c:set var="check1" value="false" scope="page"/>
<script type="text/javascript" >

	function submitBan(){				
		alert("중복 아이디 체크를 해야합니다.");	
	}
	function joinCongratulation(){
		alert("회원가입 축하합니다");
	}
</script>




</body>
</html>