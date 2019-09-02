<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서의 상세보기</h1>
	<form action="deptdetail?/" method="post">
	부서번호: <input type="number" name="dept_id" value="${dept.dept_id }"><br>
	부서이름: <input type="text" name="deptname" value="${dept.deptname}"><br>
	<img alt="이미지" src="${path}/resources/${dept.fileName}">
	<br>
<img alt="이미지" src="${path}/resources/EBWgvFpUwAA54-Q.jpg"> 
	<a href="deptdownload?folder=resources&file=${dept.fileName}">이미지 다운해용~</a>
	<input type="submit" value="수정하기">
	</form>

</body>
</html>