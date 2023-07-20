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
