<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/resources/css/style.css" />
    <title>Tuesday | Music</title>
  </head>
  <body>
    <header class="header">
      <div>
        <h1>관리자 - 음악 상세 보기</h1>
        <div>
        	<a href="/board?cmd=ContentUpdateForm&songNum=${musicVo.songNum }">수정</a>
      		<a href="/board?cmd=ContentDelete&songNum=${musicVo.songNum }&genreId=${musicVo.genreId}">삭제</a>
      		<a href="/board?cmd=AdminMusicList&genreId=${musicVo.genreId }">관리자 화면으로</a>
      	</div>
      </div>
    </header>

    <main class="musicView">
      
      <div class="musicView__video">
        <iframe
          src="${musicVo.linkAddress }"
          title="YouTube video player"
          frameborder="0"
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
          allowfullscreen
        ></iframe>
      </div>
      <div class="musicView__songInfo">
        <div>${musicVo.singer} - ${musicVo.albumName}</div>
        <div>${musicVo.songName}</div>
      </div>

      <div class="musicView__lyrics">
        ${musicVo.lyrics}
      </div>
    </main>

    <footer class="repls">
      <div class="repls__list">
      	<c:forEach var="repl" items="${replList}">
        <div class="repl">
          <div>${repl.replWriter}</div>
          <div>${repl.registerDate}</div>
          <div>${repl.replContent}</div>
          <div>
            <a href="/board?cmd=ReplUpdateForm&replNum=${repl.replNum}&songNum=${musicVo.songNum}">수정</a>
            <a href="/board?cmd=ReplDelete&replNum=${repl.replNum}&songNum=${musicVo.songNum}">삭제</a>
          </div>
        </div>
        </c:forEach>
      </div>

      <div class="repls__add">
        <form action="/board?cmd=ReplAdd&songNum=${musicVo.songNum}&tag=admin" method="POST">
          <input type="text" name="songNum" value="${musicVo.songNum}" hidden />
          <input
            type="text"
            name="replWriter"
            id="replWriter"
            placeholder="작성자"
            required
          />
          <br />
          <input
            type="text"
            name="replContent"
            id="replContent"
            placeholder="내용"
            required
          />
          <input type="submit" value="댓글달기" />
        </form>
      </div>
    </footer>
  </body>
</html>
