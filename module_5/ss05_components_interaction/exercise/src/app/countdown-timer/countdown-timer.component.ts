import {Component, EventEmitter, Input, OnChanges, OnDestroy, OnInit, Output, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-countdown-timer',
  templateUrl: './countdown-timer.component.html',
  styleUrls: ['./countdown-timer.component.css']
})
export class CountdownTimerComponent implements OnInit, OnChanges, OnDestroy {
  message = '';
  remainingTime: number;
  @Input() seconds = 11;
   seconds2 = 13;
  @Output() finish = new EventEmitter<boolean>();
  private intervalId = 0 ;
  constructor() {
  }

  ngOnChanges(changes: SimpleChanges) {
    if ('seconds2' in changes) {
      let v = changes.seconds2.currentValue;
      v = typeof v === 'undefined' ? 13 : v;
      const vFix = Number(v);
      this.seconds = Number.isNaN(vFix) ? 13 : vFix;
    }
  }

  clearTimer() {
    clearInterval(this.intervalId);
  }



  ngOnInit(): void {
    this.reset();
  }

  ngOnDestroy() {
    this.clearTimer();
  }

  reset() {
    this.clearTimer();
    this.remainingTime = this.seconds2;
    this.message = 'Click start button to start the countdown';
  }

  start() {
    this.countDown();
    if (this.remainingTime <= 0) {
      this.remainingTime = this.seconds2;
    }
  }

  stop(){
    this.clearTimer();
    this.message = `Click start button to start the Countdown`;
  }


  private countDown() {
    // tslint:disable-next-line:no-unused-expression
    this.clearTimer;
    this.intervalId = window.setInterval(() => {
      this.remainingTime -= 1;
      if (this.remainingTime === 0) {
        this.message = 'Blast off:';
        this.clearTimer();
        this.finish.emit(true);
      } else {
        this.message = `T-${this.remainingTime} seconds and counting`;
      }
    }, 1000);

  }
}
