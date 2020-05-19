create table likes(
    id binary(16) unique,
    user_id binary(16),
    diary_id binary(16),
    created_at datetime default current_timestamp,
    primary key (id),
    unique (user_id, diary_id)
);