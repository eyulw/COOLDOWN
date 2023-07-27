create table boardattach(
    bano          int             auto_increment,
    board_id      int             not null ,  /*게시글 번호*/
    fname         varchar(200)    not null ,  /*uuid 포함*/
    fsize         float           not null ,
    primary key (bano)
);

alter table boardattach add constraint fkbid foreign key (board_id) references board(board_id);

create table contentsattach(
    cano          int             auto_increment,
    contents_id   int             not null ,  /*컨텐츠 번호*/
    fname         varchar(200)    not null ,  /*uuid 포함*/
    fsize         float           not null ,
    primary key (cano)
);

alter table contentsattach add constraint fkcid foreign key (contents_id) references contents(contents_id);

create table itemattach(
    iano          int             auto_increment,
    item_id       int             not null ,  /*item 번호*/
    fname         varchar(200)    not null ,  /*uuid 포함*/
    fsize         float           not null ,
    primary key (iano)
);

alter table itemattach add constraint fkiid foreign key (item_id) references item(item_id);

insert into qna (u_id,title,contents) values (3,"문의합니다","파이팅~해야지...");

insert into qna (u_id,title,contents) values (1,"뭐뭐뭐 문의합니다","아아아");

insert into qna (u_id,title,contents) values (6,'상품 구매 문의 합니다','제곧내~');


select * from board;
select b.* from board b;

create view bu
as select b.*,u.nickname from board b join user u using(u_id);

select * from bu order by board_id desc limit 0,5;

create view bba
as select b.*,ba.bano,ba.fname,ba.fsize from board b join boardattach ba using(board_id);

create view boardcombine
as select bba.*, user.nickname from bba join user using(u_id);

select * from boardcombine;

create view itematt
as select i.*,ia.iano,ia.fname,ia.fsize from item i join itemattach ia using(item_id);

select * from itematt;

create view ba
    as select * from user nick
        join boardattach ba using(u_id);

select * from bba;

select * from boardcombine where category = "자유글";

select * from boardcombine order by views desc limit 0, 5;

update item set category='digbus_goods',itemname='테스트',price='6000',info='수정성공',stock='40' where item_id='27';

create view iqua
as
select iq.*, u.userid from itemqna iq join user u using(u_id);

create view iquia
as select iqua.*, i.itemname from iqua join item i using(item_id);

insert into itemqna (u_id,item_id,title,contents) values (1,1,'상품문의합니다!!!!!','무늬무늬');

