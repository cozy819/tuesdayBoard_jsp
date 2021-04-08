<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="/resources/css/style.css" />
<title>Tuesday | AccountUpdate</title>
</head>
<body>
	<header class="header">
		<div>
			<h1>관리자 - 장르 정보 수정</h1>
		</div>
	</header>

	<main class="genreUpdateForm">
	<form action="/board?cmd=GenreUpdate" method="POST">
		<table>
			<tr>
				<th>장르ID</th>
				<td>
					<input type="text" name="genreId" value="${genreVo.genreId}" readonly />
				</td>
			</tr>

			<tr>
				<th>장르이름</th>
				<td>
					<input type="text" name="genreName" value="${genreVo.genreName}" />
				</td>
			</tr>

			<tr>
				<th>순서</th>
				<td>
					<input type="text" name="genreSeq" value="${genreVo.genreSeq}" readonly />
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
