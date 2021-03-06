create database furama;
use furama;
CREATE TABLE position (
    position_id INT NOT NULL PRIMARY KEY,
    position_name VARCHAR(45)
);
CREATE TABLE education_degree (
    education_degree_id INT NOT NULL PRIMARY KEY,
    education_degree_name VARCHAR(45)
);
CREATE TABLE division (
    division_id INT NOT NULL PRIMARY KEY,
    division_name VARCHAR(45)
);
create table role(
role_id int not null primary key,
role_name varchar(255)
);
create table user(
username varchar(255) primary key,
password varchar(255)
);
create table user_role(
role_id int,
username varchar(255),
primary key (role_id,username),
foreign key (role_id) references role(role_id),
foreign key (username) references user(username)
);
CREATE TABLE employee (
    employee_id INT NOT NULL auto_increment,
    employee_name VARCHAR(45) NOT NULL,
    employee_birthday DATE NOT NULL,
    employee_id_card VARCHAR(45) NOT NULL,
    employee_salary DOUBLE NOT NULL,
    employee_phone VARCHAR(45) NOT NULL,
    employee_email VARCHAR(45),
    employee_address VARCHAR(45),
    position_id INT NOT NULL,
    education_degree_id INT NOT NULL,
    division_id INT NOT NULL,
    username varchar(255),
    PRIMARY KEY (employee_id),
    FOREIGN KEY (position_id)
        REFERENCES position (position_id),
    FOREIGN KEY (education_degree_id)
        REFERENCES education_degree (education_degree_id),
    FOREIGN KEY (division_id)
        REFERENCES division (division_id),
	FOREIGN KEY (username)
        REFERENCES user (username)
);
DELIMITER //
create trigger after_user before insert on employee
for each row
begin
insert into user set username = new.employee_email,password ="123456";
end//
DELIMITER ;
CREATE TABLE customer_type (
    customer_type_id INT PRIMARY KEY NOT NULL,
    customer_type_name VARCHAR(45)
);
CREATE TABLE customer (
    customer_id INT NOT NULL auto_increment,
    customer_code VARCHAR(10) NOT NULL,
    
    customer_name VARCHAR(45) NOT NULL,
    customer_birthday DATE NOT NULL,
    customer_gender BIT(1) NOT NULL,
    customer_id_card VARCHAR(45) NOT NULL,
    customer_phone VARCHAR(45) NOT NULL,
    customer_email VARCHAR(45),
    customer_address VARCHAR(45),
    customer_type_id INT NOT NULL,
    PRIMARY KEY (customer_id ),
    FOREIGN KEY (customer_type_id)
        REFERENCES customer_type (customer_type_id)
);
CREATE TABLE rent_type (
    rent_type_id INT PRIMARY KEY NOT NULL,
    rent_type_name VARCHAR(45)
--     rent_type_cost DOUBLE
);
CREATE TABLE service_type (
    service_type_id INT PRIMARY KEY NOT NULL,
    service_type_name VARCHAR(45)
);
CREATE TABLE service (
    service_id INT auto_increment,
    service_code VARCHAR(10) NOT NULL,
    service_name VARCHAR(45) NOT NULL,
    service_area INT,
    service_cost DOUBLE NOT NULL,
    service_max_people INT,
    rent_type_id INT,
    service_type_id INT,
    standard_room VARCHAR(45),
    description_other_convenience VARCHAR(45),
    pool_area double,
    number_of_floors INT,
    PRIMARY KEY (service_id),
    FOREIGN KEY (rent_type_id)
        REFERENCES rent_type (rent_type_id),
    FOREIGN KEY (service_type_id)
        REFERENCES service_type (service_type_id)
);
CREATE TABLE contract (
    contract_id INT NOT NULL auto_increment,
    contract_start_date DATETIME NOT NULL,
    contract_end_date DATETIME NOT NULL,
    contract_deposit DOUBLE NOT NULL,
    contract_total_money DOUBLE NOT NULL,
    employee_id INT,
    customer_id INT,
    service_id INT,
    PRIMARY KEY (contract_id),
    FOREIGN KEY (employee_id)
        REFERENCES employee (employee_id),
    FOREIGN KEY (customer_id)
        REFERENCES customer (customer_id),
    FOREIGN KEY (service_id)
        REFERENCES service (service_id)
);
CREATE TABLE attach_service (
    attach_service_id INT PRIMARY KEY,
    attach_service_name VARCHAR(45) NOT NULL,
    attach_service_cost DOUBLE NOT NULL,
    attach_service_unit VARCHAR(10) NOT NULL,
    attach_service_status VARCHAR(45)
);
CREATE TABLE contract_detail (
    contract_detail_id INT NOT NULL,
    contract_id INT NOT NULL,
    attach_service_id INT NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (contract_detail_id,contract_id,attach_service_id),
    FOREIGN KEY (attach_service_id)
        REFERENCES attach_service (attach_service_id),
    FOREIGN KEY (contract_id)
        REFERENCES contract (contract_id)
);
INSERT INTO position VALUES (1,'Qu???n L??'), (2,'Nh??n Vi??n');
INSERT INTO education_degree VALUES (1,'Trung C???p'), (2,'Cao ?????ng'), (3,'?????i H???c'), (4,'Sau ?????i H???c');
INSERT INTO division VALUES (1,'Sale-Marketing'), (2,'H??nh ch??nh'), (3,'Ph???c v???'), (4,'Qu???n l??');
INSERT INTO customer_type VALUES (1,'Diamond'),(2,'Platinium'),(3,'Gold'),(4,'Silver'),(5,'Member');
INSERT INTO customer VALUES
(1,'KH-0001','Nguy???n Th??? H??o','1970-11-07',0,'643431213','0945423362','thihao07@gmail.com','23 Nguy???n Ho??ng, ???? N???ng',5),
(2,'KH-0002','Ph???m Xu??n Di???u','1992-08-08',1,'865342123','0954333333','xuandieu92@gmail.com','K77/22 Th??i Phi??n, Qu???ng Tr???',3),
(3,'KH-0003','Tr????ng ????nh Ngh???','1990-02-27',1,'488645199','0373213122','nghenhan2702@gmail.com','K323/12 ??ng ??ch Khi??m, Vinh',1),
(4,'KH-0004','D????ng V??n Quan','1981-07-08',1,'543432111','0490039241','duongquan@gmail.com','K453/12 L?? L???i, ???? N???ng',1),
(5,'KH-0005','Ho??ng Tr???n Nhi Nhi','1995-12-09',0,'795453345','0312345678','nhinhi123@gmail.com','224 L?? Th??i T???, Gia Lai',4),
(6,'KH-0006','T??n N??? M???c Ch??u','2005-12-06',0	,'732434215','0988888844','tonnuchau@gmail.com','37 Y??n Th???, ???? N???ng',4),
(7,'KH-0007','Nguy???n M??? Kim','1984-04-08',0,'856453123','0912345698','kimcuong84@gmail.com','K123/45 L?? L???i, H??? Ch?? Minh',1),
(8,'KH-0008','Nguy???n Th??? H??o','1999-04-08',0,'965656433','0763212345','haohao99@gmail.com','55 Nguy???n V??n Linh, Kon Tum',3),
(9,'KH-0009','Tr???n ?????i Danh','1994-07-01',1,'432341235','0643343433','danhhai99@gmail.com','24 L?? Th?????ng Ki???t, Qu???ng Ng??i',1),
(10,'KH-0010','Nguy???n T??m ?????c','1989-07-01',1,'344343432','0987654321','dactam@gmail.com','22 Ng?? Quy???n, ???? N???ng',2);
INSERT INTO employee (employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id) VALUES 
(1,'Nguy???n V??n An','1970-11-07','456231786',10000000,'0901234121','annguyen@gmail.com','295 Nguy???n T???t Th??nh, ???? N???ng',1,3,1),
(2,'L?? V??n B??nh','1997-04-09','654231234',7000000,'0934212314','binhlv@gmail.com','22 Y??n B??i, ???? N???ng',1,2,2),
(3,'H??? Th??? Y???n','1995-12-12','999231723',14000000,'0412352315','thiyen@gmail.com','K234/11 ??i???n Bi??n Ph???, Gia Lai',1,3,2),
(4,'V?? C??ng To???n','1980-04-04','123231365',17000000,'0374443232', 'toan0404@gmail.com', '77 Ho??ng Di???u, Qu???ng Tr???',1,4,4),
(5,'Nguy???n B???nh Ph??t','1999-12-09','454363232',6000000,'0902341231','phatphat@gmail.com','43 Y??n B??i, ???? N???ng', 2, 1, 1),
(6,'Kh??c Nguy???n An Nghi','2000-11-08','964542311',7000000,'0978653213','annghi20@gmail.com','294 Nguy???n T???t Th??nh, ???? N???ng',2,2,3),
(7,'Nguy???n H???u H??','1993-01-01','534323231',8000000,'0941234553','nhh0101@gmail.com','4 Nguy???n Ch?? Thanh, Hu???',2,3,2),
(8,'Nguy???n H?? ????ng','1989-09-03','234414123',9000000,'0642123111','donghanguyen@gmail.com','111 H??ng V????ng, H?? N???i',2,4,4),
(9,'T??ng Hoang','1982-09-03','256781231',6000000,'0245144444','hoangtong@gmail.com','213 H??m Nghi, ???? N???ng',2,4,4),
(10,'Nguy???n C??ng ?????o','1994-01-08','755434343',8000000,'0988767111'	,'nguyencongdao12@gmail.com','6 Ho?? Kh??nh, ?????ng Nai',2,3,2);
INSERT INTO rent_type VALUES(1,'year'),(2,'month'),(3,'day'),(4,'hour');
INSERT INTO service_type VALUES(1,'Villa'),(2,'House'),(3,'Room');
INSERT INTO service VALUES
(1,'DV-0001','Villa Beach  Front',25000,10000000,10,3,1,'vip','C?? h??? b??i',500,4),
(2,'DV-0002','House Princess 01',14000,5000000,7,2,2,'vip','C?? th??m b???p n?????ng',null,3),
(3,'DV-0003','Room Twin 01',5000,1000000,2,4,3,'normal','C?? tivi',null,null),
(4,'DV-0004','Villa No Beach Front',22000,9000000,8,3,1,'normal','C?? h??? b??i',300,3),
(5,'DV-0005','House Princess 02',10000,4000000,5,3,2,'normal','C?? th??m b???p n?????ng',null,2),
(6,'DV-0006','Room Twin 02',3000,	900000,2,4,3,'normal','C?? tivi',null,null);
INSERT INTO attach_service VALUES
(1,'Karaoke',10000,'gi???','ti???n nghi,hi???n t???i'),
(2,'Thu?? xe m??y',10000,'chi???c','h???ng 1 xe'),
(3,'Thu?? xe ?????p',20000,'chi???c','t???t'),
(4,'Buffet bu???i s??ng',15000,'su???t','?????y ????? ????? ??n, tr??ng mi???ng'),
(5,'Buffet bu???i tr??a',90000,'su???t','?????y ????? ????? ??n, tr??ng mi???ng'),
(6,'Buffet bu???i t???i',16000,'su???t','?????y ????? ????? ??n, tr??ng mi???ng');
INSERT INTO contract VALUES
(1,'2020-12-08','2020-12-08',0,100000,3,1,3),
(2,'2020-07-14','2020-07-21',200000,800000,7,3,1),
(3,'2021-03-15','2021-03-17',50000,1000000,3,4,2),
(4,'2021-01-14','2021-01-18',100000,560000,7,5,5),
(5,'2021-07-14','2021-07-15',0,400000,7,2,6),
(6,'2021-06-01','2021-06-03',0,400000,7,7,6),
(7,'2021-09-02','2021-09-05',100000,700000,7,4,4),
(8,'2021-06-17','2021-06-18',150000,900000,3,4,1),
(9,'2020-11-19','2020-11-19',0,600000,3,4,3),
(10,'2021-04-25','2021-04-25',0,550000,2,2,1),
(11,'2021-05-25','2021-05-27',0,590000,7,10,1);

select * from employee;

INSERT INTO contract_detail VALUES
(1,	2,	4, 5),
(2,	2,	5, 8),
(3,	2,	6, 15);

select * from contract;
select * from contract_detail;

select contract_id, contract_start_date, contract_end_date, contract_deposit,contract_total_money,
employee_name,customer_name,service_name from contract
join employee on employee.employee_id = contract.employee_id
join customer on customer.customer_id = contract.customer_id
join service on service.service_id = contract.service_id
order by contract_id;




-- select employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position.position_name,education_degree.education_degree_name,division.division_name
-- from employee
-- join position on employee.position_id = position.position_id
-- join education_degree on employee.education_degree_id = education_degree.education_degree_id
-- join division on employee.division_id = division.division_id
-- order by employee_id;

-- select * from employee;
-- select * from user;

-- select customer_id,customer_code,customer_name,customer_birthday,customer_gender,customer_id_card, customer_phone,customer_email,
-- customer_address,customer_type.customer_type_name from customer
-- inner join customer_type on customer.customer_type_id = customer_type.customer_type_id
-- order by customer_id;

-- insert into customer (customer_code, customer_name, customer_birthday, customer_gender,customer_id_card, customer_phone,customer_email,customer_address,customer_type_id)
-- value ("KH-0011",'Nguy???n T??m Long','1989-07-12',1,'344343432','0987654321','dacLong@gmail.com','22 L?? L???i, ???? N???ng',2);

-- select  customer_id,customer_code,customer_name,customer_birthday,customer_gender,customer_id_card, customer_phone,customer_email,
-- customer_address,customer_type_id from customer
-- where customer_id = 2;

-- update customer set customer_code = "KH-0002", customer_name = "Ph???m Xu??n Di???u" ,customer_birthday = "1992-08-08",customer_gender = 0,customer_id_card ="865342123", customer_phone = "0954333333",
-- customer_email= "xuandieu92@gmail.com",customer_address = "K77/22 Th??i Phi??n, Qu???ng Tr???",customer_type_id = 5
-- where customer_id = 2;

-- delete from customer where customer_id = 2;

-- insert into employee (employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,
-- employee_address,position_id,education_degree_id,division_id)
-- value ("Nguy???n V??n B??","1996-02-20","9834758375",8000000,"0902948571","be@gmail.com","90 L?? L???i, Qu???ng Nam",1,2,3);

-- select * from employee;
-- select * from employee where employee_id = 5;



-- update employee set employee_name ="Nguy???n V??n An" ,employee_birthday="1970-11-07",employee_id_card="456231786",employee_salary="20000000",employee_phone="0901234121",
-- employee_email="annguyen@gmail.com",employee_address="295 Nguy???n T???t Th??nh, ???? N???ng",position_id=1,education_degree_id=3,division_id=1
-- where employee_id = 1;

-- delete from employee where employee_id = ?;

-- select employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position.position_name,education_degree.education_degree_name,division.division_name
-- from employee
-- join position on employee.position_id = position.position_id
-- join education_degree on employee.education_degree_id = education_degree.education_degree_id
-- join division on employee.division_id = division.division_id
-- where employee_name like "%nguyen%"
-- order by employee_id;

-- select customer_id,customer_code,customer_name,customer_birthday,customer_gender,customer_id_card, customer_phone,customer_email,
-- customer_address,customer_type.customer_type_name from customer
-- inner join customer_type on customer.customer_type_id = customer_type.customer_type_id
-- where customer_name like "%Quan%"
-- order by customer_id;

-- select service_id,service_code,service_name,service_area,service_cost,service_max_people,rent_type.rent_type_name,service_type.service_type_name,
-- standard_room, description_other_convenience,ifnull(pool_area,-1), ifnull(number_of_floors,-1) from service
-- join rent_type on service.rent_type_id = rent_type.rent_type_id
-- join service_type on service.service_type_id = service_type.service_type_id
-- order by service_id;
-- select * from service;
-- select * from rent_type;
select*from contract; 
insert into contract(contract_start_date,contract_end_date,contract_deposit,contract_total_money,employee_id,customer_id,service_id)
value (?,?,?,?,?,?,?);






