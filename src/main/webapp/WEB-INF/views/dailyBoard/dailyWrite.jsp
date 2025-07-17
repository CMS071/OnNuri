<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<h2>일상 게시글 작성</h2>
	<form method="post" action="/dailyBoard/writeProcess" enctype="multipart/form-data">
		<p>
			<label>제목 : </label>
			<input type="text" name="daily_title">
		</p>
		<p>
			<label>내용 : </label>
			<textarea name="daily_contents" rows="10" cols="50"></textarea>
		</p>	
		<p>
			<label>이미지 업로드:</label>
			<input type="file" name="daily_img" multiple accept="image/*">
		</p>
		<p>
			<button type="submit">등록</button>
			<button type="reset">초기화</button>
		</p>	
	</form>
</body>
</html>

