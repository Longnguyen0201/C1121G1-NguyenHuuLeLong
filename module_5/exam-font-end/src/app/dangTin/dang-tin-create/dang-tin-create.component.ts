import {Component, OnInit} from '@angular/core';
import {DanhMucService} from '../../service/danh-muc.service';
import {LoaiDangTinService} from '../../service/loai-dang-tin.service';
import {PhuongHuongService} from '../../service/phuong-huong.service';
import {VungMienService} from '../../service/vung-mien.service';
import {DanhMuc} from '../../model/danhMuc';
import {LoaiDangTin} from '../../model/loaiDangTin';
import {PhuongHuong} from '../../model/phuongHuong';
import {VungMien} from '../../model/vungMien';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {BaiDang} from '../../model/baiDang';
import {DangTinService} from '../../service/dang-tin.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-dang-tin-create',
  templateUrl: './dang-tin-create.component.html',
  styleUrls: ['./dang-tin-create.component.scss']
})
export class DangTinCreateComponent implements OnInit {
  danhMucList: DanhMuc[];
  loaiDangTinList: LoaiDangTin[];
  phuongHuongList: PhuongHuong[];
  vungMienList: VungMien[];
  baiDang: BaiDang;

  formCreate: FormGroup = new FormGroup({
    id: new FormControl(),
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

  get id() {
    return this.formCreate.get('id');
  }

  get tieuDe() {
    return this.formCreate.get('tieuDe');
  }

  get noiDung() {
    return this.formCreate.get('noiDung');
  }

  get dienTich() {
    return this.formCreate.get('dienTich');
  }

  get giaTien() {
    return this.formCreate.get('giaTien');
  }

  get diaChi() {
    return this.formCreate.get('diaChi');
  }

  get tinhTrang() {
    return this.formCreate.get('tinhTrang');
  }

  get doiTuong() {
    return this.formCreate.get('doiTuong');
  }

  get danhMuc() {
    return this.formCreate.get('danhMuc');
  }

  get loaiDangTin() {
    return this.formCreate.get('loaiDangTin');
  }

  get phuongHuong() {
    return this.formCreate.get('phuongHuong');
  }

  get vungMien() {
    return this.formCreate.get('vungMien');
  }

  constructor(private danhMucService: DanhMucService,
              private loaiDangTinService: LoaiDangTinService,
              private phuongHuongService: PhuongHuongService,
              private vungMienService: VungMienService,
              private dangTinService: DangTinService,
              private route: Router) {
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
  }

  ngOnInit(): void {
  }

  create() {
    this.baiDang = this.formCreate.value;
    console.log(this.baiDang);
    this.dangTinService.getCreate(this.baiDang).subscribe(() => {
      this.formCreate.reset();
      alert('tạo thành công');
      this.route.navigateByUrl('/list');
    }, error => {
      console.log(error);
    });

  }
}
