create table credentials (
   login_id VARCHAR(255),
   password VARCHAR(255),
   created_at datetime default current_timestamp,
   updated_at timestamp default current_timestamp on update current_timestamp,
   PRIMARY KEY (login_id)
)