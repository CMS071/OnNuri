<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form name="member" method="post" action="/user/signUpProcess">
            <h3>회원가입</h3>
              <input type="text" name="user_id" id="user_id" placeholder="아이디">
              <button type="button" class="dup-check" onclick="checkDuplicateId()">중복 확인</button>
              <input type="password" name="user_passwd" id="user_passwd" placeholder="비밀번호">
              <input type="password" name="passwdconfirm" id="passwdconfirm" placeholder="비밀번호 확인">
              <input type="text" name="user_name" id="user_name" placeholder="이름">
              <input type="text" name="user_nickname" id="user_nickname" placeholder="닉네임">
              <button type="button" class="dup-check" onclick="checkDuplicateNickname()">중복 확인</button>
              <input type="text" name="roadAddrPart1" id="roadAddrPart1" placeholder="주소" readonly>
              <button type="button" class="dup-check" onclick="goPopup()">주소검색</button>
              <input type="text" name="addrDetail" id="addrDetail" placeholder="상세주소" readonly>
              <input type="text" name="zipNo" id="zipNo" placeholder="우편번호" readonly>
              <input type="email" name="user_email" id="user_email" placeholder="이메일">
              <button type="button" >중복 확인</button>
              <input type="text" name="user_tel" id="user_tel" placeholder="연락처">
              <button type="button">회원가입</button>
              <button type="reset">취소</button>
    </form>
</body>
</html>