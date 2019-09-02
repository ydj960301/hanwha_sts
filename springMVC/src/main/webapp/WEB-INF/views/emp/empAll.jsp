<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script> 
	function call(){	
		location.href="empinsert"
	}
</script>
</head>
<body>
	<h1>직원목록</h1>
	<button onclick="call();">직원 추가</button>
	<table border="2px">
		<tr>
			<td>직원 번호</td>
			<td>직원 이름</td>
			<td>직원 성</td>
			<td>직원 이메일</td>
			<td>직원 전화번호</td>
			<td>직원 입사일</td>
			<td>직원 직무</td>
			<td>직원 급여</td>
			<td>커미션</td>
			<td>담당자사원번호</td>
			<td>부서번호</td>
			<td></td>
			
		</tr>
		<c:forEach var="emp" items="${emplist}">
		<tr>
			<td><a href="empdetail?id=${emp.employee_id}">${emp.employee_id}</a></td>
			<td>${emp.first_name}</td>
			<td>${emp.last_name}</td>
			<td>${emp.email}</td>
			<td>${emp.phone_number}</td>
			<td>${emp.hire_date}</td>
			<td>${emp.job_id}</td>
			<td>${emp.salary}</td>
			<td>${emp.commission_pct}</td>
			<td>${emp.manager_id}</td>
			<td>${emp.department_id}</td>
			<td><a href="empdelete?id=${emp.employee_id}">삭제</a></td>
			
		</tr>
		
		</c:forEach>
	</table>
	
</body>
</html>