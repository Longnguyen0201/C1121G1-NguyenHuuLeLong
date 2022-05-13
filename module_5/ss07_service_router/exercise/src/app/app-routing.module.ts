import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DictionayPageComponent} from './dictionay-page/dictionay-page.component';
import {DictionaryDetailComponent} from './dictionay-page/dictionary-detail/dictionary-detail.component';
import {ProductListComponent} from './product-list/product-list.component';
import {ProductCreateComponent} from './product-create/product-create.component';
import {ProductEditComponent} from './product-edit/product-edit.component';



const routes: Routes = [
  {path: 'dictionary', component: DictionayPageComponent},
  {path: 'dictionaryDetail/:id', component: DictionaryDetailComponent},
  {path: 'productList', component: ProductListComponent},
  {path: 'productCreate', component: ProductCreateComponent},
  {path: 'productEdit/:id', component: ProductEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
