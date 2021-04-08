<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="resources/css/style.css" />
<title>Tuesday | AccountUpdate</title>
</head>
<body>
	<header class="header">
		<div>
			<h1>관리자 - 회원정보 수정</h1>
		</div>
	</header>

	<main class="accountUpdateForm">
	<form action="/board?cmd=AccountUpdate" method="POST">
		<table>
			<tr>
				<th>순번</th>
				<td>
					<input type="text" name="indexNum" value="${clientVo.indexNum}" readonly />
				</td>
			</tr>

			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="clientId" value="${clientVo.clientId}" readonly />
				</td>
			</tr>

			<tr>
				<th>비밀번호</th>
				<td>
					<input type="text" name="clientPassword" value="${clientVo.clientPassword}" />
				</td>
			</tr>

			<tr>
				<th>이메일</th>
				<td>
					<input type="text" name="clientEmail" value="${clientVo.clientEmail}" />
				</td>
			</tr>

			<tr>
				<th>등록일</th>
				<td>
					<input type="text" name="registerDate" value="${clientVo.registerDate}" readonly />
				</td>
			</tr>

			<tr>
				<td colspan="2" class="center">
					<input type="submit" value="수정" />
				</td>
			</tr>
		</table>
	</form>
	</main>
</body>
</html>
