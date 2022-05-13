import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {RentType} from '../../models/rent-type';
import {RentTypeService} from '../../services/rent-type-service';

@Component({
  selector: 'app-create-service',
  templateUrl: './create-service.component.html',
  styleUrls: ['./create-service.component.css']
})
export class CreateServiceComponent implements OnInit {
    RentTypeList: RentType[];
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
    serviceImg: new FormControl('', [Validators.required])
  });
  get serviceType(){
    return this.formServiceCreate.get('serviceType');
  }
  get serviceCode(){
    return this.formServiceCreate.get('serviceCode');
  }
  get serviceName(){
    return this.formServiceCreate.get('serviceName');
  }
  get serviceArea(){
    return this.formServiceCreate.get('serviceArea');
  }
  get servicePrice(){
    return this.formServiceCreate.get('servicePrice');
  }
  get serviceMaxPeople(){
    return this.formServiceCreate.get('serviceMaxPeople');
  }get serviceStandRoom(){
    return this.formServiceCreate.get('serviceStandRoom');
  }
  get serviceDescribe(){
    return this.formServiceCreate.get('serviceDescribe');
  }
  get serviceAreaPool(){
    return this.formServiceCreate.get('serviceAreaPool');
  }
  get serviceFloor(){
    return this.formServiceCreate.get('serviceFloor');
  }
  get serviceRentType(){
    return this.formServiceCreate.get('serviceRentType');
  }
  get serviceImg(){
    return this.formServiceCreate.get('serviceImg');
  }


  constructor(private rentTypeService: RentTypeService) {
    this.RentTypeList = this.rentTypeService.getRentTypeList();
  }

  ngOnInit(): void {
  }

  onSubmit() {
  }
}
