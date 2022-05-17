import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductRoutingModule } from './product-routing.module';
import {ProductEditComponent} from './product-edit/product-edit.component';
import {ProductCreateComponent} from './product-create/product-create.component';
import {ProductListComponent} from './product-list/product-list.component';
import {ReactiveFormsModule} from '@angular/forms';
import {MatIconModule} from '@angular/material/icon';
import {MatSliderModule} from '@angular/material/slider';


@NgModule({
  declarations: [
    ProductListComponent,
    ProductCreateComponent,
    ProductEditComponent,
  ],
  imports: [
    CommonModule,
    ProductRoutingModule,
    ReactiveFormsModule,
    MatIconModule,
    MatSliderModule
  ]
})
export class ProductModule { }
