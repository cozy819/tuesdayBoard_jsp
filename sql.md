--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==
create table admin_account
(
indexNum number(5,0) primary key,
adminId varchar2(30) unique,
adminPassword varchar2(30) not null,
registerDate date default sysdate,
tag varchar2(30) default 'admin'
);

drop table admin_account;

insert into admin_account(indexNum, adminId, adminPassword)
VALUES (
(select nvl(max(indexNum), 0) + 1 from admin_account),
'admin',
'admin'
);

commit;

--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==
create table client_account(
indexNum number(5,0) primary key,
clientId varchar2(30) unique,
clientPassword varchar2(30) not null,
clientEmail varchar2(100),
registerDate date default sysdate,
tag varchar2(30) default 'client'
);

insert into client_account (indexNum, clientId, clientPassword, clientEmail)
VALUES (
(select nvl(max(indexNum), 0) + 1 from client_account),
'client01',
'client01',
'client01@tuesday.com'
);
insert into client_account (indexNum, clientId, clientPassword, clientEmail)
VALUES (
(select nvl(max(indexNum), 0) + 1 from client_account),
'client02',
'client02',
'client02@tuesday.com'
);
insert into client_account (indexNum, clientId, clientPassword, clientEmail)
VALUES (
(select nvl(max(indexNum), 0) + 1 from client_account),
'client03',
'client03',
'client03@tuesday.com'
);
insert into client_account (indexNum, clientId, clientPassword, clientEmail)
VALUES (
(select nvl(max(indexNum), 0) + 1 from client_account),
'client04',
'client04',
'client04@tuesday.com'
);
insert into client_account (indexNum, clientId, clientPassword, clientEmail)
VALUES (
(select nvl(max(indexNum), 0) + 1 from client_account),
'client05',
'client05',
'client05@tuesday.com'
);

commit;

--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==
create table genres(
genreId varchar2(30) primary key ,
genreName varchar2(30) unique,
genreSeq number(5,0)
);

drop table genres;

insert into genres (genreId, genreName, genreSeq)
VALUES (
(
select 'genre' || TRIM( TO_CHAR( TO_NUMBER( SUBSTR( NVL( MAX(genreId), 'genre00'), 6, 2) ) + 1, '00' ) )
from genres
),
'발라드',
(select nvl(max(genreSeq), 0) + 1 from genres)
);
insert into genres (genreId, genreName, genreSeq)
VALUES (
(
select 'genre' || TRIM( TO_CHAR( TO_NUMBER( SUBSTR( NVL( MAX(genreId), 'genre00'), 6, 2) ) + 1, '00' ) )
from genres
),
'댄스',
(select nvl(max(genreSeq), 0) + 1 from genres)
);
insert into genres (genreId, genreName, genreSeq)
VALUES (
(
select 'genre' || TRIM( TO_CHAR( TO_NUMBER( SUBSTR( NVL( MAX(genreId), 'genre00'), 6, 2) ) + 1, '00' ) )
from genres
),
'힙합',
(select nvl(max(genreSeq), 0) + 1 from genres)
);
insert into genres (genreId, genreName, genreSeq)
VALUES (
(
select 'genre' || TRIM( TO_CHAR( TO_NUMBER( SUBSTR( NVL( MAX(genreId), 'genre00'), 6, 2) ) + 1, '00' ) )
from genres
),
'락',
(select nvl(max(genreSeq), 0) + 1 from genres)
);
insert into genres (genreId, genreName, genreSeq)
VALUES (
(
select 'genre' || TRIM( TO_CHAR( TO_NUMBER( SUBSTR( NVL( MAX(genreId), 'genre00'), 6, 2) ) + 1, '00' ) )
from genres
),
'트로트',
(select nvl(max(genreSeq), 0) + 1 from genres)
);

commit;

--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==
create table boardContent (
songNum number(5,0) primary key,
genreId varchar2(30) not null,
title varchar2(300) not null,
linkAddress varchar2(3000) not null,
albumName varchar2(3000),
songName varchar2(3000),
singer varchar2(3000),
lyrics varchar2(3000),
registerDate date default sysdate,
CONSTRAINT FK_genres_genreId
FOREIGN KEY (genreId)
REFERENCES genres (genreId)
);

drop table boardContent;

INSERT INTO boardContent (songNum, genreId, title, linkAddress, albumName, songName, singer, lyrics)
VALUES (
(select nvl(max(songNum), 0) + 1 from boardContent),
'genre01',
'포지션 - 하루',
'https://www.youtube.com/embed/bartnrMbUZI',
'애가',
'하루',
'포지션',
'<p>아직 그대는 오지 않고 또 하루가 지네요</p>
<p>마중나간 나의 마음은 또 혼자 돌아와요</p>
<p>눈물에 번진 구름같은 노을빛이 내리면</p>
<p>술 생각처럼 떠 오르는 그대 얼굴 그대 향기</p>
<br />
<p>그댄 왜 나를 사랑했나요 이렇게 나를 울게 하나요</p>
<p>사랑이 슬픔인 걸 그때 알았더라면 그대를 그냥 지나쳤을까</p>
<br />
<p>안보려고 눈 감아봐도 추억이 또 보여요</p>
<p>잃어버릴까 걱정하듯 처음부터 그 끝까지</p>
<br />
<p>귓볼을 입술로 간지르며 소리내 웃다 그대가 울죠</p>
<p>그 눈빛이 서러워 매번 놀라 잠깨면 베게를 적신 내 눈물만</p>
<p>그렇게 아름다운 사람을 사랑 안하곤 버틸힘 없죠</p>
<p>천번 그날이 와도 나는 같았을테니 만난걸 미안해하지 말아요</p>
<br />
<p>하루 또 하루 버텨내도 그댄 오지않네요</p>
<p>울고 싶을때 울어보면 그댄 내가 미울까요</p>
<br />
<p>그댄 왜 나를 사랑했나요 이렇게 나를 울게 하나요</p>
<p>사랑이 슬픔인 걸 그때 알았더라면 그대를 지나쳐갔을까</p>
<p>그렇게 아름다운 사람을 사랑 안하곤 버틸 힘 없죠</p>
<p>천번 그날이 와도 나는 같았을테니 만난 걸 미안해하지 말아요</p>
<br />
<p>그리워 지친 날 달래듯 아침은 또 오네요</p>
<p>울 수 없으니 웃어야죠 밤새</p>'
);

INSERT INTO boardContent (songNum, genreId, title, linkAddress, albumName, songName, singer, lyrics)
VALUES (
(select nvl(max(songNum), 0) + 1 from boardContent),
'genre02',
'레드벨벳 - 빨간 맛',
'https://www.youtube.com/embed/Yb0nyLIfqf8',
'The Red Summer',
'빨간 맛',
'레드벨벳',
'<p>빨간 맛 궁금해 Honey</p>
<p>깨물면 점점 녹아든 스트로베리 그 맛</p>
<p>코너 캔디 샵 찾아 봐 Baby</p>
<p>내가 제일 좋아하는 건 여름 그 맛</p>
<br />
<p>야자나무 그늘 아래 졸고 싶고</p>
<p>뜨거운 여름밤의 바람은 불고</p>
<p>너무 쉽게 사랑 빠져 버릴 나인틴</p>
<p>우린 제법 어울리고 또 멋져</p>
<br />
<p>좋아 첫눈에 반해 버린</p>
<p>네가 자꾸만 생각나</p>
<p>내 방식대로 갈래</p>
<br />
<p>빨간 맛 궁금해 Honey</p>
<p>깨물면 점점 녹아든 스트로베리 그 맛</p>
<p>코너 캔디 샵 찾아 봐 Baby</p>
<p>내가 제일 좋아하는 건 여름 그 맛</p>
<br />
<p>일곱 개의 무지갯빛 문을 열어</p>
<p>너의 세상은 짜릿해 멋있어</p>
<p>태양보다 빨간 네 사랑의 색깔</p>
<p>내가 가질래 내 멋대로 할래</p>
<br />
<p>날 봐 넌 뭘 생각하는데</p>
<p>오늘 뭘 할 수 있을까</p>
<p>내 맘대로 상상해</p>
<br />
<p>빨간 맛 궁금해 Honey</p>
<p>깨물면 점점 녹아든 스트로베리 그 맛</p>
<p>코너 캔디 샵 찾아 봐 Baby</p>
<p>내가 제일 좋아하는 건 여름 그 맛</p>
<br />
<p>복숭아 주스 스윗 앤 사워 믹스 Mood</p>
<p>네게 주고픈 칵테일을 Brew RED</p>
<p>귓속이 쨍 코가 맹</p>
<p>상상 그 이상 기분 Up and bang RED</p>
<p>Bet you wanna</p>
<p>Bet you wanna dance like this</p>
<p>외쳐보자 좋아해요 솔직히</p>
<p>긴장해 땀이 뚝뚝 귀엽지</p>
<p>사랑에 빠져 그을려 우린 RED RED Ah</p>
<br />
<p>말 안 해도 알아주면 안 돼</p>
<p>내 맘은 더 커져 가는데</p>
<p>다 흘려버린 아이스크림같이</p>
<p>이러다 녹을지 몰라</p>
<p>그러니 말해 그래 그래 말해</p>
<p>그러니 말해 그래 그래 말해</p>
<p>너의 색깔로</p>
<p>날 물들여줘 더 진하게 강렬하게</p>
<br />
<p>빨간 맛 궁금해 Honey</p>
<p>깨물면 점점 녹아든 스트로베리 그 맛</p>
<p>코너 캔디 샵 찾아 봐 Baby</p>
<p>내가 제일 좋아하는 건 여름 그 맛</p>
<p>내가 제일 좋아하는 건 여름의 너</p>'
);

INSERT INTO boardContent (songNum, genreId, title, linkAddress, albumName, songName, singer, lyrics)
VALUES (
(select nvl(max(songNum), 0) + 1 from boardContent),
'genre03',
'창모 - METEOR', 'https://www.youtube.com/embed/lOrU0MH0bMk',
'Boyhood',
'METEOR',
'창모',
'<p>모두 그에게 말해 또 왔네 (새꺄 whut?)</p>
<p>죽지 않고 왔다 이렇게 (새꺄 뭐?)</p>
<p>Snacky chan의 라인을 빌릴래</p>
<p>했어 예수처럼 이렇게 부활을</p>
<p>031 팔 안쪽의 tatt freaky woah</p>
<p>어젠 시장님이 만나쟤 motown</p>
<p>어수룩해 엄마 속에 걱정</p>
<p>한 톤만큼 쌓고 스물한살에 독립했던 얘는</p>
<p>여섯이 되었고</p>
<p>발견했지 우연히 5년 전의 노트</p>
<p>“정말 스타 되고 싶어</p>
<p>그럴려면 가서 만나면 돼 악마?”</p>
<p>노트를 덮고</p>
<p>거울에 비춰진 남자를 보니 와</p>
<p>저 손목이 너무 부러워</p>
<p>저 금 daydate rollie 넘을걸 천백은 더</p>
<br />
<p>전국</p>
<p>사람들이 외치네</p>
<p>저 괴물체는 뭘까?</p>
<p>Meteor</p>
<p>거대 Meteor</p>
<p>난 네게 처박힐 Meteor야</p>
<br />
<p>별빛이 내려오지 마구</p>
<p>내려오지</p>
<p>경고 </p>
<p>경고</p>
<p>그래도 처박힐 Meteor야</p>
<br />
<p>motown의 1번 노랠 기억해 니들?</p>
<p>뭐였지? 뭐였나? 음 음?</p>
<p>i’m the man in the mirror 그러니 light me up</p>
<p>1절의 그 별이 2절의 그 별이</p>
<p>그래 모두 나였지 실화가 된 동화이지</p>
<p>힘들 때면 홀로 쓴 노래를 불러</p>
<p>환상들을 보던 성냥팔이 소년이였던 나날들이</p>
<p>365, 24, 730, 24에 7</p>
<p>1095 아 그만 세자 1400이 되니 oh</p>
<p>그 애랑도 하고 돔페리뇽이 만든</p>
<p>숙취 땜에 넋을 놓은 나를 향해</p>
<p>몇천 명이 ‘와’ 해</p>
<p>본 적은 없지만 때론</p>
<p>어떤 존재가 내 인생을 왔다 간 듯해</p>
<p>그냥 그런 느낌이 들지</p>
<p>상관없어 환상이던 현실이던지 hands up high</p>
<br />
<p>전국</p>
<p>사람들이 외치네</p>
<p>저 괴물체는 뭘까?</p>
<p>Meteor</p>
<p>거대 Meteor</p>
<p>난 네게 처박힐 Meteor야</p>
<br />
<p>별빛이 내려오지 마구</p>
<p>내려오지</p>
<p>경고</p>
<p>경고</p>
<p>그래도 처박힐 Meteor야</p>
<br />
<p>영 영 영원히</p>
<p>약속해 영원하기로</p>
<p>어둠 가득한 저 뒤로</p>
<p>돌려보내지 말아요 제발 제발</p>
<p>영 영 영원히</p>
<p>난 영원할 거라 믿어</p>
<p>흥분으로 가득차</p>
<p>이 도시에 나 외칠 꺼야</p>
<p>“드디어 내가 여 왔다”</p> '
);

INSERT INTO boardContent (songNum, genreId, title, linkAddress, albumName, songName, singer, lyrics)
VALUES (
(select nvl(max(songNum), 0) + 1 from boardContent),
'genre04',
'정동하 - 추억은 만남보다 이별에 남아',
'https://www.youtube.com/embed/khGHeUaJRjw',
'추억은 만남보다 이별에 남아',
'추억은 만남보다 이별에 남아',
'정동하',
'<p>아득한 시간 속에 아직</p>
<p>우리 사랑이 남아있을까</p>
<p>멀어지던 그날의 너를 따라 걸어도</p>
<p>텅 빈 거리엔 미움만</p>
<p>너의 흔적을 마주칠 때마다</p>
<p>익숙함 속에 떠나보내던</p>
<p>소중했던 모든 날들은</p>
<p>후회로 남아</p>
<p>이렇게 또 내게 다가오나 봐</p>
<br />
<p>멍하니 혼자 남아</p>
<p>나도 모르게 널 그리워하다</p>
<p>떠오르는 네 생각에 하루를 살아</p>
<p>선명했던 우리의</p>
<p>추억은 만남보다 이별에 남아</p>
<p>여전히 너를 사랑하게 하나 봐</p>
<p>그날처럼</p>
<br />
<p>저녁 빛에 밤이 물들면</p>
<p>길게 늘어진 그림자처럼</p>
<p>흩어질 듯 더 커져가는 너의 모습은</p>
<p>아직도 내 안에 가득한가 봐</p>
<br />
<p>멍하니 혼자 남아</p>
<p>나도 모르게 널 그리워하다</p>
<p>떠오르는 네 생각에 하루를 살아</p>
<p>선명했던 우리의</p>
<p>추억은 만남보다 이별에 남아</p>
<p>여전히 너를 사랑하게 하나 봐</p>
<p>바보처럼</p>
<br />
<p>흩날리는 기억의 모든 순간마다 너를</p>
<p>매일 이렇게 불러본다</p>
<p>꼭 한 번쯤 너에게 해주고 싶었던 말</p>
<p>너무 사랑했다고 다시는 너를 떠나지 않겠다고</p>
<p>여전히 너를 사랑하고 있다고</p>
<p>그날 보다</p>'
);

commit;

--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==--==
create table repls (
replNum number(5,0) primary key ,
songNum number(5,0) not null ,
replWriter varchar2(3000) not null ,
replContent varchar2(3000) not null ,
registerDate date default sysdate,
CONSTRAINT FK_boardContent_songNum
FOREIGN KEY (songNum)
REFERENCES boardContent (songNum)
);

drop table repls;
