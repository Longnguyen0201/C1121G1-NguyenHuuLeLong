create database ss5_view_index_stored_procedure;
use ss5_view_index_stored_procedure;
create table products (
id int primary key,
product_code int,
product_name varchar(45),
product_price double,
product_amount varchar(45),
product_description varchar(45),
product_status varchar(45));

insert into products values 
(1,101,'Samsung galaxy s6', 2000, '100', "camera 12px", "99%"),
(2,102,'Iphone X', 2500, '200', "camera 12px", "99%");
-- Bước 3:
alter table products add unique index idx_product_code(product_code);
explain select *from products where product_code = 101;
alter table products add index c_idx_product(product_name, product_price);
explain select *from products where product_name ="Iphone X" or product_price = 2500;	

-- Bước 4:
create view products_view as
select product_code, product_name, product_price,product_status from products;

select * from products_view;
drop view products_view;

-- bước 5:

DELIMITER //
create procedure find_all_product()
begin 
select * from products;
end //
DELIMITER ;
call find_all_product();

DELIMITER //
create procedure add_product(id int, p_code int, p_name varchar(45), p_price double, p_amount varchar(45),p_description varchar(45), p_status varchar(45))
begin 
insert into products
values (id, p_code, p_name, p_price,p_amount, p_description, p_status);
end //
DELIMITER ;
call add_product(3,103,"Iphone XSMAX", 3500,"300", "sim vật lý", "100%");

DELIMITER //
create procedure edit_product_by_id( p_id int,p_name varchar(45))
begin 
update products
set product_name = p_name
where id = p_id;
end //
DELIMITER ;
 call edit_product_by_id(1,"oppo");
 select *from products;
 
 DELIMITER //
create procedure delete_product_by_id( p_id int)
begin 
delete from products
where id = p_id;
end //
DELIMITER ;

call delete_product_by_id(1);
select *from products;




