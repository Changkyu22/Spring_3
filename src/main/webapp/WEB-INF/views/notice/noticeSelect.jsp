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
	<h1>Notice Select Page</h1>
	<img alt="" src="../resources/images/park2.jpg">
	<div class="container">
		<table class="table">
			<thead>
				<tr class="info"><th>NUM</th><th>TITLE</th><th>WRITER</th><th>DATE</th><th>HIT</th></tr>
			</thead>
			<tbody>
				<tr class="active">
					<td>${dto.num}</td>
					<td>${dto.title}</td>
					<td>${dto.writer}</td>
					<td>${dto.reg_date}</td>
					<td>${dto.hit}</td>
				</tr>
			</tbody>
		</table>
		<div class="container">
 			<form>
    		<div class="form-group">
      			<label for="comment">Contents:</label>
      			<textarea class="form-control" rows="5" id="comment" >${dto.contents}</textarea>
    		</div>
  			</form>
  			
  			<a href="./noticeUpdate.notice?num=${requestScope.dto.num}">Update</a>
  			<a href="./noticeDelete.notice?num=${requestScope.dto.num}">Delete</a>
  		</div>
	</div>
	
</body>
</html>