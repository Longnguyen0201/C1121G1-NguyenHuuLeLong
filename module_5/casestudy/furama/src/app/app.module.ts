import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HomeComponent} from './home/home.component';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {EditServiceComponent} from './service-component/edit-service/edit-service.component';
import {ListServiceComponent} from './service-component/list-service/list-service.component';
import {CreateServiceComponent} from './service-component/create-service/create-service.component';
import {CreateContractComponent} from './contract-component/create-contract/create-contract.component';
import {ListContractComponent} from './contract-component/list-contract/list-contract.component';
import {AppRoutingModule} from './app-routing.module';
import {RouterModule} from '@angular/router';
import {CustomerService} from '../services/customer-service';
import {FacilityService} from '../services/facility-service';
import {ContractService} from '../services/contract-service';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {CustomerTypeService} from '../services/customer-type-service';
import {RentTypeService} from '../services/rent-type-service';
import {HttpClientModule} from '@angular/common/http';
import {ModalComponent} from './modal/modal.component';
import {MatSliderModule} from '@angular/material/slider';
import {MatIconModule} from '@angular/material/icon';
import {MatTableModule} from '@angular/material/table';
import {MatDialogModule} from '@angular/material/dialog';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NgxPaginationModule} from 'ngx-pagination';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    EditServiceComponent,
    ListServiceComponent,
    CreateServiceComponent,
    CreateContractComponent,
    ListContractComponent,
    ModalComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatSliderModule,
    MatIconModule,
    MatTableModule,
    MatDialogModule,
    BrowserAnimationsModule,
    NgxPaginationModule,
    FormsModule
  ],
  providers: [CustomerService, FacilityService, ContractService, CustomerTypeService, RentTypeService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
