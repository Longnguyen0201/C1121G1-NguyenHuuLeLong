import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {PhuongHuong} from '../model/phuongHuong';

@Injectable({
  providedIn: 'root'
})
export class PhuongHuongService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<PhuongHuong[]> {
    return this.http.get<PhuongHuong[]>('http://localhost:8080/phuongHuong/list');
  }
}
