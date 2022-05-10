import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {Customer} from '../../models/customer';
import {CustomerService} from '../../services/customer-service';
import {element} from 'protractor';


@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {
    id: any;
   customers: Customer[];
   customer: Customer;
  constructor(private activatedRoute: ActivatedRoute, private customerService: CustomerService) {
    this.customers = this.customerService.getCustomerList();
  }

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params.id;
    // console.log(this.id);
    // console.log(this.customers);
    // tslint:disable-next-line:triple-equals
    this.customer = this.customers.filter( (e) => e.customerId == this.id)[0];
    // console.log(this.customer);

  }




}
