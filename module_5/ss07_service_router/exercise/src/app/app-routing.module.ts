import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DictionayPageComponent} from './dictionay-page/dictionay-page.component';
import {DictionaryDetailComponent} from './dictionay-page/dictionary-detail/dictionary-detail.component';
import {ProductListComponent} from './product/product-list/product-list.component';
import {ProductCreateComponent} from './product/product-create/product-create.component';
import {ProductEditComponent} from './product/product-edit/product-edit.component';



const routes: Routes = [
  {path: 'product', loadChildren: () => import('./product/product.module').then(module => module.ProductModule)},
  {path: 'category', loadChildren: () => import('./category/category.module').then(module => module.CategoryModule)}
  // {path: 'dictionary', component: DictionayPageComponent},
  // {path: 'dictionaryDetail/:id', component: DictionaryDetailComponent},
  //   path: 'category',
  //   loadChildren: () => import('./category/category.module').then(module => module.CategoryModule)
  // }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
