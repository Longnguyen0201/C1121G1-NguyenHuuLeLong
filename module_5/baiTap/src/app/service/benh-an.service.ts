import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BenhAn} from '../model/benh-an';
import {Observable} from 'rxjs';
import {AbstractControl, FormControl} from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class BenhAnService {

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<BenhAn[]> {
    return this.http.get<BenhAn[]>('http://localhost:3000/benhAn');
  }

  findById(id: number): Observable<BenhAn> {
    return this.http.get(`http://localhost:3000/benhAn/${id}`);
  }

  update(benhAn: any) {
    return this.http.put<any>(`http://localhost:3000/benhAn/${benhAn.id}`, benhAn);
  }

  delete(idDelete: number) {
    return this.http.delete(`http://localhost:3000/benhAn/${idDelete}`);
  }

  save(benhAn: BenhAn) {
    return this.http.post<BenhAn>('http://localhost:3000/benhAn', benhAn);
  }

  // search(title: string, keySearch: string) {
  //   if (keySearch != null && title != null) {
  //   }
  //   return this.http.get<BenhAn[]>(`http://localhost:3000/benhAn?${title}_like=${keySearch}`);
  // }

  searchAll(searchKey: (string | FormControl | AbstractControl)[]) {
    return this.http.get<BenhAn[]>(`http://localhost:3000/benhAn?maBenhAn_like=${searchKey[0]}&tenBenhNhan_like= ${searchKey[1]}&ngayNhapVien_like=${searchKey[2]}&ngayRaVien_like=${searchKey[3]}&tien=${searchKey[4]}`);
  }
}
