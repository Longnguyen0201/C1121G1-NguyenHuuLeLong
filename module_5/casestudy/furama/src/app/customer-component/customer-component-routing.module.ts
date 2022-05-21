import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListCustomerComponent} from './list-customer/list-customer.component';
import {CreateCustomerComponent} from './create-customer/create-customer.component';
import {EditCustomerComponent} from './edit-customer/edit-customer.component';



const routes: Routes = [
  {path: 'list-customer', component: ListCustomerComponent},
  {path: 'create-customer', component: CreateCustomerComponent},
  {path: 'edit-customer/:id', component: EditCustomerComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerComponentRoutingModule { }
