import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BaiDang} from '../model/baiDang';
import {Observable} from 'rxjs';
import {AbstractControl, FormControl} from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class DangTinService {

  constructor(private http: HttpClient) {
  }

  // tslint:disable-next-line:variable-name
  // getAll(page: number): Observable<any> {
  //   return this.http.get<any>(`http://localhost:8080/baiDang/list?page=${page}`);
  // }

  getCreate(baiDang: BaiDang): Observable<BaiDang> {
    return this.http.post<BaiDang>('http://localhost:8080/baiDang/save', baiDang);
  }

  findById(id: number): Observable<BaiDang> {
    return this.http.get<BaiDang>(`http://localhost:8080/baiDang/edit/${id}`);
  }

  update(id: number, baiDang: BaiDang): Observable<BaiDang> {
    return this.http.put<BaiDang>(`http://localhost:8080/baiDang/update/${id}`, baiDang);
  }

  delete(id: number): Observable<BaiDang> {
    return this.http.delete<BaiDang>(`http://localhost:8080/baiDang/delete/${id}`);
  }


  getAll(page: number, dienTich: string, tenHuong: string, giaTien: string): Observable<any> {
    // tslint:disable-next-line:max-line-length
    return this.http.get<any>(`http://localhost:8080/baiDang/list?page=${page}&dienTich=${dienTich}&tenHuong=${tenHuong}&giaTien=${giaTien}`);
  }
}
