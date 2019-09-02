<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
 label{
 	background-color: green;
 	width: 10px;
 }
</style>
</head>
<body>
<h1>직원 추가하기</h1>
	<form action="empinsert" method="post">
	<label >직원번호:</label>  <input type="number" name="employee_id" ><br>
	<label>직원이름:</label>  <input type="text" name="first_name" ><br>
	<label >직원 성:</label>  <input type="text" name="last_name" ><br>
	<label>이메일: </label> <input type="text" name="email" ><br>
	<label >전화번호:</label>  <input type="text" name="phone_number" ><br>
	<label>입사일:</label>  <input type="date" name="hire_date" ><br>
	<label>직책 :</label> 
			<select name="job_id">
				<c:forEach items="${joblist}" var="job">
					<option value="${job}">${job}</option>
				</c:forEach>
			</select>
			<br>
	
	<label>급여:</label>  <input type="number" name="salary" ><br>
	<label>커미션: </label> <input type="number" name="commission_pct" ><br>
	<label >상사 직원번호:</label>  <input type="number" name="manager_id" ><br>
	<label>부서 번호 :</label> 
			<select name="department_id">
				<c:forEach items="${deptlist}" var="dept">
					<option value="${dept.dept_id}"> ${dept.deptname} </option>
				</c:forEach>
			</select>
			<br>
	
	<input type="submit" value="입력하기">
	</form>
</body>
</html>