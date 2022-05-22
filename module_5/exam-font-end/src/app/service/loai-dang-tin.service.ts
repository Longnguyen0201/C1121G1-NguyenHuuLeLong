import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {LoaiDangTin} from '../model/loaiDangTin';

@Injectable({
  providedIn: 'root'
})
export class LoaiDangTinService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<LoaiDangTin[]> {
    return this.http.get<LoaiDangTin[]>('http://localhost:8080/loaiDangTin/list');
  }
}
