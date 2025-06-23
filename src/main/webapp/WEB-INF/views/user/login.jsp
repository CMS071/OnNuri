<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<form method="post" action="/loginProcess">
      <h3>로그인</h3>
        <p><input type="text" name="username" placeholder="아이디" required></p>
        <p><input type="password" name="password" placeholder="비밀번호" required></p>
       <p><button type="submit">로그인</button></p>
       <a href="/user/signUpForm"><b>아직 계정이 없으신가요? 회원가입</b></a>
     </form>
</body>
</html>