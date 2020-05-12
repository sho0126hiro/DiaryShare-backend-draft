alter table users add unique (email);
alter table credentials add unique (login_id);