import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Facility} from '../../models/facility';
import {ServiceType} from "../../models/service-type";
import {RentType} from "../../models/rent-type";


@Injectable({
  providedIn: 'root'
})
export class FacilityServiceService {

  constructor(private http: HttpClient) {
  }

  getAllFacility(): Observable<Facility[]> {
    return this.http.get<Facility[]>('http://localhost:3000/service');
  }

  saveFacility(facility: Facility): Observable<Facility> {
    return this.http.post<Facility>('http://localhost:3000/service', facility);
  }

  findById(id: number): Observable<Facility> {
    // @ts-ignore
    return this.http.get(`http://localhost:3000/service/${id}`);
  }

  updateFacility(facility: Facility ): Observable<Facility> {
    return this.http.put<Facility>(`http://localhost:3000/service/${facility.serviceId}`, facility);
  }

  deleteProduct(id: number): Observable<Facility> {
    return this.http.delete<Facility>(`http://localhost:3000/service/${id}`);
  }

  getAllServiceType(): Observable<ServiceType>{
    return  this.http.get<ServiceType>(`http://localhost:3000/serviceType`);
  }
  getAllRentType(): Observable<RentType>{
    return this.http.get<RentType>(`http://localhost:3000/rentType`);
  }
}
