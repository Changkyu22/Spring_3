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
		<form id="frm" action="./qnaList">
		<input type="hidden" id="curPage" value="1" name="curPage">
			<select name="kind">
					<option id="kt" value="kt">TITLE</option>
					<option id="kc" value="kc">CONTENTS</option>
					<option id="kw" value="kw">WRITER</option>
			</select>
			<input type="text" name="search" value="${pager.search}">
			<button>검색</button>
		</form>
	</div>
	  <div>
	 	 <ul class="pagination">
		 	 <c:if test="${pager.curBlock gt 1}">
		 	 	<li><span id="${pager.startNum-1}" class="list">이전</span></li>
<%-- 			 	<li><a href="./qnaList?curPage=${pager.startNum-1}">이전</a></li> --%>
		 	 </c:if>
			 <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
			 	<li><span id="${i}" class="list">${i}</span></li>
<%-- 				<li><a href="./qnaList?curPage=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li> --%>
			 </c:forEach>
			 <c:if test="${pager.curBlock lt pager.totalBlock}">
			 	<li><span id="${pager.lastNum+1}" class="list">다음</span></li>
<%-- 				<li><a href="./qnaList?curPage=${pager.lastNum+1 }">다음</a></li>		  --%>
			 </c:if>
	  	 </ul>
	  </div>
	  <a href="./qnaWrite">Write</a>
	 </div>	
	 
	 <script type="text/javascript">
		var kind = '${pager.kind}';
		if(kind ==''){
			kind="kt";
		}
	 	$("#"+kind).prop("selected", true);
	 	$(".list").click(function() {
			$("#curPage").val($(this).attr("id"));
			$("#frm").submit();
		});
	 
	 </script>
</body>
</html>