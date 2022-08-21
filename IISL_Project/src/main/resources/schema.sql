CREATE TABLE IF NOT EXISTS user(
    id int not null primary key auto_increment,
    name varchar(20),
    age int,
    birthday date);
