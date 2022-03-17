create database user_manager_db;
use user_manager_db;
create table users(
id int(3) not null auto_increment,
name varchar(120) not null,
email varchar(220) not null,
country varchar(120),
primary key (id)
);

insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');
use user_manager_db;
select id,name,email,country from users where country like concat("%","Viet","%");
select * from users;
select * from users order by name asc ;

DELIMITER $$
create procedure get_user_bu_id (in user_id INT)
begin
select users.name, users.email, users.country
from users
where users.id = user.id; 
end$$
DELIMITER ;
DELIMITER $$
create procedure insert_user(
IN user_name varchar(50),
IN user_email varchar(50),
IN user_country varchar(50)
)
begin
INSERT INTO users(name, email, country) VALUES(user_name, user_email, user_country);
end$$
DELIMITER ;

create table permision(
id int(11) primary key,
name varchar(50)
);
create table User_permision(
permision_id int (11),
user_id int (11)
);

insert into Permision(id, name) values(1, 'add');

insert into Permision(id, name) values(2, 'edit');

insert into Permision(id, name) values(3, 'delete');

insert into Permision(id, name) values(4, 'view');



