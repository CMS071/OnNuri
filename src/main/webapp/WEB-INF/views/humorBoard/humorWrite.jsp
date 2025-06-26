<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
	<h2>게시글 작성</h2>
	<form method="post" action="/humor/humorWriteProcess" enctype="multipart/form-data" >
		<p>
			<label>제목 : </label>
			<input type="text" name="humor_title" required />
		</p>
		<p>
			<label>내용: </label><br>
			<textarea name="humor_contents" rows="10" cols="50"></textarea>
		</p>
		<p>
			<label>이미지 업로드: </label>
			<input type="file" name="humor_img" multiple accept="image/*">
		</p>
		<p>
			<button type="submit">등록</button>
		</p>
	</form>
</body>
</html>