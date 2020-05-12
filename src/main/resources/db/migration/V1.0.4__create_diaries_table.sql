create table diaries (
    id int(15) AUTO_INCREMENT,
    user_id int(15),
    status varchar(255),
    title varchar(255),
    content varchar(1024),
    created_at datetime default current_timestamp,
    updated_at timestamp default current_timestamp on update current_timestamp,
    PRIMARY KEY (id)
);
