import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DangTinCreateComponent } from './dang-tin-create.component';

describe('DangTinCreateComponent', () => {
  let component: DangTinCreateComponent;
  let fixture: ComponentFixture<DangTinCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DangTinCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DangTinCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
