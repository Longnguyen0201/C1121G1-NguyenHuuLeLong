import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ChildComponentListComponent} from "./child-component/child-component-list/child-component-list.component";
import {ChildComponentCreateComponent} from "./child-component/child-component-create/child-component-create.component";
import {ChildComponentEditComponent} from "./child-component/child-component-edit/child-component-edit.component";


const routes: Routes = [
  {path: 'list', component: ChildComponentListComponent},
  {path: 'list/create', component: ChildComponentCreateComponent},
  {path: 'edit/:id', component: ChildComponentEditComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
