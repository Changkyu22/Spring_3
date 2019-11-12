<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
	<c:import url="../layout/nav.jsp" />
	<div class="container">
  		<div class="jumbotron">
    		<h1>QnA List Page</h1>
		</div>
	</div>
	<div class="container">
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>NUM</th><th>TITLE</th><th>WRITER</th><th>DATE</th><th>HIT</th><th>REF</th><th>STEP</th><th>DEPTH</th>
	      </tr>
	    </thead>
	    <tbody>
	    	<c:forEach items="${list}" var="dto" varStatus="st">
		      <tr>
		        <td>${dto.num}</td>
		        <td><a href="./qnaSelect?num=${dto.num}">${dto.title}</a></td>
		        <td>${dto.writer}</td>
		        <td>${dto.reg_date}</td>
		        <td>${dto.hit}</td>
		        <td>${dto.ref}</td>
		        <td>${dto.step}</td>
		        <td>${dto.depth}</td>
		      </tr>
	    	</c:forEach>
	    </tbody>
	  </table>
	  <div>
		<form action="./qnaList">
			<select name="kind">
				<option value="kt">TITLE</option>
				<option value="kc">CONTENTS</option>
				<option value="kw">WRITER</option>
			</select>
			<input type="text" name="search">
			<button>검색</button>
		</form>
	</div>
	  <div>
	 	 <ul class="pagination">
		 	 <c:if test="${pager.curBlock gt 1}">
			 	 <li><a href="./qnaList?curPage=${pager.startNum-1 }">이전</a></li>
		 	 </c:if>
			  	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
				  	<li><a href="./qnaList?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
			  	</c:forEach>
			 <c:if test="${pager.curBlock lt pager.totalBlock }">
				 <li><a href="./qnaList?curPage=${pager.lastNum+1 }">다음</a></li>		 
			 </c:if>
	  	 </ul>
	  </div>
	  <a href="./qnaWrite">Write</a>
	 </div>	
</body>
</html>