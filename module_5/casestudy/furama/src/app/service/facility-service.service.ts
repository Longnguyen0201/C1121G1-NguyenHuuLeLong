import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Facility} from '../../models/facility';


@Injectable({
  providedIn: 'root'
})
export class FacilityServiceService {

  constructor(private http: HttpClient) { }

  getAllFacility(): Observable<Facility[]> {
    return this.http.get<Facility[]>('http://localhost:3000/service');
  }
}
