import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {Customer} from '../../models/customer';
import {CustomerService} from '../../services/customer-service';
import {CustomerType} from '../../models/customer-type';
import {CustomerTypeService} from '../../services/customer-type-service';
import {FormControl, FormGroup, Validators} from '@angular/forms';



@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
    id: number;
   customers: Customer[];
   customer: Customer;
  customerTypeList: CustomerType[];
  formCustomerEdit: FormGroup = new FormGroup({
    customerCode: new FormControl('', [Validators.required, Validators.pattern('^KH-\\d{4}$')]),
    customerName: new FormControl('', Validators.required),
    customerBirthday: new FormControl('', Validators.required),
    customerGender: new FormControl('', Validators.required),
    customerIdCard: new FormControl('', Validators.required),
    customerPhone: new FormControl('', Validators.required),
    customerEmail: new FormControl('', [Validators.required, Validators.pattern('^[a-z][a-z0-9_\\\\.]{5,32}@[a-z0-9]{2,}(\\\\.[a-z0-9]{2,}){1,}$')]),
    customerAddress: new FormControl('', Validators.required),
    customerTypeId: new FormControl('', Validators.required)
  });
  get customerCode() {
    return this.formCustomerEdit.get('customerCode');
  }
  get customerName() {
    return this.formCustomerEdit.get('customerName');
  }
  get customerBirthday() {
    return this.formCustomerEdit.get('customerBirthday');
  }
  get customerGender() {
    return this.formCustomerEdit.get('customerGender');
  }
  get customerIdCard() {
    return this.formCustomerEdit.get('customerIdCard');
  }
  get customerPhone() {
    return this.formCustomerEdit.get('customerPhone');
  }
  get customerEmail() {
    return this.formCustomerEdit.get('customerEmail');
  }
  get customerAddress() {
    return this.formCustomerEdit.get('customerAddress');
  }
  get customerTypeId() {
    return this.formCustomerEdit.get('customerTypeId');
  }
  constructor(private activatedRoute: ActivatedRoute,
              private customerService: CustomerService,
              private customerTypeService: CustomerTypeService) {
    this.customers = this.customerService.getCustomerList();
  }

  ngOnInit(): void {
    this.customerTypeList = this.customerTypeService.getCustomerTypeList();
    this.id = this.activatedRoute.snapshot.params.id;
    // console.log(this.id);
    // console.log(this.customers);
    // tslint:disable-next-line:triple-equals
    this.customer = this.customers.filter( (e) => e.customerId == this.id)[0];
    this.formCustomerEdit.patchValue(this.customer);
    // console.log(this.customer);

  }




}
