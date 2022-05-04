create database benh_an;
use benh_an;
create table benh_an(
stt int not null auto_increment ,
ma_benh_an varchar(45),
ma_benh_nhan varchar(45)not null,
ngay_nhap_vien date not null,
ngay_ra_vien date not null,
ly_do varchar(45),
primary key(stt,ma_benh_an),
foreign key (ma_benh_nhan) references benh_nhan(ma_benh_nhan)  on delete cascade on update cascade
);
create table benh_nhan(
ma_benh_nhan varchar(45) primary key,
ho_ten varchar(45) not null
);
DELIMITER //
create trigger xoa_benh_nhan after delete on benh_an
for each row
begin
delete from benh_nhan where ma_benh_an;
end//
DELIMITER ;
drop trigger xoa_benh_nhan;

select stt,ma_benh_an,benh_an.ma_benh_nhan,benh_nhan.ho_ten,ngay_nhap_vien, ngay_ra_vien, ly_do from benh_an
join benh_nhan on benh_an.ma_benh_nhan = benh_nhan.ma_benh_nhan
order by stt;
select * from benh_an
 where ma_benh_an = "BA-001";
 set sql_safe_updates =0;
 delete from benh_an where ma_benh_an = "BA-124"; 


