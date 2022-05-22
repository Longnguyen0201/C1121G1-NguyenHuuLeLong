import {Component, OnInit} from '@angular/core';
import {DangTinService} from '../../service/dang-tin.service';
import {BaiDang} from '../../model/baiDang';
import {FormControl, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-dang-tin-list',
  templateUrl: './dang-tin-list.component.html',
  styleUrls: ['./dang-tin-list.component.scss']
})
export class DangTinListComponent implements OnInit {
  baiDangs: BaiDang[];
  baiDang: BaiDang;
  number = 0;
  totalPage = 0;
  formSearch: FormGroup = new FormGroup({
    dienTich: new FormControl(''),
    tenHuong: new FormControl(''),
    giaTien: new FormControl(''),
  });


  constructor(private dangTinService: DangTinService) {
  }

  ngOnInit(): void {
    this.getAllList('', '', '');
  }

  private getAllList(dienTich: string, tenHuong: string, giaTien: string) {
    this.dangTinService.getAll(this.number, dienTich, tenHuong, giaTien).subscribe(data => {
      this.baiDangs = data.content;
      this.number = data.number;
      this.totalPage = data.totalPages;
    });
  }

  previous() {
    if (this.number > 0) {
      console.log('hihi');
      this.number--;
      this.getAllList(this.formSearch.value.dienTich, this.formSearch.value.tenHuong, this.formSearch.value.giaTien);
    }
  }

  next() {
    if (this.number < this.totalPage - 1) {
      this.number++;
      this.getAllList(this.formSearch.value.dienTich, this.formSearch.value.tenHuong, this.formSearch.value.giaTien);
    }
  }

  getBaiDAng(bds: BaiDang) {
    this.baiDang = bds;
  }

  modalDelete(closeModal: HTMLButtonElement) {
    this.dangTinService.delete(this.baiDang.id).subscribe(() => {
      closeModal.click();
      alert('Xóa thành công');
      this.getAllList('', '', '');
    }, error => {
      console.log(error);
    });

  }

  onSearch() {
    const search = this.formSearch.value;
    console.log(search);
    this.getAllList(this.formSearch.value.dienTich, this.formSearch.value.tenHuong, this.formSearch.value.giaTien);
  }
}
