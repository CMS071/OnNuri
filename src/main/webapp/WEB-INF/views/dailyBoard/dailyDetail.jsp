<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일상 게시글 상세보기</title>
</head>
<body>
	<h2>일상 게시글 상세보기</h2>
	<p>제목: ${dto.daily_title} </p>
	<p>작성자: ${dto.user_nickname}</p>
	<p>작성일: ${dto.daily_date}</p>
	<p>조회수: ${dto.daily_cnt}</p>
	<p>내용: ${dto.daily_contents}</p>
	<c:if test="${not empty dto.daily_img}">
		<c:forEach var="img" items="${dto.daily_img.split(',')}">
			<img alt="이미지" src="${img}" style="max-width: 300px; height: auto;">
		</c:forEach>
	</c:if>
</body>
</html>