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
	  <h2>Notice Update Page</h2>
	  <form action="./noticeUpdate.notice?num=${dto.num}" method="post" id="frm" onsubmit=true>
	  	<input type="hidden" name="num" value="${dto.num}">
	  	
	    <div class="form-group">
	      <label for="name">TITLE</label>
	      <input type="text" class="form-control" id="title" value="${dto.title}" name="title">
	    </div>
	    
	    <div class="form-group">
	      <label for="name">WRITER</label>
	      <input type="text" class="form-control" id="writer" value="${dto.writer}" name="writer" readonly="readonly">
	    </div>
	    
	    <div class="form-group">
      		<label for="comment">Contents:</label>
      		<textarea class="form-control" rows="5" id="contents" name="contents">${dto.contents}</textarea>
   		</div>
   		
   		<button type="submit" class="btn btn-default" id="submit">UPDATE</button>
		<a href="./noticeList" class="btn btn-default">LIST</a>
   		
	  </form>
	 </div>

</body>
</html>