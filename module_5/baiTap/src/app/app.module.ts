import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import {BenhAnListComponent} from './benhAn/benh-an-list/benh-an-list.component';
import {BenhAnService} from './service/benh-an.service';
import {HttpClientModule} from '@angular/common/http';
import { BenhAnEditComponent } from './benhAn/benh-an-edit/benh-an-edit.component';
import {ReactiveFormsModule} from '@angular/forms';
import {BenhNhanService} from './service/benh-nhan.service';
import { BenhAnCreateComponent } from './benhAn/benh-an-create/benh-an-create.component';




@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    BenhAnListComponent,
    BenhAnEditComponent,
    BenhAnCreateComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [BenhAnService, BenhNhanService],
  bootstrap: [AppComponent]
})
export class AppModule { }
