use classicmodels;
create view customers_view as 
select  customerNumber, customerName, phone from customers;

select *from customers_view;

create or replace view customers_view as
select customers.customerNumber, customers.customerName,customers.contactFirstName,customers.contactLastName, customers.phone
from customers
where city = "Nantes";
select *from customers_view;

drop view customers_view;