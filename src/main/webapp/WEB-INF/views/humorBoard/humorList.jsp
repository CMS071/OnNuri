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
	<h2>유머 게시판</h2>
	<table border="1">
	  <tr>	
	  	<th>제목</th> 
		<th>작성자</th>
	  </tr>
	  <c:forEach var="dto" items="${list}">
	  	<tr>
			<td><a href="/humor/detail?humor_idx=${dto.humor_idx}">${dto.humor_title}</a></td>
			<td>${dto.user_nickname}</td>	  	
	  	</tr>
	  </c:forEach>	
	</table>
	
	<p><a href="/humor/write">글쓰기</a></p>
</body>
</html>