import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {RentType} from '../../models/rent-type';
import {RentTypeService} from '../../services/rent-type-service';
import {FacilityServiceService} from '../service/facility-service.service';
import {ServiceType} from '../../models/service-type';
import {Facility} from '../../models/facility';
import {Router} from '@angular/router';

@Component({
  selector: 'app-create-service',
  templateUrl: './create-service.component.html',
  styleUrls: ['./create-service.component.css']
})
export class CreateServiceComponent implements OnInit {
  rentTypeList: RentType;
  serviceTypes: ServiceType;
  facility: Facility;
  formServiceCreate: FormGroup = new FormGroup({
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
    serviceImg: new FormControl('https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Ocean-Studio-Suite-F-370x239.jpg', [Validators.required])
  });

  get serviceType() {
    return this.formServiceCreate.get('serviceType');
  }

  get serviceCode() {
    return this.formServiceCreate.get('serviceCode');
  }

  get serviceName() {
    return this.formServiceCreate.get('serviceName');
  }

  get serviceArea() {
    return this.formServiceCreate.get('serviceArea');
  }

  get servicePrice() {
    return this.formServiceCreate.get('servicePrice');
  }

  get serviceMaxPeople() {
    return this.formServiceCreate.get('serviceMaxPeople');
  }

  get serviceStandRoom() {
    return this.formServiceCreate.get('serviceStandRoom');
  }

  get serviceDescribe() {
    return this.formServiceCreate.get('serviceDescribe');
  }

  get serviceAreaPool() {
    return this.formServiceCreate.get('serviceAreaPool');
  }

  get serviceFloor() {
    return this.formServiceCreate.get('serviceFloor');
  }

  get serviceRentType() {
    return this.formServiceCreate.get('serviceRentType');
  }

  get serviceImg() {
    return this.formServiceCreate.get('serviceImg');
  }


  constructor(private facilityService: FacilityServiceService,
              private route: Router) {
    this.facilityService.getAllServiceType().subscribe(serviceType => {
      this.serviceTypes = serviceType;
      this.formServiceCreate.get('serviceType').setValue(this.serviceTypes[0]);
    }, error => {
      console.log(error);
    });
    this.facilityService.getAllRentType().subscribe(rentType => {
      this.rentTypeList = rentType;
      this.formServiceCreate.get('serviceRentType').setValue(this.rentTypeList[0]);
    }, error => {
      console.log(error);
    });
  }

  ngOnInit(): void {
  }

  onSubmit() {
    this.facility = this.formServiceCreate.value;
    this.facilityService.saveFacility(this.facility).subscribe(() => {
      this.formServiceCreate.reset();
      this.route.navigateByUrl('list-service');
      alert('Tạo mới thành công');
    }, error => {
      console.log(error);
    });
  }
}
