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
			<img alt="이미지" src="${img}" style="max-width: 300px; height: auto;">
		</c:forEach>
	</c:if>
	
	<hr>
	<h3>댓글</h3>
	<c:forEach var="comment" items="${commentList}">
		<div style="margin-left: ${comment.humor_com_indent*20}px">
			<b>${comment.user_nickname}</b> (${comment.humor_com_date})<br>
			${comment.humor_com_contents}<br>
			<!-- 대댓글 버튼 -->
			<form action="/humorBoard/commentReply" method="post" 
			style="display:inline">
				<input type="hidden" name="humor_idx" value="${dto.humor_idx}">
				<input type="hidden" name="humor_com_root" 
				value="${comment.humor_com_root==null?comment.humor_com_idx:comment.humor_com_root}">
				<input type="hidden" name="humor_com_step" value="${comment.humor_com_step}">
				<input type="hidden" name="humor_com_indent" value="${comment.humor_com_indent}">
				<input type="text" name="humor_com_contents" placeholder="답글 입력...">
				<input type="submit" value="답글">				
			</form>
			<!-- 댓글 삭제/수정 버튼 -->
			<form action="/humorBoard/commentDelete" method="post" style="display:inline">
				<input type="hidden" name="humor_com_idx" value="${comment.humor_com_idx}">
				<input type="hidden" name="humor_idx" value="${dto.humor_idx}">
				<input type="submit" value="삭제">
			</form>
			<form action="/humorBoard/commentUpdate" method="post" style="display:inline">
				<input type="hidden" name="humor_com_idx" value="${comment.humor_com_idx}">
				<input type="hidden" name="humor_idx" value="${dto.humor_idx}">
				<input type="text" name="humor_com_contents" value="${comment.humor_com_contents}">
				<input type="submit" value="수정">
			</form>
		</div>
	</c:forEach>
	
	<h4>댓글 작성</h4>
	<form action="/humorBoard/commentInsert" method="post">
		<input type="hidden" name="humor_idx" value="${dto.humor_idx}">
		<input type="hidden" name="humor_com_root" value="0">
		<input type="hidden" name="humor_com_step" value="0">
		<input type="hidden" name="humor_com_indent" value="0">
		<textarea name="humor_com_contents" rows="3" cols="50"></textarea>
		<input type="submit" value="댓글 등록">
	</form>
</body>
</html>