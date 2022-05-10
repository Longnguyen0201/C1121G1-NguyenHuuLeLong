import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {ListServiceComponent} from './list-service/list-service.component';
import {HomeComponent} from './home/home.component';
import {ListCustomerComponent} from './list-customer/list-customer.component';
import {ListContractComponent} from './list-contract/list-contract.component';
import {EditCustomerComponent} from './edit-customer/edit-customer.component';
import {CreateCustomerComponent} from './create-customer/create-customer.component';
import {CreateServiceComponent} from './create-service/create-service.component';
import {EditServiceComponent} from './edit-service/edit-service.component';
import {CreateContractComponent} from './create-contract/create-contract.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'list-service', component: ListServiceComponent},
  {path: 'create-service', component: CreateServiceComponent},
  {path: 'edit-service', component: EditServiceComponent},
  {path: 'list-customer', component: ListCustomerComponent},
  {path: 'create-customer', component: CreateCustomerComponent},
  {path: 'edit-customer/:id', component: EditCustomerComponent},
  {path: 'list-contract', component: ListContractComponent},
  {path: 'create-contract', component: CreateContractComponent}
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ]
})
export class AppRoutingModule { }
