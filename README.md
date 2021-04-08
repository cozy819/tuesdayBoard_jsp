# Team Project Meeting (2021. 3. 20. 토요일) @ 르하임스터디카페 부산서면점

## 프로그래밍 도구

1.  jdk1.8.0_271(= jdk8u271)
2.  eclipse 2019-06
3.  oracle 11g xe
4.  GitHub

## Database 초안

1. ID : tuesday
2. password : 1234
3. 테이블1 : 관리자 회원관리 테이블

```
create table admin_account
(
    indexNum            varchar2(30)    primary key,
    userId              varchar2(30)    unique,
    userPassword        varchar2(30)    not null,
    registerDate        date            default sysdate
);

-- 테스트용 데이터
insert into admin_account(indexNum, userId, userPassword)
VALUES (1, 'gjw', '34');
insert into admin_account(indexNum, userId, userPassword)
VALUES (2, 'psb', '29');
insert into admin_account(indexNum, userId, userPassword)
VALUES (3, 'hyw', '28');
insert into admin_account(indexNum, userId, userPassword)
VALUES (4, 'kdh', '27');
commit;
```

4. 테이블2 : 회원 로그인 정보 테이블

```
create table client_account(
    indexNum            varchar2(30)    primary key,
    userId              varchar2(30)    unique,
    userPassword        varchar2(30)    not null,
    registerDate        date            default sysdate
);

-- 테스트용 데이터
insert into client_account(indexNum, userId, userPassword)
VALUES (1, 'Java', 'eclipse');
insert into client_account(indexNum, userId, userPassword)
VALUES (2, 'SQL', 'oracle');
insert into client_account(indexNum, userId, userPassword)
VALUES (3, 'HTML', 'notepad');
insert into client_account(indexNum, userId, userPassword)
VALUES (4, 'CSS', 'Saas');
insert into client_account(indexNum, userId, userPassword)
VALUES (5, 'JavaScript', 'vscode');
```

5. 테이블3 : 음악게시판 내용

```
create table contents (
    indexNum            varchar2(30)        primary key,
    title               varchar2(30)        not null,
    linkAddress         varchar2(3000)      not null,
    lyrics              varchar2(3000),
    registerDate        date                default sysdate,
    contentLevel        varchar(10)         not null
);
```

## to Do List

0. 프로젝트 초기설정

   - 프로젝트 이름 : TuesdayBoard
   - package : green.tuesday.baord
     - green.tuesday.baord.base
       - Action.java
       - ActionFactory.java
     - green.tuesday.board.controller
       - BoardController.java
     - green.tuesday.board.dao
       - AccountDao.java
     - green.tuesday.board.vo
       - AccountVo.java
     - green.tuesday.board.db
       - DBConnection.java
     - green.tuesday.board.impl

1. 첫 페이지 : login.html - 고지웅

   - 관리자 로그인 버튼
   - 일반회원 로그인 버튼

2. 관리자 페이지

   - 회원리스트 : /view/adminList.jsp - 고지웅
   - 상세보기 : /view/adminView.jsp - 박성빈
   - 수정 : /view/adminUpdate.jsp - 황여원
   - 삭제 : /view/adminDelete.jsp - 김도현
   - 등록 : /view/adminAdd.jsp - 박성빈

3. 회원 컨텐츠 페이지
   - 아직 미정

&nbsp;

&nbsp;

&nbsp;

# Team Project Meeting (2021. 3. 28. 일요일) @ 르하임스터디카페 부산사상점

## 한 일

- 회원 delete 추가
- GitHub 업로드

&nbsp;

&nbsp;

&nbsp;

# Team Project Meeting (2021. 4. 4. 일요일) @ 르하임스터디카페 부산사상점

## 한 일

- 회원 update 추가
- css 작업

## 다음 Meeting

    - 일단 화요일

## toDoList

0. 음악게시판 틀 작업 - 고지웅
