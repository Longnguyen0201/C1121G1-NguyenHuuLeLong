import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {TinBdsService} from "../../service/tin-bds.service";
import {Router} from "@angular/router";
import {DangTin} from "../../model/dangTin";

@Component({
  selector: 'app-child-component-create',
  templateUrl: './child-component-create.component.html',
  styleUrls: ['./child-component-create.component.scss']
})
export class ChildComponentCreateComponent implements OnInit {
  tinBds: DangTin;


  // @ts-ignore
  formCreate: FormGroup = new FormGroup({
    id: new FormControl(),
    danhMuc: new FormControl ("Nhà Đất"),
    vungMien: new FormControl('Hà Nội'),
    loai: new FormControl('Cá nhân', [Validators.required]),
    dangTin: new FormControl('Cần bán'),
      tinhTrang: new FormControl('Mới', Validators.required),
    diaChi: new FormControl('', Validators.required),
    dienTich: new FormControl('', [Validators.required, Validators.pattern('^[0]*[1-9]+[0-9]*([\.]([0-9]+))?$')]),
    huong: new FormControl('Đông', Validators.required),
    tuaDe: new FormControl('', Validators.required),
    noiDung: new FormControl('', Validators.required),
    gia: new FormControl('',[Validators.required, Validators.pattern('^[0]*[1-9]+[0-9]*([\.]([0-9]+))?$')]),
  });

  get id() {
    return this.formCreate.get('id');
  }

  get danhMuc() {
    return this.formCreate.get('danhMuc');
  }

  get vungMien() {
    return this.formCreate.get('vungMien');
  }

  get loai() {
    return this.formCreate.get('loai');
  }

  get dangTin() {
    return this.formCreate.get('dangTin');
  }

  get tinhTrang() {
    return this.formCreate.get('tinhTrang');
  }

  get diaChi() {
    return this.formCreate.get('diaChi');
  }

  get huong() {
    return this.formCreate.get('huong');
  }
  get tuaDe() {
    return this.formCreate.get('tuaDe');
  }
  get noiDung() {
    return this.formCreate.get('noiDung');
  }
  get gia() {
    return this.formCreate.get('gia');
  }
  get dienTich() {
    return this.formCreate.get('dienTich');
  }



  constructor( private tinBdsService: TinBdsService,
               private route: Router) { }

  ngOnInit(): void {
  }

  create(){
    this.tinBds = this.formCreate.value;
    this.tinBdsService.save(this.tinBds).subscribe(() => {
      this.formCreate.reset();
      this.route.navigateByUrl('list');
    }, error => {
      console.log(error);
    });

  }

}
