import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChildComponentEditComponent } from './child-component-edit.component';

describe('ChildComponentEditComponent', () => {
  let component: ChildComponentEditComponent;
  let fixture: ComponentFixture<ChildComponentEditComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChildComponentEditComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChildComponentEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
