create database ERD_mo_hinh_quan_he;
create table phieu_xuat(
so_phieu_xuat int not null primary key,
ngay_xuat date not null
);
create table vat_tu(
ma_vat_tu int not null primary key,
ten_vat_tu varchar(40) not null
);
create table phieu_nhap(
so_phieu_nhap int not null primary key,
ngay_nhap date not null
);
create table nha_cung_cap(
ma_nha_cc int not null primary key,
ten_nha_cc varchar(50),
dia_chi varchar(60),
sdt varchar(15)
);
create table don_dat_hang(
so_don_hang int not null primary key,
ngay_dat_hang date not null,
ma_nha_cc int 
);
create table chi_tiet_phieu_xuat(
so_phieu_xuat int,
ma_vat_tu int,
primary key (so_phieu_xuat,ma_vat_tu),
DGXuat int ,
SL_xuat int,
foreign key (so_phieu_xuat) references phieu_xuat (so_phieu_xuat),
foreign key (ma_vat_tu) references vat_tu (ma_vat_tu)
);
create table chi_tiet_phieu_nhap(
so_phieu_nhap int,
ma_vat_tu int,
primary key(so_phieu_nhap, ma_vat_tu),
DG_nhap int,
SL_nhap int,
foreign key (so_phieu_nhap) references phieu_nhap(so_phieu_nhap),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
);
create table chi_tiet_don_dat_hang(
so_don_hang int,
ma_vat_tu int,
primary key (so_don_hang, ma_vat_tu),
foreign key (so_don_hang) references don_dat_hang(so_don_hang),
foreign key (ma_vat_tu) references vat_tu(ma_vat_tu)
);
create table cung_cap(
ma_nha_cc int ,
so_don_hang int primary key ,
foreign key (so_don_hang) references don_dat_hang(so_don_hang),
foreign key (ma_nha_cc) references nha_cung_cap(ma_nha_cc)
);

