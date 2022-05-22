import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { DangTinListComponent } from './dangTin/dang-tin-list/dang-tin-list.component';
import {HttpClientModule} from '@angular/common/http';
import { DangTinCreateComponent } from './dangTin/dang-tin-create/dang-tin-create.component';
import {ReactiveFormsModule} from '@angular/forms';
import { DangTinEditComponent } from './dangTin/dang-tin-edit/dang-tin-edit.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    DangTinListComponent,
    DangTinCreateComponent,
    DangTinEditComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
