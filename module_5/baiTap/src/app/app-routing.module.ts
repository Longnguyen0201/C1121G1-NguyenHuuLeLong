import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {BenhAnListComponent} from './benhAn/benh-an-list/benh-an-list.component';
import {BenhAnEditComponent} from './benhAn/benh-an-edit/benh-an-edit.component';
import {BenhAnCreateComponent} from './benhAn/benh-an-create/benh-an-create.component';


const routes: Routes = [
  {path: 'list', component: BenhAnListComponent},
  {path: 'list/create', component: BenhAnCreateComponent},
  {path: 'edit/:id', component: BenhAnEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
