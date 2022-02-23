create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;
create table class(
class_id int  auto_increment not null primary key,
class_name varchar(60) not null,
start_dat Datetime not null,
`status` bit default 1
);
create table student(
student_id int  auto_increment not null primary key,
student_Name varchar(30) not null,
address varchar(50),
phone varchar(20),
`status` bit ,
Class_Id int not null
);
create table `subject` (
sub_id int auto_increment not null primary key,
sub_name varchar(30) not null,
credit tinyint not null check (credit>= 1) default 1,
`status` bit default 1
);
create table mark (
mark_id int not null primary key auto_increment,
sub_id int not null,
student_id int not null,
mark float default 0 check(mark between 0 and 100),
exam_times tinyint default 1,
unique ( sub_id, student_id ),
foreign key (sub_id) references `subject` (sub_id),
foreign key (student_id) references student( student_id)
);
