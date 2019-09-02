<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>
</head>
<body>
<h1>회사명: ${company}</h1>
<h1>이름: ${name}</h1>

<form action="para">
id: <input name="userid" type="text"> <br>
name: <input name="username" type="text"> <br>
pw: <input name="pw" type="number">
<input type="submit" value="전송">
</form>
<hr>
<form action="para2">
id: <input name="userid" type="text"> <br>
name: <input name="username" type="text"> <br>
pw: <input name="pw" type="number">
<input type="submit" value="전송">
</form>

</body>
</html>