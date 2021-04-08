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
    <title>Tuesday | Music</title>
  </head>
  <body>
    <header class="header">
      <div>
        <h1>글 수정</h1>
        <div>
        </div>
      </div>
    </header>

    <main class="musicAdd">
    
      <div class="musicAdd__createForm">
        
        <form action="/board?cmd=ContentUpdate" method="POST" id="musicAddForm">
          
          <input type="text" name="songNum" id="songNum" value="${musicVo.songNum}" hidden readonly />
          
          <table>
            <tr>
              <th>장르</th>
              
              <td>
                <select name="genreId" form="musicAddForm">
                	<c:forEach var="genre" items="${genreList}">
                  	
                  	<option value="${genre.genreId}">
                    	${genre.genreName}
                  	</option>
                  	
                  	</c:forEach>
                </select>
              </td>
            </tr>

            <tr>
              <th>제목</th>
              <td>
                <input
                  type="text"
                  name="title"
                  id="title"
                  required
                  placeholder="게시물 제목"
                  value="${musicVo.title }"
                />
              </td>
            </tr>

            <tr>
              <th>링크주소</th>
              <td>
                <input
                  type="text"
                  name="linkAddress"
                  id="linkAddress"
                  required
                  placeholder="https://www.youtube.com/embed/..."
                  value="${musicVo.linkAddress }"
                />
                <div>
                  <ol>
                    <li>
                      1. 컴퓨터에서 퍼가려는 YouTube 동영상으로 이동합니다.
                    </li>
                    <li>2. 동영상 아래의 공유 공유를 클릭합니다.</li>
                    <li>3. 퍼가기를 클릭합니다.</li>
                    <li>4. 표시되는 상자에서 HTML 코드를 복사합니다.</li>
                    <li>
                      5. 이 코드를 블로그 또는 웹사이트 HTML에 붙여넣습니다.
                    </li>
                  </ol>
                </div>
              </td>
            </tr>

            <tr>
              <th>앨범</th>
              <td>
                <input
                  type="text"
                  name="albumName"
                  id="albumName"
                  placeholder="앨범명"
                  value="${musicVo.albumName }"
                />
              </td>
            </tr>

            <tr>
              <th>곡명</th>
              <td>
                <input
                  type="text"
                  name="songName"
                  id="songName"
                  placeholder="노래제목"
                  value="${musicVo.songName }"
                />
              </td>
            </tr>

            <tr>
              <th>가수</th>
              <td>
                <input
                  type="text"
                  name="singer"
                  id="singer"
                  placeholder="가수이름"
                  value="${musicVo.singer }"
                />
              </td>
            </tr>

            <tr>
              <th>가사</th>
              <td>
                <textarea
                  name="lyrics"
                  id="lyrics"
                  placeholder="가사양식: <p>첫번째 줄<p> <p>두번째 줄<p>"
                >${musicVo.lyrics }</textarea>
              </td>
            </tr>

            <tr>
              <td colspan="2">
                <input type="submit" value="게시물 수정" />
              </td>
            </tr>
          </table>
        
        </form>
      </div>
    </main>
  </body>
</html>
