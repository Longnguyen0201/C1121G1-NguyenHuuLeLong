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
INSERT INTO position VALUES (1,'Quản Lý'), (2,'Nhân Viên');
INSERT INTO education_degree VALUES (1,'Trung Cấp'), (2,'Cao Đẳng'), (3,'Đại Học'), (4,'Sau Đại Học');
INSERT INTO division VALUES (1,'Sale-Marketing'), (2,'Hành chính'), (3,'Phục vụ'), (4,'Quản lý');
INSERT INTO customer_type VALUES (1,'Diamond'),(2,'Platinium'),(3,'Gold'),(4,'Silver'),(5,'Member');
INSERT INTO customer VALUES
(1,'KH-0001','Nguyễn Thị Hào','1970-11-07',0,'643431213','0945423362','thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng',5),
(2,'KH-0002','Phạm Xuân Diệu','1992-08-08',1,'865342123','0954333333','xuandieu92@gmail.com','K77/22 Thái Phiên, Quảng Trị',3),
(3,'KH-0003','Trương Đình Nghệ','1990-02-27',1,'488645199','0373213122','nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh',1),
(4,'KH-0004','Dương Văn Quan','1981-07-08',1,'543432111','0490039241','duongquan@gmail.com','K453/12 Lê Lợi, Đà Nẵng',1),
(5,'KH-0005','Hoàng Trần Nhi Nhi','1995-12-09',0,'795453345','0312345678','nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai',4),
(6,'KH-0006','Tôn Nữ Mộc Châu','2005-12-06',0	,'732434215','0988888844','tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng',4),
(7,'KH-0007','Nguyễn Mỹ Kim','1984-04-08',0,'856453123','0912345698','kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh',1),
(8,'KH-0008','Nguyễn Thị Hào','1999-04-08',0,'965656433','0763212345','haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum',3),
(9,'KH-0009','Trần Đại Danh','1994-07-01',1,'432341235','0643343433','danhhai99@gmail.com','24 Lý Thường Kiệt, Quảng Ngãi',1),
(10,'KH-0010','Nguyễn Tâm Đắc','1989-07-01',1,'344343432','0987654321','dactam@gmail.com','22 Ngô Quyền, Đà Nẵng',2);
INSERT INTO employee (employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id) VALUES 
(1,'Nguyễn Văn An','1970-11-07','456231786',10000000,'0901234121','annguyen@gmail.com','295 Nguyễn Tất Thành, Đà Nẵng',1,3,1),
(2,'Lê Văn Bình','1997-04-09','654231234',7000000,'0934212314','binhlv@gmail.com','22 Yên Bái, Đà Nẵng',1,2,2),
(3,'Hồ Thị Yến','1995-12-12','999231723',14000000,'0412352315','thiyen@gmail.com','K234/11 Điện Biên Phủ, Gia Lai',1,3,2),
(4,'Võ Công Toản','1980-04-04','123231365',17000000,'0374443232', 'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị',1,4,4),
(5,'Nguyễn Bỉnh Phát','1999-12-09','454363232',6000000,'0902341231','phatphat@gmail.com','43 Yên Bái, Đà Nẵng', 2, 1, 1),
(6,'Khúc Nguyễn An Nghi','2000-11-08','964542311',7000000,'0978653213','annghi20@gmail.com','294 Nguyễn Tất Thành, Đà Nẵng',2,2,3),
(7,'Nguyễn Hữu Hà','1993-01-01','534323231',8000000,'0941234553','nhh0101@gmail.com','4 Nguyễn Chí Thanh, Huế',2,3,2),
(8,'Nguyễn Hà Đông','1989-09-03','234414123',9000000,'0642123111','donghanguyen@gmail.com','111 Hùng Vương, Hà Nội',2,4,4),
(9,'Tòng Hoang','1982-09-03','256781231',6000000,'0245144444','hoangtong@gmail.com','213 Hàm Nghi, Đà Nẵng',2,4,4),
(10,'Nguyễn Công Đạo','1994-01-08','755434343',8000000,'0988767111'	,'nguyencongdao12@gmail.com','6 Hoà Khánh, Đồng Nai',2,3,2);
INSERT INTO rent_type VALUES(1,'year'),(2,'month'),(3,'day'),(4,'hour');
INSERT INTO service_type VALUES(1,'Villa'),(2,'House'),(3,'Room');
INSERT INTO service VALUES
(1,'DV-0001','Villa Beach  Front',25000,10000000,10,3,1,'vip','Có hồ bơi',500,4),
(2,'DV-0002','House Princess 01',14000,5000000,7,2,2,'vip','Có thêm bếp nướng',null,3),
(3,'DV-0003','Room Twin 01',5000,1000000,2,4,3,'normal','Có tivi',null,null),
(4,'DV-0004','Villa No Beach Front',22000,9000000,8,3,1,'normal','Có hồ bơi',300,3),
(5,'DV-0005','House Princess 02',10000,4000000,5,3,2,'normal','Có thêm bếp nướng',null,2),
(6,'DV-0006','Room Twin 02',3000,	900000,2,4,3,'normal','Có tivi',null,null);
INSERT INTO attach_service VALUES
(1,'Karaoke',10000,'giờ','tiện nghi,hiện tại'),
(2,'Thuê xe máy',10000,'chiếc','hỏng 1 xe'),
(3,'Thuê xe đạp',20000,'chiếc','tốt'),
(4,'Buffet buổi sáng',15000,'suất','đầy đủ đồ ăn, tráng miệng'),
(5,'Buffet buổi trưa',90000,'suất','đầy đủ đồ ăn, tráng miệng'),
(6,'Buffet buổi tối',16000,'suất','đầy đủ đồ ăn, tráng miệng');
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
-- value ("KH-0011",'Nguyễn Tâm Long','1989-07-12',1,'344343432','0987654321','dacLong@gmail.com','22 Lê Lợi, Đà Nẵng',2);

-- select  customer_id,customer_code,customer_name,customer_birthday,customer_gender,customer_id_card, customer_phone,customer_email,
-- customer_address,customer_type_id from customer
-- where customer_id = 2;

-- update customer set customer_code = "KH-0002", customer_name = "Phạm Xuân Diệu" ,customer_birthday = "1992-08-08",customer_gender = 0,customer_id_card ="865342123", customer_phone = "0954333333",
-- customer_email= "xuandieu92@gmail.com",customer_address = "K77/22 Thái Phiên, Quảng Trị",customer_type_id = 5
-- where customer_id = 2;

-- delete from customer where customer_id = 2;

-- insert into employee (employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,
-- employee_address,position_id,education_degree_id,division_id)
-- value ("Nguyễn Văn Bê","1996-02-20","9834758375",8000000,"0902948571","be@gmail.com","90 Lê Lợi, Quảng Nam",1,2,3);

-- select * from employee;
-- select * from employee where employee_id = 5;



-- update employee set employee_name ="Nguyễn Văn An" ,employee_birthday="1970-11-07",employee_id_card="456231786",employee_salary="20000000",employee_phone="0901234121",
-- employee_email="annguyen@gmail.com",employee_address="295 Nguyễn Tất Thành, Đà Nẵng",position_id=1,education_degree_id=3,division_id=1
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






