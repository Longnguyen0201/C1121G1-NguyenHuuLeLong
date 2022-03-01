use classicmodels;
DELIMITER //
create procedure get_cus_by_id ( in cus_number int(11))
begin
select * from customers where customerNumber= cus_number;
end //
DELIMITER ;

call get_cus_by_id(175);

-- Tham số loại OUT

DELIMITER //
create procedure get_customers_count_by_city ( in in_city varchar(45), out total int )
begin
select count(customerNumber) into total from customers
where city = in_city;
end //
DELIMITER ;

call get_customers_count_by_city ("Lyon", @total);
select @total;

-- Tham số loại INOUT 
DELIMITER //
create procedure set_counter( inout counter int, in inc int)
begin 
set counter = counter + inc;
end
DELIMITER ;

set @counter = 1;
 call set_counter(@counter , 1 );
 call set_counter(@counter , 1);
 call set_counter(@counter , 5);
 select @counter;