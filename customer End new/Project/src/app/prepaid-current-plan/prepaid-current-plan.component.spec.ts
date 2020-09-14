import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrepaidCurrentPlanComponent } from './prepaid-current-plan.component';

describe('PrepaidCurrentPlanComponent', () => {
  let component: PrepaidCurrentPlanComponent;
  let fixture: ComponentFixture<PrepaidCurrentPlanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrepaidCurrentPlanComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrepaidCurrentPlanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
