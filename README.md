# spring

==== db 구축 ===
```
--- 테이블 생성하기
create table mvc_board(
	bid	number(4) primary key,
	bname varchar2(20),
	btitle varchar2(100),
	bcontent varchar2(300),
	bdate date default sysdate,
	bhit number(4) default 0,
	bgroup number(4),
	bstep number(4),
	bindent number(4)
	);
  
--- 컴밋하기
commit;

--- 시퀀스 생성하기
create sequence mvc_board_seq;
```
