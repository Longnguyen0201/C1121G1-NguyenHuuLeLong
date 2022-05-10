import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { EditServiceComponent } from './edit-service/edit-service.component';
import { ListServiceComponent } from './list-service/list-service.component';
import { CreateServiceComponent } from './create-service/create-service.component';
import { ListCustomerComponent } from './list-customer/list-customer.component';
import { EditCustomerComponent } from './edit-customer/edit-customer.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { CreateContractComponent } from './create-contract/create-contract.component';
import { ListContractComponent } from './list-contract/list-contract.component';
import {AppRoutingModule} from './app-routing.module';
import {RouterModule} from '@angular/router';
import {CustomerService} from '../services/customer-service';
import {FacilityService} from '../services/facility-service';
import {ContractService} from "../services/contract-service";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    EditServiceComponent,
    ListServiceComponent,
    CreateServiceComponent,
    ListCustomerComponent,
    EditCustomerComponent,
    CreateCustomerComponent,
    CreateContractComponent,
    ListContractComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule
  ],
  providers: [CustomerService, FacilityService, ContractService],
  bootstrap: [AppComponent]
})
export class AppModule { }
