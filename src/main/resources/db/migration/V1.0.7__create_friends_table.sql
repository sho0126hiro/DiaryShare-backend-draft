create table friends(
    id binary(16) unique,
    user_id binary(16),
    friend_id binary(16),
    status varchar(255),
    created_at datetime default current_timestamp,
    updated_at timestamp default current_timestamp on update current_timestamp,
    primary key (id),
    unique (user_id, friend_id)
);

alter table users add username varchar(255);
alter table users add constraint unique(username);
