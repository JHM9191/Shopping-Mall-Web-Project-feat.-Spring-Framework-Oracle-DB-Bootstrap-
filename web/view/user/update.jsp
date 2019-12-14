<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<style></style>
<script>
$(document).ready(function(){});
</script>
</head>
<body>
<h1>User Update Page</h1>
<form action="updateimpl" method="post">
<input type="hidden" name="id" value="${u.id}">
ID: ${u.id}<br>
PWD<input type="text" name="pwd" value="${u.pwd}"><br> <!-- value는 값을 뿌려주기 위해서 -->
NAME<input type="text" name="name" value="${u.name}"><br>
TEL<input type="text" name="tel" value="${u.tel}"><br>
GENDER<input type="text" name="gender" value="${u.gender}"><br>
AGE<input type="text" name="age" value="${u.age}"><br>
EMAIL<input type="text" name="email" value="${u.email}"><br>
ADDERESS<input type="text" name="address" value="${u.address}"><br>

<input type="submit" value="update">
</form>
<!-- id는 수정불가 -->
<!-- form방식:화면에  보여주기 -->
</body>
</html>