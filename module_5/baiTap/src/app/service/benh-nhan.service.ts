import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {BenhAn} from '../model/benh-an';

@Injectable({
  providedIn: 'root'
})
export class BenhNhanService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<BenhAn[]> {
    return this.http.get<BenhAn[]>('http://localhost:3000/benhNhan');
  }
}
