import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TinBds} from "../model/tinBds";
import {FormControl, AbstractControl} from "@angular/forms";

@Injectable({
  providedIn: 'root'
})
export class TinBdsService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<TinBds[]> {
    return this.http.get<TinBds[]>('http://localhost:3000/tinBds');
  }

  save(tinBds: TinBds) {
    return this.http.post<TinBds>('http://localhost:3000/tinBds', tinBds);
  }


  searchAll(searchKey: (FormControl | AbstractControl | string)[]) {
    return this.http.get<any[]>(`http://localhost:3000/tinBds?dienTich_like=${searchKey[0]}&huong_like=${searchKey[1]}&gia_like=${searchKey[2]}`);
  }
}
