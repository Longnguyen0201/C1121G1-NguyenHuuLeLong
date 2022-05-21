import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ContractComponentRoutingModule } from './contract-component-routing.module';
import {CreateContractComponent} from './create-contract/create-contract.component';
import {ListContractComponent} from './list-contract/list-contract.component';
import {ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';


@NgModule({
  declarations: [
    CreateContractComponent,
    ListContractComponent
  ],
  imports: [
    CommonModule,
    ContractComponentRoutingModule,
    RouterModule,
    ReactiveFormsModule
  ]
})
export class ContractComponentModule { }
