import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BenhAnEditComponent } from './benh-an-edit.component';

describe('BenhAnEditComponent', () => {
  let component: BenhAnEditComponent;
  let fixture: ComponentFixture<BenhAnEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BenhAnEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BenhAnEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
