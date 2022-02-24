create database ss2_quan_ly_ban_hang;

create table cutomer(
cID int not null primary key auto_increment,
cName varchar(50),
cAge varchar(10)
);

create table `order`(
oID int not null primary key auto_increment,
cID int not null,
oDate date,
oTotalPrice double,
foreign key (cID) references cutomer(cID)
);
create table product(
pID int not null primary key auto_increment,
pName varchar(40),
pPrice double
);
create table orderDetail(
oID int,
pID int,
odQty varchar(40),
primary key(oID, pID),
foreign key (oID) references `order`(oID),
foreign key (pID) references product(pID)
);

