import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import {GalleryConfig} from './image-gallery/token';
import {ImageGalleryComponent} from './image-gallery/image-gallery.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ImageGalleryComponent
  ],
  providers: [
    {provide: GalleryConfig, useValue: 3}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
