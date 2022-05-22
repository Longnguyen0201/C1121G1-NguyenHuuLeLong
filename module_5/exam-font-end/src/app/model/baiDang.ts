import {DanhMuc} from './danhMuc';
import {LoaiDangTin} from './loaiDangTin';
import {PhuongHuong} from './phuongHuong';
import {VungMien} from './vungMien';

export interface BaiDang {
  id?: number;
  tieuDe?: string;
  noiDung?: string;
  dienTich?: number;
  giaTien?: number;
  diaChi?: string;
  tinhTrang?: number;
  doiTuong?: number;
  danhMuc?: DanhMuc;
  loaiDangTin?: LoaiDangTin;
  phuongHuong?: PhuongHuong;
  vungMien?: VungMien;
}
