import { Component, OnInit } from '@angular/core';
import {Facility} from '../../../models/facility';
import {FacilityServiceService} from '../../service/facility-service.service';


@Component({
  selector: 'app-list-service',
  templateUrl: './list-service.component.html',
  styleUrls: ['./list-service.component.css']
})
export class ListServiceComponent implements OnInit {
  facilitys: Facility[];
  page = 0;
  keyName: string;
  constructor(private facilityService: FacilityServiceService) {

  }

  ngOnInit(): void {
    this.getAll();
  }

  private getAll() {
    this.facilityService.getAllFacility().subscribe(facility => {this.facilitys = facility; });
  }

  search() {
    if (this.keyName === ''){
      this.ngOnInit();
    } else {
      this.facilitys = this.facilitys.filter(facilities => {
        return facilities.serviceName.toLocaleLowerCase().match(this.keyName.toLocaleLowerCase());
      });
    }
  }
}
