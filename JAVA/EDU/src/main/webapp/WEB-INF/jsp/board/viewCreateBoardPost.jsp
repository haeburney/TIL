<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.f {
	margin-top: 10px;
	margin-bottom: 10px;
}

input {
	width: 200px;
}

textarea {
	width: 200px;
}
</style>
</head>
<body>
	<div>
		<jsp:include page="/WEB-INF/jsp/board/header.jsp" />
	</div>
	${user } ${board}
	<br /> 일단 자유게시판으로 등록 2
	<br />
	<form name="mainForm" method="post" action="createBoardPost">
		<div class="f">
			제목 <input type="text" name="title" placeholder="제목 입력" />
		</div>
		<div class="f">
			내용
			<textarea name="content"></textarea>
		</div>
		<div class="f">
			제목 <input type="button" value="등록" onclick="createBoardPost()">
		</div>
		<c:if test="${user ne null}">
			<input type="hidden" name="creatorId" value="${user.id }">
		</c:if>
		<input type="hidden" name="boardId" value="2">
		<c:if test="${board ne null }">
			<input type="hidden" name="boardId" value="${board.id }">
		</c:if>
	</form>

	<script>
		function createBoardPost() {
			let title = document.mainForm.title.value;
			let content = document.mainForm.content.value;

			if (title == null || title == "") {
				alert("제목을 입력하세요");
			} else if (content == null || content == "") {
				alert("내용을 입력하세요");
			} else {
				document.mainForm.submit();
			}
		}
	</script>
</body>
</html>