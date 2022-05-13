import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DictionayPageComponent} from './dictionay-page/dictionay-page.component';
import {DictionaryDetailComponent} from './dictionay-page/dictionary-detail/dictionary-detail.component';



const routes: Routes = [
  {path: 'dictionary', component: DictionayPageComponent},
  {path: 'dictionaryDetail/:id', component: DictionaryDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
