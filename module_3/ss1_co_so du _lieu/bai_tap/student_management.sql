use student_management;
create table Class(
`ID` INT not null primary key,
`name` varchar(45) null
);
create table Teacher(
`ID` INT not null primary key,
`name` varchar(45) null,
`Age` INT not null,
`Country` varchar(45) null
);
