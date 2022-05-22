import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DangTinEditComponent } from './dang-tin-edit.component';

describe('DangTinEditComponent', () => {
  let component: DangTinEditComponent;
  let fixture: ComponentFixture<DangTinEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DangTinEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DangTinEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
