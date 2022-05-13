import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {DictionaryService} from '../../service/dictionary.service';
import {Iword} from '../../service/iword';


@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {

  // tslint:disable-next-line:no-input-rename
  @Input('wordObj') word: Iword = {
    id: 0,
    word: '',
    mean: ''
  };

  constructor(private activatedRoute: ActivatedRoute,
              private dictionaryService: DictionaryService) {
    activatedRoute.paramMap.subscribe((param: ParamMap) => {
      const id = param.get('id');
      if (id != null){
        // tslint:disable-next-line:radix
        const temp = this.dictionaryService.findSongById(parseInt(id));
        if (temp != null){
          this.word = temp;
        }
      }
    });

    }

  ngOnInit(): void {
  }
}
