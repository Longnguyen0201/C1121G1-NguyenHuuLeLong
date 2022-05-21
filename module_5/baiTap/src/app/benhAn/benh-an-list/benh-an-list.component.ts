import {Component, OnInit} from '@angular/core';
import {BenhAnService} from '../../service/benh-an.service';
import {BenhAn} from '../../model/benh-an';
import {FormControl, FormGroup} from '@angular/forms';
import {formatDate} from '@angular/common';
import {Router} from '@angular/router';

@Component({
  selector: 'app-benh-an-list',
  templateUrl: './benh-an-list.component.html',
  styleUrls: ['./benh-an-list.component.scss']
})
export class BenhAnListComponent implements OnInit {
  benhAns: BenhAn[];
  idDelete: number;
  maBenhAn: string;
  formSearch: FormGroup = new FormGroup({
    maBenhAn: new FormControl(''),
    tenBenhNhan: new FormControl(''),
    ngayNhapVien: new FormControl(''),
    ngayRaVien: new FormControl(''),
    tien: new FormControl()
  });

  constructor(private benhAnService: BenhAnService,
              private route: Router) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  private getAll() {
    this.benhAnService.getAll().subscribe(data => {
      this.benhAns = data;
    });
  }

  getIdAndName(id: number, maBenhAn: string) {
    this.idDelete = id;
    this.maBenhAn = maBenhAn;
  }

  modalDelete(closeModal: HTMLButtonElement, success: HTMLButtonElement) {
    this.benhAnService.delete(this.idDelete).subscribe(() => {
      closeModal.click();
      success.click();
      this.getAll();
    }, error => {
      console.log(error);
    });
  }

  onSearch(danger: HTMLButtonElement) {
    const search = this.formSearch.value;
    console.log(search);
    // tslint:disable-next-line:radix
    // const  tien = parseInt(search.tien);
    const searchAll = [search.maBenhAn, search.tenBenhNhan, search.ngayNhapVien, search.ngayRaVien, search.tien];
    console.log(searchAll);
    this.benhAnService.searchAll(searchAll).subscribe(data => {
      console.log(data);
      this.benhAns = data;
      if (data.length === 0) {
        this.getAll();
        danger.click();
      }
    });
  }

  confirm() {
    this.ngOnInit();
  }
}
