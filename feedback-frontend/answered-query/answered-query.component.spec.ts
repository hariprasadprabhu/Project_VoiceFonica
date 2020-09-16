import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnsweredQueryComponent } from './answered-query.component';

describe('AnsweredQueryComponent', () => {
  let component: AnsweredQueryComponent;
  let fixture: ComponentFixture<AnsweredQueryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnsweredQueryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnsweredQueryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
