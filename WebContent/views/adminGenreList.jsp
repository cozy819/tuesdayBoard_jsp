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
    <title>Tuesday | 관리자</title>
  </head>
  <body>
    <header class="header">
      <div>
        <h1>관리자 - 장르관리</h1>
      </div>
    </header>
    <main class="adminList">
      <aside class="admin-aside">
        <div>
          <a href="/board?cmd=AdminAccountList">회원관리</a>
        </div>
        <div>
          <a href="/board?cmd=AdminGenreList">장르관리</a>
        </div>
        <div>
          <a href="/board?cmd=AdminMusicList&genreId=genre01">게시물관리</a>
        </div>
        <div>
          <a href="/board?cmd=Home">홈으로</a>
        </div>
      </aside>

      <article class="genreList">
        <div>
          <a href="/board?cmd=GenreCreateForm">추가</a>
        </div>
        <table>
          <tr>
            <th>GenreId</th>
            <th>GenreName</th>
            <th>GenreSeq</th>
            <th>Button</th>
          </tr>
          <c:forEach var="genre" items="${genreList}">
            <tr>
              <td>${genre.genreId }</td>
              <td>${genre.genreName }</td>
              <td>${genre.genreSeq }</td>
              <td>
                <a href="/board?cmd=GenreDelete&genreId=${genre.genreId}">
                  삭제
                </a>
                <a href="/board?cmd=GenreUpdateForm&genreId=${genre.genreId}">
                  수정
                </a>
              </td>
            </tr>
          </c:forEach>
        </table>
      </article>
    </main>
  </body>
</html>
