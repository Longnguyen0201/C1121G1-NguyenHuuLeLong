create database product_manager;
use product_manager;

create table categogy(
categogy_id int primary key auto_increment,
categogy_name varchar(45) not null
);
create table product (
id int primary key auto_increment,
product_name varchar(100) not null,
product_price double not null,
quantity int not null,
color varchar(54),
categogy_id int not null,
foreign key (categogy_id) references categogy(categogy_id) 
);

select id,product_name,product_price,quantity,color,categogy.categogy_name from product
inner join categogy on categogy.categogy_id= product.categogy_id
order by id;

insert into product(product_name,product_price,quantity,color,categogy_id) value (?,?,?,?,?);

delete from product where id = 4;
select* from product where id = 5;
 update  product set product_name = ? ,product_pric=?,quantity=?,color=?,categogy_id=?
 where id=?;
select id,product_name,product_price,quantity,color,categogy.categogy_name from product
inner join categogy on categogy.categogy_id= product.categogy_id where product_name like "%iphone%"
order by id;

