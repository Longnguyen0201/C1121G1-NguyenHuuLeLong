import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator-app',
  templateUrl: './calculator-app.component.html',
  styleUrls: ['./calculator-app.component.css']
})
export class CalculatorAppComponent implements OnInit {
  display = '';

  constructor() { }

  ngOnInit(): void {
  }

  btn(num: string) {
    this.display += num;
  }

  clearAll() {
    this.display = '';
  }

  equal() {
    // tslint:disable-next-line:no-eval
    this.display = eval(this.display);
  }
}
