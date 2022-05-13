import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TimelinesComponent} from "./timelines/timelines.component";
import {YoutubePlaylistComponent} from "./youtube-playlist/youtube-playlist.component";


const routes: Routes = [
  {
    path: 'timelines',
    component: TimelinesComponent

  },
  {
    path: 'youtube',
    component: YoutubePlaylistComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
