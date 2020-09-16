import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NotansweredQueryComponent } from './notanswered-query.component';

describe('NotansweredQueryComponent', () => {
  let component: NotansweredQueryComponent;
  let fixture: ComponentFixture<NotansweredQueryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NotansweredQueryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NotansweredQueryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
