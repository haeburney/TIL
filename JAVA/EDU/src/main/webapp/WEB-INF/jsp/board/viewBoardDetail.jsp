<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<jsp:include page="/WEB-INF/jsp/board/header.jsp" />
	</div>
	<br />
	<c:if test="${boardpost ne null }">
		<table>
			<tr>
				<td>ID</td>
				<td>${boardpost.id }</td>
			</tr>
			<tr>
				<td>SUBJECT</td>
				<td>${boardpost.subject }</td>
			</tr>
			<tr>
				<td>CONTENT</td>
				<td>${boardpost.content }</td>
			</tr>
			<tr>
				<td>NAME</td>
				<td>${boardpost.creator.fullName }${boardpost.creator.id}</td>
			</tr>
			<tr>
				<td>DATE</td>
				<td>${boardpost.createDate }</td>
			</tr>
		</table>
	</c:if>

	<c:if test="${isAdmin}">
		<button onclick=deleteBoardPost(${boardpost.id})>삭제</button>
	</c:if>

	<script>
		let boardId = ${boardpost.board.id};
		let boardPostId = ${boardpost.id};
		let userId = ${boardpost.creator.id};
		console.log(boardId);
		console.log(boardPostId);
		console.log(userId);
		
		window.onload = function(){
			let boardId = ${boardpost.board.id};
			console.log(boardId);
			
			document.getElementById("${boardpost.board.id}").style.fontWeight = "bold";
		}
		function deleteBoardPost(num){
			console.log(num+"삭제");
			
			if(confirm("삭제하시겠습니까?")){
				window.location.href = "deleteBoardPost?board="+boardId+"&&id="+boardPostId+"&&userId="+userId;				
			} else{
				alert("삭제 안 함");
			}
		}
	</script>
</body>
</html>