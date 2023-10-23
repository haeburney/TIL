<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th, tr, td {
	border: 1px solid black;
}

table {
	width: 80%;
	border-collapse: collapse;
}

.boardTitle {
	cursor: pointer;
}
</style>
</head>
<body>
	<div>
		<jsp:include page="/WEB-INF/jsp/board/header.jsp" />
	</div>

	${user }
	<br /> ${board }


	<form name="searchForm" action="viewBoardPosts">
		<input type="text" name="subject" /> <input type="button" value="검색"
			onclick="searchBoardPosts()" />
	</form>
	<br />

	<table>
		<tr>
			<th>ID</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
		<c:if test="${ boardPosts ne null}">
			<c:forEach var="item" items="${boardPosts }">
				<tr>
					<td>${item.id }</td>
					<td><a
						href="viewBoardDetail?id=${item.id }&boardId=${item.board.id}&userId=${item.creator.id}">${item.subject }</a></td>
					<td>${item.content }</td>
					<td>${item.creator.fullName }</td>
					<td>${fn:substring(item.createDate, 0, 10)}</td>
					<td>${item.board.title}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<br />

	<a href="viewCreateBoardPost">게시물 작성</a>



	<script>
		function searchBoardPosts() {
			document.searchForm.submit();
		}

		let notice = document.getElementById("1");
		let free = document.getElementById("2");

		notice.addEventListener("click", function() {
			console.log("공지사항 클릭");
			window.location.href = "viewBoardPosts?boardId=1";
		});
		free.addEventListener("click", function() {
			console.log("자유게시판 클릭");
			window.location.href = "viewBoardPosts?boardId=2";
		});

		let boardId = "" + $
		{
			board.id
		};

		if (boardId != "") {
			document.getElementById("${board.id}").style.fontWeight = "bold";
		}
	</script>
</body>
</html>