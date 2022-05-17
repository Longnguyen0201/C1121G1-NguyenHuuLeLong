import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductListComponent} from './product-list/product-list.component';
import {ProductEditComponent} from './product-edit/product-edit.component';
import {ProductCreateComponent} from './product-create/product-create.component';


const routes: Routes = [
  {path: 'productList', component: ProductListComponent},
  {path: 'productCreate', component: ProductCreateComponent},
  {path: 'productEdit/:id', component: ProductEditComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductRoutingModule { }
