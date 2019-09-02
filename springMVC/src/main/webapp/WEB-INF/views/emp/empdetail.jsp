<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="background-color: yellow">직원 정보조회</h1>
	<form action="empdetail" method="post">
	직원번호: <input type="number" name="employee_id" value="${emp.employee_id }"><br>
	<br>
	직원이름: <input type="text" name="first_name" value="${emp.first_name}"><br>
	직원성: <input type="text" name="last_name" value="${emp.last_name}"><br>
	이메일: <input type="text" name="email" value="${emp.email}"><br>
	전화번호: <input type="text" name="phone_number" value="${emp.phone_number}"><br>
	입사일: <input type="text" name="hire_date" value="${emp.hire_date}"><br>
	직급: 
	<select name="job_id">
		<c:forEach items="${joblist}" var="job">
				<option ${emp.job_id==job?"selected":""}>${job}</option>
		</c:forEach>
	</select>
			<br>
	급여: <input type="text" name="salary" value="${emp.salary}"><br>
	커미션: <input type="text" name="commission_pct" value="${emp.commission_pct}"><br>
	상사 직원번호: <input type="text" name="manager_id" value="${emp.manager_id}"><br>
	부서:   <select name="department_id2">
				<c:forEach items="${deptlist}" var="dept">
					<c:if test="${emp.department_id==dept.dept_id}">
						<option selected value="${dept.dept_id}">${dept.deptname} </option>
					</c:if>
					<c:if test="${emp.department_id!=dept.dept_id}">
						<option value="${dept.dept_id}">${dept.deptname} </option>
					</c:if>
				</c:forEach>
			</select>
			<br>
	
	
	
	
	
	<input type="submit" value="수정하기">
	</form>

</body>
</html>