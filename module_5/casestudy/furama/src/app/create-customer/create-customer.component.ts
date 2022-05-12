import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Customer} from '../../models/customer';
import {CustomerService} from '../../services/customer-service';
import {ActivatedRoute, Router} from '@angular/router';
import {CustomerTypeService} from '../../services/customer-type-service';
import {CustomerType} from '../../models/customer-type';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {
  customer: Customer;
  customers: Customer[] = [];
  customerTypeList: CustomerType[];

  formCustomerCreate: FormGroup = new FormGroup({
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

  constructor(private router: ActivatedRoute,
              private  route: Router,
              private customerService: CustomerService,
              private customerTypeService: CustomerTypeService) {
    this.customerTypeList = this.customerTypeService.getCustomerTypeList();
  }

  get customerCode() {
    return this.formCustomerCreate.get('customerCode');
  }
  get customerName() {
    return this.formCustomerCreate.get('customerName');
  }
  get customerBirthday() {
    return this.formCustomerCreate.get('customerBirthday');
  }
  get customerGender() {
    return this.formCustomerCreate.get('customerGender');
  }
  get customerIdCard() {
    return this.formCustomerCreate.get('customerIdCard');
  }
  get customerPhone() {
    return this.formCustomerCreate.get('customerPhone');
  }
  get customerEmail() {
    return this.formCustomerCreate.get('customerEmail');
  }
  get customerAddress() {
    return this.formCustomerCreate.get('customerAddress');
  }
  get customerTypeId() {
    return this.formCustomerCreate.get('customerTypeId');
  }

  ngOnInit(): void {
  }

  onSubmit() {
    if (this.formCustomerCreate.valid){
      this.route.navigateByUrl('/create-customer');
    }else {
      console.log(this.formCustomerCreate);
      this.customer = this.formCustomerCreate.value;
      console.log(this.customer);
      this.customerService.createCustomer(this.customer);
      this.route.navigateByUrl('/list-customer');
    }
  }
}
