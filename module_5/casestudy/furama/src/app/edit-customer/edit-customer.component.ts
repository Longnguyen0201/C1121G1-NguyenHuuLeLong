import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {Customer} from '../../models/customer';
import {CustomerService} from '../../services/customer-service';
import {CustomerType} from '../../models/customer-type';
import {CustomerTypeService} from '../../services/customer-type-service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerServiceService} from '../service/customer-service.service';




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
    customerIDCard: new FormControl('', Validators.required),
    customerPhone: new FormControl('', Validators.required),
    customerEmail: new FormControl('', [Validators.required, Validators.pattern('^[a-z][a-z0-9_\\\\.]{5,32}@[a-z0-9]{2,}(\\\\.[a-z0-9]{2,}){1,}$')]),
    customerAddress: new FormControl('', Validators.required),
    customerType: new FormControl('', Validators.required)
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
  get customerIDCard() {
    return this.formCustomerEdit.get('customerIDCard');
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
  get customerType() {
    return this.formCustomerEdit.get('customerType');
  }
  constructor(private activatedRoute: ActivatedRoute,
              private customerService: CustomerServiceService,
              private customerTypeService: CustomerTypeService,
              private route: Router) {
    this.customerTypeList = this.customerTypeService.getCustomerTypeList();
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this.getCustomer(this.id);
    } );
  }

  ngOnInit(): void {
    // this.customerTypeList = this.customerTypeService.getCustomerTypeList();
    // this.id = this.activatedRoute.snapshot.params.id;
    // // console.log(this.id);
    // // console.log(this.customers);
    // // tslint:disable-next-line:triple-equals
    // this.customer = this.customers.filter( (e) => e.customerId == this.id)[0];
    // this.formCustomerEdit.patchValue(this.customer);
    // // console.log(this.customer);

  }


   getCustomer(id: number) {
     // tslint:disable-next-line:no-unused-expression
    // @ts-ignore
     // tslint:disable-next-line:no-unused-expression
     return this.customerService.findById(id).subscribe(customer => {
       this.formCustomerEdit = new FormGroup({
         customerId: new FormControl(customer.customerId),
         customerCode: new FormControl(customer.customerCode, [Validators.required, Validators.pattern('^KH-\\d{4}$')]),
         customerName: new FormControl(customer.customerName, Validators.required),
         customerBirthday: new FormControl(customer.customerBirthday, Validators.required),
         customerGender: new FormControl(customer.customerGender, Validators.required),
         customerIDCard: new FormControl(customer.customerIDCard, Validators.required),
         customerPhone: new FormControl(customer.customerPhone, Validators.required),
         customerEmail: new FormControl(customer.customerEmail, [Validators.required, Validators.pattern('^[a-z][a-z0-9_\\\\.]{5,32}@[a-z0-9]{2,}(\\\\.[a-z0-9]{2,}){1,}$')]),
         customerAddress: new FormControl(customer.customerAddress, Validators.required),
         customerType: new FormControl(customer.customerType, Validators.required)
       });
     });
  }

  updateCustomer(id: number){
    const customer = this.formCustomerEdit.value;
    console.log(customer);
    // @ts-ignore
    this.customerService.updateCustomer(id, customer).subscribe(() => {
      alert('Cập nhập thành công');
      this.route.navigateByUrl('/list-customer');
    }, error => {
      console.log(error);
    });
  }

  compareFn(t1: CustomerType, t2: CustomerType): boolean{
    return t1 && t2 ? t1.customerTypeId === t2.customerTypeId : t1 === t2;
  }
}
