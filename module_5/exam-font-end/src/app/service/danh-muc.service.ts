import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {DanhMuc} from '../model/danhMuc';

@Injectable({
  providedIn: 'root'
})
export class DanhMucService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<DanhMuc[]> {
    return this.http.get<DanhMuc[]>('http://localhost:8080/danhMuc/list');
  }
}
