import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {VungMien} from '../model/vungMien';

@Injectable({
  providedIn: 'root'
})
export class VungMienService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<VungMien[]> {
    return this.http.get<VungMien[]>('http://localhost:8080/vungMien/list');
  }
}
