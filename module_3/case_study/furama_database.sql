create database case_study;
use case_study;
CREATE TABLE vi_tri (
    ma_vi_tri INT NOT NULL PRIMARY KEY,
    ten_vi_tri VARCHAR(45)
);
CREATE TABLE trinh_do (
    ma_trinh_do INT NOT NULL PRIMARY KEY,
    ten_trinh_do VARCHAR(45)
);
CREATE TABLE bo_phan (
    ma_bo_phan INT NOT NULL PRIMARY KEY,
    ten_bo_phan VARCHAR(45)
);
CREATE TABLE nhan_vien (
    ma_nhan_vien INT NOT NULL,
    ho_ten VARCHAR(45) NOT NULL,
    ngay_sinh DATE NOT NULL,
    so_cmnd VARCHAR(45) NOT NULL,
    luong DOUBLE NOT NULL,
    so_dien_thoai VARCHAR(45) NOT NULL,
    email VARCHAR(45),
    dia_chi VARCHAR(45),
    ma_vi_tri INT NOT NULL,
    ma_trinh_do INT NOT NULL,
    ma_bo_phan INT NOT NULL,
    PRIMARY KEY (ma_nhan_vien , ma_vi_tri , ma_trinh_do , ma_bo_phan),
    FOREIGN KEY (ma_vi_tri)
        REFERENCES vi_tri (ma_vi_tri),
    FOREIGN KEY (ma_trinh_do)
        REFERENCES trinh_do (ma_trinh_do),
    FOREIGN KEY (ma_bo_phan)
        REFERENCES bo_phan (ma_bo_phan)
);
CREATE TABLE loai_khach (
    ma_loai_khach INT PRIMARY KEY NOT NULL,
    ten_loai_khach VARCHAR(45)
);
CREATE TABLE khach_hang (
    ma_khach_hang INT NOT NULL,
    ma_loai_khach INT NOT NULL,
    ho_ten VARCHAR(45) NOT NULL,
    ngay_sinh DATE NOT NULL,
    gioi_tinh BIT(1) NOT NULL,
    so_cmnd VARCHAR(45) NOT NULL,
    so_dien_thoai VARCHAR(45) NOT NULL,
    email VARCHAR(45),
    dia_chi VARCHAR(45),
    PRIMARY KEY (ma_khach_hang , ma_loai_khach),
    FOREIGN KEY (ma_loai_khach)
        REFERENCES loai_khach (ma_loai_khach)
);
CREATE TABLE kieu_thue (
    ma_kieu_thue INT PRIMARY KEY NOT NULL,
    ten_kieu_thue VARCHAR(45)
);
CREATE TABLE loai_dich_vu (
    ma_loai_dich_vu INT PRIMARY KEY NOT NULL,
    ten_loai_dich_vu VARCHAR(45)
);
CREATE TABLE dich_vu (
    ma_dich_vu INT,
    ten_dich_vu VARCHAR(45) NOT NULL,
    dien_tich INT,
    chi_phi_thue DOUBLE NOT NULL,
    so_nguoi_toi_da INT,
    ma_kieu_thue INT,
    ma_loai_dich_vu INT,
    tieu_chuan_phong VARCHAR(45),
    mo_ta_tien_nghi_khac VARCHAR(45),
    dien_tich_ho_boi DATE,
    so_tang INT,
    PRIMARY KEY (ma_dich_vu , ma_kieu_thue , ma_loai_dich_vu),
    FOREIGN KEY (ma_kieu_thue)
        REFERENCES kieu_thue (ma_kieu_thue),
    FOREIGN KEY (ma_loai_dich_vu)
        REFERENCES loai_dich_vu (ma_loai_dich_vu)
);
CREATE TABLE hop_dong (
    ma_hop_dong INT NOT NULL,
    ngay_lam_hop_dong DATETIME NOT NULL,
    ngay_ket_thuc DATETIME NOT NULL,
    tien_dat_coc DOUBLE NOT NULL,
    ma_nhan_vien INT,
    ma_khach_hang INT,
    ma_dich_vu INT,
    PRIMARY KEY (ma_hop_dong , ma_nhan_vien , ma_khach_hang , ma_dich_vu),
    FOREIGN KEY (ma_nhan_vien)
        REFERENCES nhan_vien (ma_nhan_vien),
    FOREIGN KEY (ma_khach_hang)
        REFERENCES khach_hang (ma_khach_hang),
    FOREIGN KEY (ma_dich_vu)
        REFERENCES dich_vu (ma_dich_vu)
);
CREATE TABLE dich_vu_di_kem (
    ma_dich_vu_di_kem INT PRIMARY KEY,
    ten_dich_vu_di_kem VARCHAR(45) NOT NULL,
    gia DOUBLE NOT NULL,
    don_vi VARCHAR(10) NOT NULL,
    trang_thai VARCHAR(45)
);
CREATE TABLE hop_dong_chi_tiet (
    ma_hop_dong_chi_tiet INT NOT NULL,
    ma_hop_dong INT NOT NULL,
    ma_dich_vu_di_kem INT NOT NULL,
    so_luong INT NOT NULL,
    PRIMARY KEY (ma_hop_dong_chi_tiet , ma_hop_dong , ma_dich_vu_di_kem),
    FOREIGN KEY (ma_dich_vu_di_kem)
        REFERENCES dich_vu_di_kem (ma_dich_vu_di_kem),
    FOREIGN KEY (ma_hop_dong)
        REFERENCES hop_dong (ma_hop_dong)
);
INSERT INTO vi_tri VALUES (1,'Qu???n L??'), (2,'Nh??n Vi??n');
INSERT INTO trinh_do VALUES (1,'Trung C???p'), (2,'Cao ?????ng'), (3,'?????i H???c'), (4,'Sau ?????i H???c');
INSERT INTO bo_phan VALUES (1,'Sale-Marketing'), (2,'H??nh ch??nh'), (3,'Ph???c v???'), (4,'Qu???n l??');
INSERT INTO nhan_vien VALUES 
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

INSERT INTO loai_khach VALUES 
(1,'Diamond'),
(2,'Platinium'),
(3,'Gold'),
(4,'Silver'),
(5,'Member');

INSERT INTO khach_hang VALUES
(1,5,'Nguy???n Th??? H??o','1970-11-07',0,'643431213','0945423362','thihao07@gmail.com','23 Nguy???n Ho??ng, ???? N???ng'),
(2,3,'Ph???m Xu??n Di???u','1992-08-08',1,'865342123','0954333333','xuandieu92@gmail.com','K77/22 Th??i Phi??n, Qu???ng Tr???'),
(3,1,'Tr????ng ????nh Ngh???','1990-02-27',1,'488645199','0373213122','nghenhan2702@gmail.com','K323/12 ??ng ??ch Khi??m, Vinh'),
(4,1,'D????ng V??n Quan','1981-07-08',1,'543432111','0490039241','duongquan@gmail.com','K453/12 L?? L???i, ???? N???ng'),
(5,4,'Ho??ng Tr???n Nhi Nhi','1995-12-09',0,'795453345','0312345678','nhinhi123@gmail.com','224 L?? Th??i T???, Gia Lai'),
(6,4,'T??n N??? M???c Ch??u','2005-12-06',0	,'732434215','0988888844','tonnuchau@gmail.com','37 Y??n Th???, ???? N???ng'),
(7,1,'Nguy???n M??? Kim','1984-04-08',0,'856453123','0912345698','kimcuong84@gmail.com','K123/45 L?? L???i, H??? Ch?? Minh'),
(8,3,'Nguy???n Th??? H??o','1999-04-08',0,'965656433','0763212345','haohao99@gmail.com','55 Nguy???n V??n Linh, Kon Tum'),
(9,1,'Tr???n ?????i Danh','1994-07-01',1,'432341235','0643343433','danhhai99@gmail.com','24 L?? Th?????ng Ki???t, Qu???ng Ng??i'),
(10,2,'Nguy???n T??m ?????c','1989-07-01',1,'344343432','0987654321','dactam@gmail.com','22 Ng?? Quy???n, ???? N???ng');

INSERT INTO kieu_thue VALUES
(1,'year'),
(2,'month'),
(3,'day'),
(4,'hour');
INSERT INTO loai_dich_vu VALUES
(1,'Villa'),
(2,'House'),
(3,'Room');
INSERT INTO dich_vu VALUES
(1,'Villa Beach  Front',25000,10000000,10,3,1,'vip','C?? h??? b??i',500,4),
(2,'House Princess 01',14000,5000000,7,2,2,'vip','C?? th??m b???p n?????ng',null,3),
(3,'Room Twin 01',5000,1000000,2,4,3,'normal','C?? tivi',null,null),
(4,'Villa No Beach Front',22000,9000000,8,3,1,'normal','C?? h??? b??i',300,3),
(5,'House Princess 02',10000,4000000,5,3,2,'normal','C?? th??m b???p n?????ng',null,2),
(6,'Room Twin 02',3000,	900000,2,4,3,'normal','C?? tivi',null,null);

INSERT INTO dich_vu_di_kem VALUES
(1,'Karaoke',10000,'gi???','ti???n nghi,hi???n t???i'),
(2,'Thu?? xe m??y',10000,'chi???c','h???ng 1 xe'),
(3,'Thu?? xe ?????p',20000,'chi???c','t???t'),
(4,'Buffet bu???i s??ng',15000,'su???t','?????y ????? ????? ??n, tr??ng mi???ng'),
(5,'Buffet bu???i tr??a',90000,'su???t','?????y ????? ????? ??n, tr??ng mi???ng'),
(6,'Buffet bu???i t???i',16000,'su???t','?????y ????? ????? ??n, tr??ng mi???ng');
INSERT INTO hop_dong VALUES
(1,'2020-12-08','2020-12-08',0,3,1,3),
(2,'2020-07-14','2020-07-21',200000,7,3,1),
(3,'2021-03-15','2021-03-17',50000,3,4,2),
(4,'2021-01-14','2021-01-18',100000,7,5,5),
(5,'2021-07-14','2021-07-15',0,7,2,6),
(6,'2021-06-01','2021-06-03',0,7,7,6),
(7,'2021-09-02','2021-09-05',100000,7,4,4),
(8,'2021-06-17','2021-06-18',150000,3,4,1),
(9,'2020-11-19','2020-11-19',0,	3,4,3),
(10,'2021-04-12','2021-04-14',0,10,	3,5),
(11,'2021-04-25','2021-04-25',0,2,2,1),
(12,'2021-05-25','2021-05-27',0	,7,	10,	1);
INSERT INTO hop_dong_chi_tiet VALUES
(1,	2,	4, 5),
(2,	2,	5, 8),
(3,	2,	6, 15),
(4,	3,	1, 1),
(5,	3,	2, 11),
(6,	1,	3, 1),
(7,	1,	2, 2),
(8,	12,	2, 2);

-- C??u 2:
select * from nhan_vien 
where ho_ten like "H%" or ho_ten like "T%" or ho_ten like "K%" and char_length(ho_ten) <= 15 ;

-- C??u 3:
select * from khach_hang
where (dia_chi like "%???? N???ng" or dia_chi like "%Qu???ng Nam") and (round(datediff(curdate(),ngay_sinh)/365,0) between 18 and 50) ;

-- C??u 4 :
select khach_hang.ho_ten, loai_khach.ten_loai_khach, count(khach_hang.ma_khach_hang) as so_lan_dat_phong
from khach_hang
join hop_dong on khach_hang.ma_khach_hang= hop_dong.ma_khach_hang
join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
where loai_khach.ten_loai_khach ="Diamond"
 group by khach_hang.ma_khach_hang
 order by  so_lan_dat_phong;

-- C??u 5:
select khach_hang.ma_khach_hang, khach_hang.ho_ten,loai_khach.ten_loai_khach, hop_dong.ma_hop_dong, dich_vu.ten_dich_vu, hop_dong.ngay_lam_hop_dong,hop_dong.ngay_ket_thuc, (dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong*dich_vu_di_kem.gia )as tong_tien
from khach_hang
left join loai_khach on khach_hang.ma_loai_khach =loai_khach.ma_loai_khach
left join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong =hop_dong_chi_tiet.ma_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
group by hop_dong.ma_hop_dong 
order by khach_hang.ma_khach_hang;

-- C??u 6:
select dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich,dich_vu.chi_phi_thue,loai_dich_vu.ten_loai_dich_vu from dich_vu
inner join loai_dich_vu on loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
inner join hop_dong on hop_dong.ma_dich_vu =dich_vu.ma_dich_vu
where hop_dong.ngay_lam_hop_dong not in (select hop_dong.ngay_lam_hop_dong from hop_dong where hop_dong.ngay_lam_hop_dong between '2021-01-01 00:00:00' and '2021-03-31 23:59:59' group by hop_dong)
group by dich_vu.ma_dich_vu;
 
--  C??u 7:
select dich_vu.ma_dich_vu, dich_vu.ten_dich_vu, dich_vu.dien_tich, dich_vu.so_nguoi_toi_da,dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu from dich_vu
inner join 	hop_dong on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
inner join loai_dich_vu on dich_vu.ma_loai_dich_vu =loai_dich_vu.ma_loai_dich_vu
where (year(hop_dong.ngay_lam_hop_dong) = '2020') and (hop_dong.ngay_lam_hop_dong not in (select hop_dong.ngay_lam_hop_dong from hop_dong where year(hop_dong.ngay_lam_hop_dong) ='2021'))
group by dich_vu.ma_dich_vu; 

-- C??u 8:
-- c??ch 1
select khach_hang.ho_ten from khach_hang
group by ho_ten;
-- c??ch 2
select ho_ten from khach_hang
union
select ho_ten from khach_hang;
-- c??ch 3
select distinct ho_ten from khach_hang ;

-- C??u 9
select month(hop_dong.ngay_lam_hop_dong) as thang ,  count(month(hop_dong.ngay_lam_hop_dong)) as so_luong_khac_hang
from hop_dong
where year(hop_dong.ngay_lam_hop_dong) = '2021'
group by thang 
order by thang;

-- C??u 10:
select hop_dong.ma_hop_dong, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, hop_dong.tien_dat_coc,ifnull(sum(hop_dong_chi_tiet.so_luong),0) as so_luong_dich_vu_di_kem
from hop_dong
left join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
left join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
group by hop_dong.ma_hop_dong;

-- C??u 11:
select hop_dong_chi_tiet.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem 
from loai_khach
inner join khach_hang on loai_khach.ma_loai_khach = khach_hang.ma_loai_khach
inner join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
inner join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
inner join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
where loai_khach.ten_loai_khach = 'Diamond' and (khach_hang.dia_chi like '%Vinh%' or khach_hang.dia_chi like '%Qu??ng Ng??i%')
group by hop_dong_chi_tiet.ma_dich_vu_di_kem;

-- C??u 12
select hop_dong.ma_hop_dong, nhan_vien.ho_ten, khach_hang.ho_ten, khach_hang.so_dien_thoai, dich_vu.ma_dich_vu,dich_vu.ten_dich_vu, sum(hop_dong_chi_tiet.so_luong) as so_luong_dich_vu_di_kem,
hop_dong.tien_dat_coc from hop_dong
inner join nhan_vien on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
inner join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
inner join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
where (hop_dong.ngay_lam_hop_dong between '2020-10-01 00:00:00' and '2020-12-31 23:59:59')
and hop_dong.ngay_lam_hop_dong not in ( select hop_dong.ma_hop_dong from hop_dong where hop_dong.ngay_lam_hop_dong between '2021-01-01 00:00:00' and '2021-06-30 23:59:59')
group by hop_dong.ma_hop_dong;

-- C??u 13
select dich_vu_di_kem.ma_dich_vu_di_kem, dich_vu_di_kem.ten_dich_vu_di_kem, sum(hop_dong_chi_tiet.so_luong) as so_luong_dich_vu_di_kem
from dich_vu_di_kem
inner join hop_dong_chi_tiet on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
group by dich_vu_di_kem.ma_dich_vu_di_kem
having so_luong_dich_vu_di_kem >= all (select sum(hop_dong_chi_tiet.so_luong) from hop_dong_chi_tiet group by hop_dong_chi_tiet.ma_dich_vu_di_kem);

-- C??u 14
select hop_dong.ma_hop_dong, loai_dich_vu.ten_loai_dich_vu,dich_vu_di_kem.ten_dich_vu_di_kem, count(dich_vu_di_kem.ma_dich_vu_di_kem) as so_lan_su_dung
from hop_dong
inner join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
inner join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem =dich_vu_di_kem.ma_dich_vu_di_kem
inner join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
inner join loai_dich_vu on dich_vu.ma_loai_dich_vu=loai_dich_vu.ma_loai_dich_vu
group by ten_dich_vu_di_kem
having so_lan_su_dung = 1
order by ma_hop_dong;

-- C??u 15
select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, trinh_do.ten_trinh_do, bo_phan.ten_bo_phan,nhan_vien.so_dien_thoai,nhan_vien.dia_chi from nhan_vien
inner join trinh_do on nhan_vien.ma_trinh_do =trinh_do.ma_trinh_do
inner join bo_phan on nhan_vien.ma_bo_phan = bo_phan.ma_bo_phan
inner join hop_dong on nhan_vien.ma_nhan_vien= hop_dong.ma_nhan_vien
where year(hop_dong.ngay_lam_hop_dong) between 2020 and 2021
group by nhan_vien.ma_nhan_vien
having count(hop_dong.ma_hop_dong) <=3
order by ma_nhan_vien;

-- C??u 16
-- ch???n nh??n vi??n se b??? x??a 
select nhan_vien.ma_nhan_vien,nhan_vien.ho_ten from nhan_vien
where nhan_vien.ma_nhan_vien not in ( select ma_nhan_vien from hop_dong where year(ngay_lam_hop_dong) between 2019 and 2021);
-- X??A
set sql_safe_updates =0;
delete from nhan_vien
where nhan_vien.ma_nhan_vien not in ( select ma_nhan_vien from hop_dong where year(ngay_lam_hop_dong) between 2019 and 2021);
set sql_safe_updates =1;

-- C??u 17:

-- T???o b???ng t???m temporary
create temporary table update_loai_khach_hang
select khach_hang.ma_khach_hang from hop_dong
join khach_hang on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
join hop_dong_chi_tiet on hop_dong.ma_hop_dong =hop_dong_chi_tiet.ma_hop_dong
join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
join dich_vu on hop_dong.ma_dich_vu =dich_vu.ma_dich_vu
where year(hop_dong.ngay_lam_hop_dong) = 2021 and (dich_vu.chi_phi_thue + hop_dong_chi_tiet.so_luong*dich_vu_di_kem.gia) > 10000000
group by ma_khach_hang;
-- update ten_loai_khach t??? Platinum l??n Diamond

 update khach_hang 
 set khach_hang.ma_loai_khach = 1
 where khach_hang.ma_khach_hang = (select *from update_loai_khach_hang);
set sql_safe_updates =1;

-- C??u 18
-- select khach_hang.ma_khach_hang, khach_hang.ho_ten from hop_dong
-- join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
-- where year(hop_dong.ngay_lam_hop_dong) < 2021;

set foreign_key_checks = 0;
delete from khach_hang
where khach_hang.ma_khach_hang in (select hop_dong.ma_khach_hang from hop_dong where year(hop_dong.ngay_lam_hop_dong) < 2021);
set foreign_key_checks = 1;

-- C??u 19
create temporary table update_gia_dich_vu_di_kem
select dich_vu_di_kem.ma_dich_vu_di_kem
from hop_dong_chi_tiet
join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
join hop_dong on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
where hop_dong_chi_tiet.so_luong > 10 and year(ngay_lam_hop_dong) = 2020
group by ma_dich_vu_di_kem;

 set sql_safe_updates = 0;
 update dich_vu_di_kem
 set dich_vu_di_kem.gia = gia * 2
 where dich_vu_di_kem.ma_dich_vu_di_kem in(select*from update_gia_dich_vu_di_kem);
set sql_safe_updates = 1;

-- C??u 20
select ma_nhan_vien, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi , "nh??n vi??n" as 'role' from nhan_vien 
union all
select ma_khach_hang, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi,"kh??ch h??ng" as 'role' from khach_hang;

-- C??u 21
create view v_nhan_vien as
select nhan_vien.ma_nhan_vien, nhan_vien.ho_ten, nhan_vien.dia_chi, hop_dong.ngay_lam_hop_dong from nhan_vien
join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
where nhan_vien.dia_chi like '%Hu???' and hop_dong.ngay_lam_hop_dong = '2020-07-14 00:00:00' 
group by ho_ten;
drop view  v_nhan_vien;

select * from v_nhan_vien;