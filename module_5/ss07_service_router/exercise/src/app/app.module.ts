import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {DictionayPageComponent} from './dictionay-page/dictionay-page.component';
import {DictionaryDetailComponent} from './dictionay-page/dictionary-detail/dictionary-detail.component';
import {MatSliderModule} from '@angular/material/slider';
import {ReactiveFormsModule} from '@angular/forms';
import {MatIconModule} from '@angular/material/icon';
import {MatTableModule} from '@angular/material/table';
import {HttpClientModule} from '@angular/common/http';
import {SharedModule} from './shared/shared.module';


@NgModule({
  declarations: [
    AppComponent,
    DictionayPageComponent,
    DictionaryDetailComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatSliderModule,
    ReactiveFormsModule,
    MatIconModule,
    MatTableModule,
    HttpClientModule,
    SharedModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
