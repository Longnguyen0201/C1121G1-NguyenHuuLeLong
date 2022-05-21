import {Component, OnInit} from '@angular/core';
import {Customer} from '../../../models/customer';
import {CustomerServiceService} from '../../service/customer-service.service';
import {MatDialog} from '@angular/material/dialog';
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
  number = 0;
  totalPages = 0;

  constructor(private customerService: CustomerServiceService,
              private route: Router) {
    // this.customers = this.customerService.getCustomerList();
    this.getAll();
  }

  ngOnInit(): void {
  }

  private getAll() {
    this.customerService.getAll(this.number).subscribe(customers => {
      this.customers = customers.content;
      this.number = customers.number;
      this.totalPages = customers.totalPages;
      console.log(this.number);
    }, error => {
      console.log('lỗi rồi bạn ei');
    });
  }

  previous() {
    if (this.number > 0) {
      console.log('kích e đi');
      this.customerService.getAll(this.number - 1).subscribe(customers => {
        this.customers = customers.content;
        console.log(customers);
        this.number = customers.number;
      });
    }
  }

  next() {
    if (this.number < this.totalPages - 1) {
      console.log(this.number);
      console.log('kích e đi');
      this.customerService.getAll(this.number + 1).subscribe(customers => {
        console.log(customers.number);
        console.log(customers);
        this.customers = customers.content;
        this.number = customers.number;
      }, error => {
        console.log('lỗi rồi bạn ei');
      });
    }
  }


  // deleteCustomer(customer: any) {
  //   // console.log( 'hihi');
  //   const dialogRef = this.dialog.open(ModalComponent, {
  //     width: '50%' ,
  //     data: customer
  //   });
  //   dialogRef.afterClosed().subscribe(result => {
  //     console.log('dialog was closed');
  //     if (result === 'close'){
  //       this.getAll();
  //     }
  //   });
  // }

  modalDelete(closeModal: HTMLButtonElement) {
    this.customerService.deleteCustomer(this.idDelete).subscribe(() => {
      closeModal.click();
      alert('xóa thành công');
      // this.route.navigateByUrl('/list-customer');
      this.getAll();
    }, error => {
      console.log(error);
    });
  }

  getIdAndName(customerId: number, customerName: string) {
    this.idDelete = customerId;
    this.nameDelete = customerName;
  }
}


