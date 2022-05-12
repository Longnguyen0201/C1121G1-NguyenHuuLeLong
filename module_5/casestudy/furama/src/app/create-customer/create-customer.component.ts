import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Customer} from '../../models/customer';
import {CustomerService} from '../../services/customer-service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {
  customer: Customer;
  customers: Customer[] = [];
  route: Router;
  formCustomerCreate: FormGroup = new FormGroup({
    customerCode: new FormControl('', [Validators.required, Validators.pattern('^KH-\\\\d{4}$')] ),
    customerName: new FormControl('', Validators.required),
    customerBirthday: new FormControl('', Validators.required),
    customerGender: new FormControl('', Validators.required),
    customerIdCard: new FormControl('', Validators.required),
    customerPhone: new FormControl('', Validators.required),
    customerEmail: new FormControl('', [Validators.required, Validators.pattern('^[a-z][a-z0-9_\\\\.]{5,32}@[a-z0-9]{2,}(\\\\.[a-z0-9]{2,}){1,}$')]),
    customerAddress: new FormControl('', Validators.required),
    customerTypeId: new FormControl('', Validators.required)
  });

  constructor(private customerService: CustomerService) { }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this.formCustomerCreate);
    this.customer = this.formCustomerCreate.value;
    console.log(this.customer);
    this.customerService.createCustomer(this.customer);
    this.route.navigateByUrl('/list-customer');
  }
}
