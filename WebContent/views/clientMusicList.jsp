<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/resources/css/style.css" />
    <title>Tuesday & Music</title>
  </head>
  <body>
    <header class="header">
      <div>
        <h1>Tuesday Music Board</h1>
      </div>
    </header>
    
    <main class="musicList">
    
        <nav class="genre-bar">
          <c:forEach var="genre" items="${genreList}">
          <div>
          	<a href="/board?cmd=ClientMusicList&genreId=${genre.genreId }">
          		${genre.genreName}
          	</a>
          </div>
          </c:forEach>
        </nav>
		
		<div class="musicList__buttons">
			<div>
				<a href="/board?cmd=ContentAddForm&tag=client">새글쓰기</a>
			</div>
			<div>
				<a href="/board?cmd=Home">홈화면으로</a>
			</div>
		</div>
		
        <table>
          <tr>
            <th>INDEX</th>
            <th>TITLE</th>
            <th>ALBUM</th>
            <th>SINGER</th>
            <th>RegisterDate</th>
          </tr>
          <c:forEach var="music" items="${musicList}">
            <tr>
              <td>${music.songNum }</td>
              <td>
              	<a href="/board?cmd=ContentView&songNum=${music.songNum }&tag=client">
              		${music.title }
              	</a>
              </td>
              <td>${music.albumName }</td>
              <td>${music.singer }</td>
              <td>${music.registerDate }</td>
            </tr>
          </c:forEach>
        </table>
      
    </main>
  </body>
</html>
