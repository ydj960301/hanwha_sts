<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>부서의 추가하기</h1>
	<form action="deptinsert" method="post" enctype="multipart/form-data">
	부서번호: <input type="number" name="dept_id" ><br>
	부서이름: <input type="text" name="deptname" ><br>
	사진 <input type="file" name="uploadfile" ><br>
	<input type="submit" value="입력하기">
	</form>

</body>
</html>