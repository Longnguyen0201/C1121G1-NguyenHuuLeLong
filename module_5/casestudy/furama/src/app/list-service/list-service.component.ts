import { Component, OnInit } from '@angular/core';
import {Facility} from '../../models/facility';
import {FacilityService} from '../../services/facility-service';

@Component({
  selector: 'app-list-service',
  templateUrl: './list-service.component.html',
  styleUrls: ['./list-service.component.css']
})
export class ListServiceComponent implements OnInit {
  facilitys: Facility[];
  constructor(private facilityService: FacilityService) {
    this.facilitys = this.facilityService.getFacilityList();
  }

  ngOnInit(): void {
  }

}
