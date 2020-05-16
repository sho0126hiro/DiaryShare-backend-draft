create table comments (
    id binary(16) unique,
    user_id binary(16),
    diary_id binary(16),
    content varchar(1024),
    created_at datetime default current_timestamp,
    updated_at timestamp default current_timestamp on update current_timestamp,
    PRIMARY KEY (id)
);
