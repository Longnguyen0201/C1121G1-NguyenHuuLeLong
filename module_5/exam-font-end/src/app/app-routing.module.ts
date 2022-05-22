import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DangTinListComponent} from './dangTin/dang-tin-list/dang-tin-list.component';
import {DangTinCreateComponent} from './dangTin/dang-tin-create/dang-tin-create.component';
import {DangTinEditComponent} from './dangTin/dang-tin-edit/dang-tin-edit.component';


const routes: Routes = [
  {path: 'list', component: DangTinListComponent},
  {path: 'create', component: DangTinCreateComponent},
  {path: 'edit/:id', component: DangTinEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
