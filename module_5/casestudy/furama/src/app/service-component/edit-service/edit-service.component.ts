import {Component, OnInit} from '@angular/core';
import {RentType} from '../../../models/rent-type';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Facility} from '../../../models/facility';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FacilityServiceService} from '../../service/facility-service.service';
import {ServiceType} from '../../../models/service-type';

@Component({
  selector: 'app-edit-service',
  templateUrl: './edit-service.component.html',
  styleUrls: ['./edit-service.component.css']
})
export class EditServiceComponent implements OnInit {
  rentTypeList: RentType;
  serviceTypes: ServiceType;
  id: number;
  serviceObj: Facility;
  formServiceEdit: FormGroup = new FormGroup({
    id: new FormControl(''),
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

  constructor(private facilityService: FacilityServiceService,
              private activatedRoute: ActivatedRoute,
              private route: Router) {
    this.facilityService.getAllServiceType().subscribe(serviceType => {
      this.serviceTypes = serviceType;
      this.formServiceEdit.get('serviceType').setValue(this.serviceTypes[0]);
    }, error => {
      console.log(error);
    });
    this.facilityService.getAllRentType().subscribe(rentType => {
      this.rentTypeList = rentType;
      this.formServiceEdit.get('serviceRentType').setValue(this.rentTypeList[0]);
    }, error => {
      console.log(error);
    });
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.facilityService.findById(this.id).subscribe(data => {
        // console.log(data);
        this.formServiceEdit.get('id').setValue(data.id);
        this.formServiceEdit.get('serviceType').setValue(data.serviceType);
        this.formServiceEdit.get('serviceCode').setValue(data.serviceCode);
        this.formServiceEdit.get('serviceName').setValue(data.serviceName);
        this.formServiceEdit.get('serviceArea').setValue(data.serviceArea);
        this.formServiceEdit.get('servicePrice').setValue(data.servicePrice);
        this.formServiceEdit.get('serviceMaxPeople').setValue(data.serviceMaxPeople);
        this.formServiceEdit.get('serviceStandRoom').setValue(data.serviceStandRoom);
        this.formServiceEdit.get('serviceDescribe').setValue(data.serviceDescribe);
        this.formServiceEdit.get('serviceRentType').setValue(data.serviceRentType);
        this.formServiceEdit.get('serviceAreaPool').setValue(data.serviceAreaPool);
        this.formServiceEdit.get('serviceFloor').setValue(data.serviceFloor);
        this.formServiceEdit.get('serviceImg').setValue(data.serviceImg);
      }, error => {
        console.log(error);
      });
    }, error => {
      console.log(error);
    });

  }

  ngOnInit(): void {
    // this.serviceList = this.facilityService.getFacilityList();
    // this.id = this.activatedRoute.snapshot.params.id;
    // console.log(this.id);
    // // tslint:disable-next-line:triple-equals
    // this.serviceObj = this.serviceList.filter( (e) => e.serviceId == this.id)[0];
    // this.formServiceEdit.patchValue(this.serviceObj);
  }

  onSubmit() {
    const facility = this.formServiceEdit.value;
    console.log(facility);
    this.facilityService.updateFacility(facility).subscribe(() => {
      this.route.navigateByUrl('list-service');
      alert('Update success');
    }, error => {
      console.log(error);
    });
  }
}
