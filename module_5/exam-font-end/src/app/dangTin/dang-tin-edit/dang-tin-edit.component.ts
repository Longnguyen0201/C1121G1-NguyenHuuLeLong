import {Component, OnInit} from '@angular/core';
import {DanhMucService} from '../../service/danh-muc.service';
import {LoaiDangTinService} from '../../service/loai-dang-tin.service';
import {PhuongHuongService} from '../../service/phuong-huong.service';
import {VungMienService} from '../../service/vung-mien.service';
import {DangTinService} from '../../service/dang-tin.service';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {DanhMuc} from '../../model/danhMuc';
import {LoaiDangTin} from '../../model/loaiDangTin';
import {PhuongHuong} from '../../model/phuongHuong';
import {VungMien} from '../../model/vungMien';
import {error} from "@angular/compiler/src/util";

@Component({
  selector: 'app-dang-tin-edit',
  templateUrl: './dang-tin-edit.component.html',
  styleUrls: ['./dang-tin-edit.component.scss']
})
export class DangTinEditComponent implements OnInit {
  id: number;
  danhMucList: DanhMuc[];
  loaiDangTinList: LoaiDangTin[];
  phuongHuongList: PhuongHuong[];
  vungMienList: VungMien[];
  formEdit: FormGroup = new FormGroup({

    tieuDe: new FormControl('', Validators.required),
    noiDung: new FormControl('', Validators.required),
    dienTich: new FormControl('', [Validators.required, Validators.min(20), Validators.pattern('^[0]*[1-9]+[0-9]*([\.]([0-9]+))?$')]),
    giaTien: new FormControl('', [Validators.required, Validators.min(100000000), Validators.pattern('^[0]*[1-9]+[0-9]*([\.]([0-9]+))?$')]),
    diaChi: new FormControl('', Validators.required),
    tinhTrang: new FormControl('', Validators.required),
    doiTuong: new FormControl('', Validators.required),
    danhMuc: new FormControl('', Validators.required),
    loaiDangTin: new FormControl('', Validators.required),
    phuongHuong: new FormControl('', Validators.required),
    vungMien: new FormControl('', Validators.required),
  });
  compareVungMien(t1: VungMien, t2: VungMien): boolean{
    return t1 && t2 ? t1.id === t2.id : t1 === t2;
  }
  compareDanhMuc(t1: DanhMuc, t2: DanhMuc): boolean{
    return t1 && t2 ? t1.id === t2.id : t1 === t2;
  }
  compareLoaiDangTin(t1: LoaiDangTin, t2: LoaiDangTin): boolean{
    return t1 && t2 ? t1.id === t2.id : t1 === t2;
  }
  comparePhuongHuong(t1: PhuongHuong, t2: PhuongHuong): boolean{
    return t1 && t2 ? t1.id === t2.id : t1 === t2;
  }

  get tieuDe() {
    return this.formEdit.get('tieuDe');
  }

  get noiDung() {
    return this.formEdit.get('noiDung');
  }

  get dienTich() {
    return this.formEdit.get('dienTich');
  }

  get giaTien() {
    return this.formEdit.get('giaTien');
  }

  get diaChi() {
    return this.formEdit.get('diaChi');
  }

  get tinhTrang() {
    return this.formEdit.get('tinhTrang');
  }

  get doiTuong() {
    return this.formEdit.get('doiTuong');
  }

  get danhMuc() {
    return this.formEdit.get('danhMuc');
  }

  get loaiDangTin() {
    return this.formEdit.get('loaiDangTin');
  }

  get phuongHuong() {
    return this.formEdit.get('phuongHuong');
  }

  get vungMien() {
    return this.formEdit.get('vungMien');
  }

  constructor(private danhMucService: DanhMucService,
              private loaiDangTinService: LoaiDangTinService,
              private phuongHuongService: PhuongHuongService,
              private vungMienService: VungMienService,
              private dangTinService: DangTinService,
              private route: Router,
              private activatedRoute: ActivatedRoute) {
    this.danhMucService.getAll().subscribe(data => {
      this.danhMucList = data;
    });
    this.loaiDangTinService.getAll().subscribe(data => {
      this.loaiDangTinList = data;
    });
    this.phuongHuongService.getAll().subscribe(data => {
      this.phuongHuongList = data;
    });
    this.vungMienService.getAll().subscribe(data => {
      this.vungMienList = data;
    });
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getDangTin(this.id);
    });
  }

  ngOnInit(): void {
  }

  private getDangTin(id: number) {
    return this.dangTinService.findById(id).subscribe(baidDang => {
      this.formEdit = new FormGroup({
        id: new FormControl(baidDang.id),
        tieuDe: new FormControl(baidDang.tieuDe, Validators.required),
        noiDung: new FormControl(baidDang.noiDung, Validators.required),
        dienTich: new FormControl(baidDang.dienTich, [Validators.required, Validators.min(20), Validators.pattern('^[0]*[1-9]+[0-9]*([\.]([0-9]+))?$')]),
        giaTien: new FormControl(baidDang.giaTien, [Validators.required, Validators.min(100000000), Validators.pattern('^[0]*[1-9]+[0-9]*([\.]([0-9]+))?$')]),
        diaChi: new FormControl(baidDang.diaChi, Validators.required),
        tinhTrang: new FormControl(baidDang.tinhTrang, Validators.required),
        doiTuong: new FormControl(baidDang.doiTuong, Validators.required),
        danhMuc: new FormControl(baidDang.danhMuc, Validators.required),
        loaiDangTin: new FormControl(baidDang.loaiDangTin, Validators.required),
        phuongHuong: new FormControl(baidDang.phuongHuong, Validators.required),
        vungMien: new FormControl(baidDang.vungMien, Validators.required),
      });
    });

  }

  update(id: number) {
    const baiDang = this.formEdit.value;
    this.dangTinService.update(id, baiDang).subscribe(() => {
      alert('cập nhập thành công');
      this.route.navigateByUrl('/list');
    }, e => {
      console.log(e);
    });
  }
}
