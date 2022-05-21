import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {BenhAnService} from '../../service/benh-an.service';
import {BenhNhanService} from '../../service/benh-nhan.service';
import {BenhNhan} from '../../model/benh-nhan';

@Component({
  selector: 'app-benh-an-edit',
  templateUrl: './benh-an-edit.component.html',
  styleUrls: ['./benh-an-edit.component.scss']
})
export class BenhAnEditComponent implements OnInit {
  benhNhanList: BenhNhan[];
  id: number;

  formEdit: FormGroup = new FormGroup({
    id: new FormControl(''),
    maBenhAn: new FormControl('', [Validators.required, Validators.pattern('^BA-\\d{4}$')]),
    maBenhNhan: new FormControl('', [Validators.required, Validators.pattern('^BN-\\d{4}$')]),
    tenBenhNhan: new FormControl('', [Validators.required, Validators.pattern('^[\\p{Lu}\\p{Ll}]+( [\\p{Lu}\\p{Ll}]+)*$')]),
    ngayNhapVien: new FormControl('', Validators.required),
    ngayRaVien: new FormControl('', Validators.required),
    lyDo: new FormControl('', Validators.required),
    phuongPhapDieuTri: new FormControl('', Validators.required),
    bacSi: new FormControl('', Validators.required)
  });


  get maBenhAn() {
    return this.formEdit.get('maBenhAn');
  }

  get ngayNhapVien() {
    return this.formEdit.get('ngayNhapVien');
  }

  get ngayRaVien() {
    return this.formEdit.get('ngayRaVien');
  }

  get lyDo() {
    return this.formEdit.get('lyDo');
  }

  get phuongPhapDieuTri() {
    return this.formEdit.get('phuongPhapDieuTri');
  }

  get bacSi() {
    return this.formEdit.get('bacSi');
  }

  get maBenhNhan() {
    return this.formEdit.get('maBenhNhan');
  }

  get tenBenhNhan() {
    return this.formEdit.get('tenBenhNhan');
  }

  constructor(private activatedRoute: ActivatedRoute,
              private benhAnService: BenhAnService,
              private benhNhanService: BenhNhanService,
              private route: Router) {
    this.benhNhanService.getAll().subscribe(data => {
      this.benhNhanList = data;
    });
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getFormEdit(this.id);
    });
  }

  ngOnInit(): void {
  }

  private getFormEdit(id: number) {
    return this.benhAnService.findById(id).subscribe(data => {
      this.formEdit = new FormGroup({
        id: new FormControl(data.id),
        maBenhAn: new FormControl(data.maBenhAn, [Validators.required, Validators.pattern('^BA-\\d{4}$')]),
        maBenhNhan: new FormControl(data.maBenhNhan, [Validators.required, Validators.pattern('^BN-\\d{4}$')]),
        tenBenhNhan: new FormControl(data.tenBenhNhan, [Validators.required, Validators.pattern('^([^0-9]*)$')]),
        ngayNhapVien: new FormControl(data.ngayNhapVien, Validators.required),
        ngayRaVien: new FormControl(data.ngayRaVien, Validators.required),
        lyDo: new FormControl(data.lyDo, Validators.required),
        phuongPhapDieuTri: new FormControl(data.phuongPhapDieuTri, Validators.required),
        bacSi: new FormControl(data.bacSi, Validators.required)
      });
    });
  }

  update() {
    const benhAn = this.formEdit.value;
    this.benhAnService.update(benhAn).subscribe(() => {
      alert('Cập nhập thành công');
      this.route.navigateByUrl('/list');
    }, error => {
      console.log(error);
    });
  }
}
