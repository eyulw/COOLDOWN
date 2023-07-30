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

select * from boardcombine_;

create view itematt
as select i.*,ia.iano,ia.fname,ia.fsize from item i join itemattach ia using(item_id);

select * from itematt;

create view ba
    as select * from user nick
        join boardattach ba using(u_id);

select * from bba;

select * from boardcombine_ where category = "자유글";

insert into boardattach (board_id, fname, fsize)
values (115,'logo.png',0);

delete from board;

alter table contentscomments
    add constraint fkrefcontents_id
        foreign key (ref) references contentscomments (contents_id);

alter table boardcomments
    drop constraint fkrefcontents_id;

alter table boardcomments
    add constraint fk_uid_uid
        foreign key (u_id) references user(u_id);

alter table boardcomments
    add constraint fk_boardid_boardid
        foreign key (board_id) references board(board_id);

alter table boardcomments
    add constraint fk_ref_replyid
        foreign key (ref) references boardcomments (reply_id);

create view ba
    as select * from user nick
        join boardattach ba using(u_id);


select * from bba;

select * from boardcombine_ where category = "자유글";

select * from boardcombine_ order by views desc limit 0, 5;

update item set category='digbus_goods',itemname='테스트',price='6000',info='수정성공',stock='40' where item_id='27';

create view iqua
as
select iq.*, u.userid from itemqna iq join user u using(u_id);

create view iquia
as select iqua.*, i.itemname from iqua join item i using(item_id);

insert into itemqna (u_id,item_id,title,contents) values (1,1,'상품문의합니다!!!!!','무늬무늬');


select * from boardcombine_ order by views desc limit 0, 5;

update item set category='digbus_goods',itemname='테스트',price='6000',info='수정성공',stock='40' where item_id='27';

create view iqua
as
select iq.*, u.userid from itemqna iq join user u using(u_id);

create view iquia
as select iqua.*, i.itemname from iqua join item i using(item_id);

insert into itemqna (u_id,item_id,title,contents) values (1,1,'상품문의합니다!!!!!','무늬무늬');

select * from qna join user using(u_id) order by qna_id desc limit 0,15;

select * from boardcombine_ order by views desc limit 0, 5;

update item set category='digbus_goods',itemname='테스트',price='6000',info='수정성공',stock='40' where item_id='27';

create view iqua
as
select iq.*, u.userid from itemqna iq join user u using(u_id);

create view iquia
as select iqua.*, i.itemname from iqua join item i using(item_id);

insert into itemqna (u_id,item_id,title,contents) values (1,1,'상품문의합니다!!!!!','무늬무늬');

create view bc
as select b.*,u.nickname from boardcomments b
                                  join user u using(u_id);

select b.*,u.nickname from boardcomments b
                  join user u using(u_id);

select * from bc;

insert into boardcomments (u_id, board_id, contents, ref)
values (3,121,'ㄴㅇ','3');


drop table boardcomments;
create table boardcomments (
reply_id    int             auto_increment,
u_id        int             not null,
board_id    int             not null,
regdate     datetime        default current_timestamp,
contents    text            not null,
report      int,
ref         int             not null,
primary key (reply_id)
);

select bba.*, user.nickname from bba join user using(u_id);


create view boardcombine
as select bba.*, user.nickname from bba join user using(u_id);

create view boardcombine
as
select bc.*,c.cmtcn from boardcombine_ bc right outer join (select count(reply_id) cmtcn,board_id from boardcomments group by board_id) c on bc.board_id=c.board_id;

select bc.*,c.cmtcn from boardcombine_ bc left outer join (select count(reply_id) cmtcn,board_id from boardcomments group by board_id) c on bc.board_id=c.board_id;

select count(reply_id) cmtcn,board_id from boardcomments group by board_id;

delete from user where u_id=8;

SELECT boardcombine.*, LAG(board_id, 1) OVER(ORDER BY board_id) AS board_prev
FROM boardcombine__;


create view boardcombine
    as
(SELECT boardcombine__.*
     ,LEAD(title, 1) OVER(ORDER BY board_id) AS bdnext
     ,LAG(title, 1) OVER(ORDER BY board_id) AS bdprev
     ,LEAD(board_id, 1) OVER(ORDER BY board_id) AS bdidnext
     ,LAG(board_id, 1) OVER(ORDER BY board_id) AS bdidprev
FROM boardcombine__);
