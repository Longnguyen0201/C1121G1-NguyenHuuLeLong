import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChildComponentListComponent } from './child-component-list.component';

describe('ChildComponentListComponent', () => {
  let component: ChildComponentListComponent;
  let fixture: ComponentFixture<ChildComponentListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChildComponentListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChildComponentListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
