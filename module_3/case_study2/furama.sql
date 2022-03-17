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
    PRIMARY KEY (employee_id , position_id , education_degree_id , division_id),
    FOREIGN KEY (position_id)
        REFERENCES position (position_id),
    FOREIGN KEY (education_degree_id)
        REFERENCES education_degree (education_degree_id),
    FOREIGN KEY (division_id)
        REFERENCES division (division_id),
	FOREIGN KEY (username)
        REFERENCES user (username)
);
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
    PRIMARY KEY (customer_id , customer_type_id),
    FOREIGN KEY (customer_type_id)
        REFERENCES customer_type (customer_type_id)
);
CREATE TABLE rent_type (
    rent_type_id INT PRIMARY KEY NOT NULL,
    rent_type_name VARCHAR(45),
    rent_type_cost DOUBLE
);
CREATE TABLE service_type (
    service_type_id INT PRIMARY KEY NOT NULL,
    service_type_name VARCHAR(45)
);
CREATE TABLE service (
    service_id INT,
    service_code VARCHAR(10) NOT NULL,
    service_name VARCHAR(45) NOT NULL,
    service_area INT,
    service_cost DOUBLE NOT NULL,
    service_max_people INT,
    rent_type_id INT,
    service_type_id INT,
    standard_room VARCHAR(45),
    description_other_convenience VARCHAR(45),
    pool_eare DATE,
    number_of_floors INT,
    PRIMARY KEY (service_id , rent_type_id , service_type_id),
    FOREIGN KEY (rent_type_id)
        REFERENCES rent_type (rent_type_id),
    FOREIGN KEY (service_type_id)
        REFERENCES service_type (service_type_id)
);
CREATE TABLE contract (
    contract_id INT NOT NULL,
    contract_start_date DATETIME NOT NULL,
    contract_end_date DATETIME NOT NULL,
    contract_deposit DOUBLE NOT NULL,
    contract_total_money DOUBLE NOT NULL,
    employee_id INT,
    customer_id INT,
    service_id INT,
    PRIMARY KEY (contract_id , employee_id , customer_id , service_id),
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
    PRIMARY KEY (contract_detail_id , contract_id , attach_service_id),
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

-- select customer_id,customer_code,customer_name,customer_birthday,customer_gender,customer_id_card, customer_phone,customer_email,
-- customer_address,customer_type.customer_type_name from customer
-- inner join customer_type on customer.customer_type_id = customer_type.customer_type_id
-- order by customer_id;

-- insert into customer (customer_code, customer_name, customer_birthday, customer_gender,customer_id_card, customer_phone,customer_email,customer_address,customer_type_id)
-- value ("KH-0011",'Nguyễn Tâm Long','1989-07-12',1,'344343432','0987654321','dacLong@gmail.com','22 Lê Lợi, Đà Nẵng',2);


