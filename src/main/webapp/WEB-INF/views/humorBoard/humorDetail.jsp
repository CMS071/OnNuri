<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 자세히 보기</title>
</head>
<body>
	<h2>게시글 상세보기</h2>
	<p>제목: ${dto.humor_title}</p>
	<p>작성자: ${dto.user_nickname}</p>
	<p>작성일: ${dto.humor_date}</p>
	<p>조회수: ${dto.humor_cnt}</p>
	<p>내용: ${dto.humor_contents}</p>
	<c:if test="${not empty dto.humor_img}">
		<c:forEach var="img" items="${dto.humor_img.split(',')}">
			<img alt="이미지" src="${img}">
		</c:forEach>
	</c:if>
</body>
</html>