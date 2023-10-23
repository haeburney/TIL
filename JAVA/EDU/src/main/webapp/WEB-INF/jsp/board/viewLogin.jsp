<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form name="mainForm" method="post" action="login">
		<div>
			userName <input type="text" name="userName" />
		</div>
		<div>
			userPassword <input type="text" name="userPassword" />
		</div>
		<div>
			<input type="button" onclick="login()" value="로그인">
		</div>
	</form>

	<script>
		function login() {
			let id = document.mainForm.userName.value;
			let password = document.mainForm.userPassword.value;

			if (id == null || id == "") {
				alert("userName을 입력해주세요");
			} else if (password == null || password == "") {
				alert("userPassword를 입력해주세요");
			} else {
				document.mainForm.submit();
			}
		}
	</script>
</body>
</html>