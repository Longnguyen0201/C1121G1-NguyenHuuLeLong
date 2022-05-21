import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {BenhAn} from '../../model/benh-an';
import {BenhAnService} from '../../service/benh-an.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-benh-an-create',
  templateUrl: './benh-an-create.component.html',
  styleUrls: ['./benh-an-create.component.scss']
})
export class BenhAnCreateComponent implements OnInit {
   benhAn: BenhAn;
  formCreate: FormGroup = new FormGroup({
    id: new FormControl(''),
    maBenhAn: new FormControl('', [Validators.required, Validators.pattern('^BA-\\d{4}$')]),
    maBenhNhan: new FormControl('', [Validators.required, Validators.pattern('^BN-\\d{4}$')]),
    tenBenhNhan: new FormControl('', [Validators.required, Validators.pattern('^([^0-9]*)$')]),
    ngayNhapVien: new FormControl('', Validators.required),
    ngayRaVien: new FormControl('', Validators.required),
    lyDo: new FormControl('', Validators.required),
    phuongPhapDieuTri: new FormControl('', Validators.required),
    bacSi: new FormControl('', Validators.required)
  });

  get maBenhAn() {
    return this.formCreate.get('maBenhAn');
  }

  get ngayNhapVien() {
    return this.formCreate.get('ngayNhapVien');
  }

  get ngayRaVien() {
    return this.formCreate.get('ngayRaVien');
  }

  get lyDo() {
    return this.formCreate.get('lyDo');
  }

  get phuongPhapDieuTri() {
    return this.formCreate.get('phuongPhapDieuTri');
  }

  get bacSi() {
    return this.formCreate.get('bacSi');
  }

  get maBenhNhan() {
    return this.formCreate.get('maBenhNhan');
  }

  get tenBenhNhan() {
    return this.formCreate.get('tenBenhNhan');
  }

  validateEndDateBefore() {
    let date1 = new Date(this.formCreate.get('ngayNhapVien').value);
    let date2 = new Date(this.formCreate.get('ngayRaVien').value);
    if (date1?.getTime() >= date2?.getTime()) {
      this.formCreate.get('ngayRaVien').setErrors({endDateBefore: true});
    }
  }
  validateStartDateBefore() {
    let date1 = new Date(this.formCreate.get('ngayNhapVien').value);
    console.log(date1);
    let today = new Date();
    console.log(today);
    if (date1?.getTime() <= today?.getTime()) {
      this.formCreate.get('ngayNhapVien').setErrors({startDateBefore: true});
    }
  }

  constructor(private benhAnService: BenhAnService,
              private route: Router) { }

  ngOnInit(): void {
  }

  create(successCreat: HTMLButtonElement) {
    this.benhAn = this.formCreate.value;
    this.benhAnService.save(this.benhAn).subscribe(() => {
      this.formCreate.reset();
      successCreat.click();
    }, error => {
      console.log(error);
    });
    // this.route.navigateByUrl('list');
  }

  onSubmit() {
    this.route.navigateByUrl('list');
  }
}
