import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-color-pick-app',
  templateUrl: './color-pick-app.component.html',
  styleUrls: ['./color-pick-app.component.css']
})
export class ColorPickAppComponent implements OnInit {
  r1 = 0;
  r2 = 0;
  b1 = 0;
  b2 = 0;
  g1 = 0;
  g2 = 0;
  deg = 0;

  constructor() {
  }

  ngOnInit(): void {
  }

  changeR1(event) {
    this.r1 = event.target.value;
  }

  changeG1(event) {
    this.g1 = event.target.value;
  }

  changeB1(event) {
    this.b1 = event.target.value;
  }

  changeR2(event) {
    this.r2 = event.target.value;
  }

  changeG2(event) {
    this.g2 = event.target.value;
  }

  changeB2(event) {
    this.b2 = event.target.value;
  }

  changeDeg(event) {
    this.deg = event.target.value;
  }

  setMyStyle() {
    const styles = {
      background: 'rgb(' + this.r1 + ',' + this.g1 + ',' + this.b1 + ')',
      'background-image': 'linear-gradient(' + this.deg + 'deg, rgb(' + this.r1 + ',' + this.g1 + ',' + this.b1 + ') 0%,' +
        ' rgb(' + this.r2 + ',' + this.g2 + ',' + this.b2 + ') 74%)'
    };
    return styles;

  }
}
