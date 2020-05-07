create table users (
    id Int(15) AUTO_INCREMENT,
    name VARCHAR(255),
    email VARCHAR(255),
    created_at datetime default current_timestamp,
    updated_at timestamp default current_timestamp on update current_timestamp,
    PRIMARY KEY (id)
)