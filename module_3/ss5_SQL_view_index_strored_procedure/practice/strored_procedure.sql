use classicmodels;
DELIMITER //
create procedure find_all_customers()
BEGIN
select * from customers;
END //
DELIMITER ; 

call find_all_customers();


