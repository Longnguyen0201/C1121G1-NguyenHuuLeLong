import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {
    path: 'customer',
    loadChildren: () => import('./customer-component/customer-component.module').then(module => module.CustomerComponentModule)
  },
  {
    path: 'contrac',
    loadChildren: () => import('./contract-component/contract-component.module').then(module => module.ContractComponentModule)
  },
  {
    path: 'service',
    loadChildren: () => import('./service-component/service-component.module').then(module => module.ServiceComponentModule)
  },
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ]
})
export class AppRoutingModule { }
