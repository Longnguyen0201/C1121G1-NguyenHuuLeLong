import { Component, OnInit } from '@angular/core';
import {CustomerService} from '../../services/customer-service';
import {Customer} from '../../models/customer';
import {CustomerServiceService} from '../service/customer-service.service';
import {MatDialog} from '@angular/material/dialog';
import {ModalComponent} from '../modal/modal.component';
import {Router} from '@angular/router';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css'],
  // providers: [CustomerService]
})
export class ListCustomerComponent implements OnInit {
  customers: Customer[] = [];
   idDelete = 0;
  nameDelete = '';
  constructor(private customerService: CustomerServiceService,
              private route: Router,
              private dialog: MatDialog) {
    // this.customers = this.customerService.getCustomerList();
  }

  ngOnInit(): void {
    this.getAll();
  }

  private getAll() {
    console.log(this.customers);
    this.customerService.getAll().subscribe(customers => {this.customers = customers;
                                                          console.log(customers);
    });
    console.log(this.customers);
  }

  deleteCustomer(customer: any) {
    // console.log( 'hihi');
    const dialogRef = this.dialog.open(ModalComponent, {
      width: '50%' ,
      data: customer
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('dialog was closed');
      if (result === 'close'){
        this.getAll();
      }
    });
  }

  modalDelete(id) {
    console.log('hihi');
    this.customerService.deleteCustomer(id).subscribe(() => {
      this.route.navigateByUrl('/list-customer');
      alert('xóa thành công');
    }, error => {
      console.log(error);
    });
  }

  getIdAndName(customerId: number, customerName: string) {
    this.idDelete = customerId;
    this.nameDelete = customerName;
  }
}
