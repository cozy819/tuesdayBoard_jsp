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
        <h1>관리자 - 댓글 수정</h1>
        <div>
      		<a href="/board?cmd=ContentView&tag=admin&songNum=${replVo.songNum }">이전화면으로</a>
      	</div>
      </div>
    </header>

    <footer class="repls">

      <div class="repls__add">
        <form action="/board?cmd=ReplUpdate&replNum=${replVo.replNum}" method="POST">
          <input type="text" name="songNum" value="${replVo.songNum}" hidden readonly/>
          <input type="text" name="replNum" value="${replVo.replNum}" hidden readonly/>
          <input
            type="text"
            name="replWriter"
            id="replWriter"
            placeholder="작성자"
            required
            value="${replVo.replWriter }"
          />
          <br />
          <input
            type="text"
            name="replContent"
            id="replContent"
            placeholder="내용"
            required
            value="${replVo.replContent }"
          />
          <input type="submit" value="댓글수정" />
        </form>
      </div>
    </footer>
  </body>
</html>
