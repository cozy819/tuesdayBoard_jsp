# 5회. 2021. 4. 13. 화요일 @ 그린컴퓨터아카데미 401호

## 한 일

- Database 추가, 수정 -> 고지웅

```
create table admin_account
(
    indexNum            number(5,0)     primary key,
    adminId             varchar2(30)    unique,
    adminPassword       varchar2(30)    not null,
    registerDate        date            default sysdate,
    tag                 varchar2(30)    default 'admin'
);

create table client_account(
    indexNum            number(5,0)     primary key,
    clientId            varchar2(30)    unique,
    clientPassword      varchar2(30)    not null,
    clientEmail         varchar2(100),
    registerDate        date            default sysdate,
    tag                 varchar2(30)    default 'client'
);

create table genres(
    genreId     varchar2(30)    primary key ,
    genreName   varchar2(30)    unique,
    genreSeq    number(5,0)
);

create table boardContent (
    songNum             number(5,0)         primary key,
    genreId             varchar2(30)        not null,
    title               varchar2(300)        not null,
    linkAddress         varchar2(3000)      not null,
    albumName           varchar2(3000),
    songName            varchar2(3000),
    singer              varchar2(3000),
    lyrics              varchar2(3000),
    registerDate        date                default sysdate,
    CONSTRAINT          FK_genres_genreId
    FOREIGN KEY         (genreId)
    REFERENCES          genres              (genreId)
);
```

- 장르 CRUD -> 고지웅
- 게시판 CRUD -> 고지웅
- css작업 -> 고지웅
- 게시판에 넣을 데이터 모으기 -> 박성빈, 황여원, 김도현

&nbsp;
&nbsp;
&nbsp;

# 4회. 2021. 4. 6. 화요일 @ 그린컴퓨터아카데미 401호

## 한 일

- 회원가입 추가 -> 박성빈
- 회원상세보기 추가 -> 박성빈
- css 작업 -> 고지웅
- GitHub 업로드 -> 고지웅

## 해야 할 일

- 음악게시판 틀 작업 -> 고지웅
- 게시판에 넣을 데이터 모으기 -> 박성빈, 황여원, 김도현

&nbsp;
&nbsp;
&nbsp;

# 3회. 2021. 4. 4. 일요일 @ 르하임스터디카페 부산사상점

## 한 일

- 회원 update 추가 -> 황여원
- css 작업 -> 고지웅
- GitHub 업로드 -> 고지웅

## 해야 할 일

- 음악게시판 틀 작업 -> 고지웅
- 게시판에 넣을 데이터 모으기 -> 김도현

&nbsp;
&nbsp;
&nbsp;

# 2회. 2021. 3. 28. 일요일 @ 르하임스터디카페 부산사상점

## 한 일

- 회원 delete 추가 -> 김도현
- GitHub 업로드 -> 고지웅

## 해야 할 일

- 회원 update 추가 -> 황여원
- 회원 create 추가 -> 박성빈

&nbsp;
&nbsp;
&nbsp;

# 1회. 2021. 3. 20. 토요일 @ 르하임스터디카페 부산서면점

## 프로그래밍 도구

- jdk1.8.0_271(= jdk8u271)
- eclipse 2019-06
- oracle 11g xe
- GitHub

## Database

- ID : tuesday
- password : 1234

```
create table admin_account (
  indexNum varchar2(30) primary key,
  userId varchar2(30) unique,
  userPassword varchar2(30) not null,
  registerDate date default sysdate
);

create table client_account(
  indexNum varchar2(30) primary key,
  userId varchar2(30) unique,
  userPassword varchar2(30) not null,
  registerDate date default sysdate
);

create table contents (
  indexNum varchar2(30) primary key,
  title varchar2(30) not null,
  linkAddress varchar2(3000) not null,
  lyrics varchar2(3000),
  registerDate date default sysdate,
  contentLevel varchar(10) not null
);
```

## 역할분담

1. 첫 페이지 : login.html -> 고지웅

2. 관리자 페이지

- 회원리스트 -> 고지웅
- 회원가입 -> 박성빈
- 상세보기 -> 박성빈
- 회원정보수정 -> 황여원
- 회원삭제 -> 김도현
