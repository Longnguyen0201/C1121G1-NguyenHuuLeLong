import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChildComponentCreateComponent } from './child-component-create.component';

describe('ChildComponentCreateComponent', () => {
  let component: ChildComponentCreateComponent;
  let fixture: ComponentFixture<ChildComponentCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChildComponentCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChildComponentCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
