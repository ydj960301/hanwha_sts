<%@page import="com.hanwha.model.DeptDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.hanwha.model.DeptDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- namespace기술 uri에 대부분 회사이름씀 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script> 
	function call(){	
		location.href="deptinsert"
	}
</script>
</head>
<body>
<h1> 부서목록............${name }</h1>
<button onclick="call();">부서 추가 </button> <!-- jsp에서 jsp이동은 좋지않음 서블릿으로 가는게 좋음. -->
	<hr>
	<table border="1">
		<tr>
			<td>부서번호</td>
			<td>부서이름</td>
			<td></td>
		</tr>
		<c:forEach var="dept" items="${deptlist}">
		<tr>
			<td><a href="deptdetail?deptid=${dept.dept_id}">${dept.dept_id}</a></td> <!-- dept의 변수쓰면 알아서 자동으로 getter 호출 -->
			<td>${dept.deptname}</td>
			<td><a href="deptdelete?deptid=${dept.dept_id }">삭제</a></td>
		</tr>
		</c:forEach>
	
	</table>
	
	
	
</body>
</html>