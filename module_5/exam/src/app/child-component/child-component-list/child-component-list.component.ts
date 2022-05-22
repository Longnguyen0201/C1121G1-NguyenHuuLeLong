import {Component, OnInit} from '@angular/core';
import {TinBdsService} from "../../service/tin-bds.service";
import {DangTin} from "../../model/dangTin";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-child-component-list',
  templateUrl: './child-component-list.component.html',
  styleUrls: ['./child-component-list.component.scss']
})
export class ChildComponentListComponent implements OnInit {
  tinBds: DangTin[];
  formSearch: FormGroup = new FormGroup({
    dienTich: new FormControl(''),
    huong: new FormControl(''),
    gia: new FormControl('')
  });

  constructor(private tinBdsService: TinBdsService) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  private getAll() {
    this.tinBdsService.getAll().subscribe(data => {
      this.tinBds = data;
    });
  }

  onSearch() {
    const search = this.formSearch.value;
    console.log(search);
    // tslint:disable-next-line:radix
    // const  tien = parseInt(search.tien);
    const searchAll = [search.dienTich, search.huong, search.gia];
    console.log(searchAll);
    this.tinBdsService.searchAll(searchAll).subscribe(data => {
      console.log(data);
      this.tinBds = data;
      console.log("hihi")
      console.log(this.tinBds);
      if (data.length === 0) {
        this.getAll();
      }
    });
  }
}
