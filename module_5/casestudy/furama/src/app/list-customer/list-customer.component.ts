import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../../services/customer-service';
import {Customer} from '../../models/customer';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css'],
  // providers: [CustomerService]
})
export class ListCustomerComponent implements OnInit {
  customers: Customer[];
  constructor(private customerService: CustomerService) {
    this.customers = this.customerService.getCustomerList();
  }

  ngOnInit(): void {
  }

}
