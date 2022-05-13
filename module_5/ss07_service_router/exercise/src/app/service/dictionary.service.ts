import { Injectable } from '@angular/core';
import {Iword} from './iword';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  dictionarys: Iword[] = [
    {id: 1, word: 'Hello', mean: 'Xin chào'},
    {id: 2, word: 'One', mean: 'Một'},
    {id: 3, word: 'Two', mean: 'Hai'},
    {id: 4, word: 'Three', mean: 'Ba'},
  ];

  constructor() { }

  findSongById(id: number) {
    // @ts-ignore
    return this.dictionarys.find(item => item.id === id);
  }
}
