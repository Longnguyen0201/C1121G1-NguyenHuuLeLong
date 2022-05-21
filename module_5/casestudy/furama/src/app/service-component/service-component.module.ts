import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ServiceComponentRoutingModule } from './service-component-routing.module';
import {ListServiceComponent} from './list-service/list-service.component';
import {CreateServiceComponent} from './create-service/create-service.component';
import {EditServiceComponent} from './edit-service/edit-service.component';
import {RouterModule} from '@angular/router';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';


@NgModule({
  declarations: [
    ListServiceComponent,
    CreateServiceComponent,
    EditServiceComponent
  ],
  imports: [
    CommonModule,
    ServiceComponentRoutingModule,
    RouterModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule
  ]
})
export class ServiceComponentModule { }
