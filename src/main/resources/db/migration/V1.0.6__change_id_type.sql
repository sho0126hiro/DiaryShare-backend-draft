alter table users modify id binary(16) not null;
alter table diaries modify id binary(16) not null;
alter table diaries modify user_id binary(16) not null;
