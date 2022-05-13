import {Component, OnInit} from '@angular/core';
import {RentType} from '../../models/rent-type';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {RentTypeService} from '../../services/rent-type-service';
import {Facility} from '../../models/facility';
import {FacilityService} from '../../services/facility-service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-edit-service',
  templateUrl: './edit-service.component.html',
  styleUrls: ['./edit-service.component.css']
})
export class EditServiceComponent implements OnInit {
  id: number;
  RentTypeList: RentType[];
  serviceList: Facility[];
  serviceObj: Facility;
  formServiceEdit: FormGroup = new FormGroup({
    serviceType: new FormControl('', [Validators.required]),
    serviceCode: new FormControl('', [Validators.required]),
    serviceName: new FormControl('', [Validators.required]),
    serviceArea: new FormControl('', [Validators.required]),
    servicePrice: new FormControl('', [Validators.required]),
    serviceMaxPeople: new FormControl('', [Validators.required]),
    serviceStandRoom: new FormControl('', [Validators.required]),
    serviceDescribe: new FormControl('', [Validators.required]),
    serviceRentType: new FormControl('', [Validators.required]),
    serviceAreaPool: new FormControl('', [Validators.required]),
    serviceFloor: new FormControl('', [Validators.required]),
    serviceImg: new FormControl('', [Validators.required])
  });

  get serviceType() {
    return this.formServiceEdit.get('serviceType');
  }

  get serviceCode() {
    return this.formServiceEdit.get('serviceCode');
  }

  get serviceName() {
    return this.formServiceEdit.get('serviceName');
  }

  get serviceArea() {
    return this.formServiceEdit.get('serviceArea');
  }

  get servicePrice() {
    return this.formServiceEdit.get('servicePrice');
  }

  get serviceMaxPeople() {
    return this.formServiceEdit.get('serviceMaxPeople');
  }

  get serviceStandRoom() {
    return this.formServiceEdit.get('serviceStandRoom');
  }

  get serviceDescribe() {
    return this.formServiceEdit.get('serviceDescribe');
  }

  get serviceAreaPool() {
    return this.formServiceEdit.get('serviceAreaPool');
  }

  get serviceFloor() {
    return this.formServiceEdit.get('serviceFloor');
  }

  get serviceRentType() {
    return this.formServiceEdit.get('serviceRentType');
  }

  get serviceImg() {
    return this.formServiceEdit.get('serviceImg');
  }

  constructor(private rentTypeService: RentTypeService,
              private facilityService: FacilityService,
              private activatedRoute: ActivatedRoute) {
    this.RentTypeList = this.rentTypeService.getRentTypeList();
  }

  ngOnInit(): void {
    this.serviceList = this.facilityService.getFacilityList();
    this.id = this.activatedRoute.snapshot.params.id;
    console.log(this.id);
    // tslint:disable-next-line:triple-equals
    this.serviceObj = this.serviceList.filter( (e) => e.serviceId == this.id)[0];
    this.formServiceEdit.patchValue(this.serviceObj);
  }

  onSubmit() {
    console.log(this.formServiceEdit);
  }
}
