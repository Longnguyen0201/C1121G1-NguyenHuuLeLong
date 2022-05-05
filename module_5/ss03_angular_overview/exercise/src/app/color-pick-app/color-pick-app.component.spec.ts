import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ColorPickAppComponent } from './color-pick-app.component';

describe('ColorPickAppComponent', () => {
  let component: ColorPickAppComponent;
  let fixture: ComponentFixture<ColorPickAppComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ColorPickAppComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ColorPickAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
