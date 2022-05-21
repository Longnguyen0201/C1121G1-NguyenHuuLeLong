import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../../services/customer-service';
import {FacilityService} from '../../../services/facility-service';
import {Customer} from '../../../models/customer';
import {Facility} from '../../../models/facility';
import {Contract} from '../../../models/contract';
import {ContractService} from '../../../services/contract-service';
import {Route, Router} from '@angular/router';
import {CustomerServiceService} from '../../service/customer-service.service';
import {Observable} from "rxjs";
import {FacilityServiceService} from "../../service/facility-service.service";
import {ServiceType} from "../../../models/service-type";

@Component({
  selector: 'app-create-contract',
  templateUrl: './create-contract.component.html',
  styleUrls: ['./create-contract.component.css']
})
export class CreateContractComponent implements OnInit {
  customerList: Observable<Customer[]>;
  serviceTye: ServiceType;
  serviceList: Facility[];
  contract: Contract;
  formContractCreate: FormGroup = new FormGroup({
    contractCode: new FormControl('', [ Validators.required, Validators.pattern('^HD-\\d{4}$')]),
    customerName: new FormControl('', [ Validators.required]),
    employeeName: new FormControl('', [ Validators.required]),
    facilityName: new FormControl('', [ Validators.required]),
    contractStartDate: new FormControl('', [Validators.required]),
    contractEndDate: new FormControl('', [Validators.required]),
    contractDeposit: new FormControl('', [Validators.required]),
    contractTotalMoney: new FormControl('', [Validators.required]),
  });
  get contractCode(){
    return this.formContractCreate.get('contractCode');
  }
  get customerName(){
    return this.formContractCreate.get('customerName');
  }
  get employeeName(){
    return this.formContractCreate.get('employeeName');
  }
  get facilityName(){
    return this.formContractCreate.get('facilityName');
  }
  get contractStartDate(){
    return this.formContractCreate.get('contractStartDate');
  }
  get contractEndDate(){
    return this.formContractCreate.get('contractEndDate');
  }
  get contractDeposit(){
    return this.formContractCreate.get('contractDeposit');
  }
  get contractTotalMoney(){
    return this.formContractCreate.get('contractTotalMoney');
  }

  constructor(private customerService: CustomerServiceService,
              private facilityService: FacilityServiceService,
              private contractService: ContractService,
              private route: Router) {
    // this.customerList = this.customerService.getAll();
    this.facilityService.getAllServiceType().subscribe(data => {
      this.serviceTye = data;
    }, error => {
      console.log(error);
    });
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.formContractCreate);
    this.contract = this.formContractCreate.value;
    console.log(this.contract);
    this.contractService.createContract(this.contract);
    this.route.navigateByUrl('/list-contract');

  }
}
