import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DangTinListComponent } from './dang-tin-list.component';

describe('DangTinListComponent', () => {
  let component: DangTinListComponent;
  let fixture: ComponentFixture<DangTinListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DangTinListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DangTinListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
