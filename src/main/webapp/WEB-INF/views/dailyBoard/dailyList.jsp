<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<h2>게시글 목록</h2>
	
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
		</tr>
		
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.daily_idx}</td>
				<td><a href="/dailyBoard/detail?daily_idx=${dto.daily_idx}">
					${dto.daily_title}</a></td>
				<td>${dto.user_nickname}</td>			
			</tr>
		</c:forEach>
	</table>
	
	<a href="/dailyBoard/write">글쓰기</a>
</body>
</html>