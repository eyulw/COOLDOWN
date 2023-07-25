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

select b.* from board b;

create view bu
as select b.*,u.nickname from board b join user u using(u_id);

select * from bu order by board_id desc limit 0,5;

create view boardcombine
as select bba.*, user.nickname from bba join user using(u_id);

select * from boardcombine;

/*
bu -> board, user.nickname 합친 뷰

*/