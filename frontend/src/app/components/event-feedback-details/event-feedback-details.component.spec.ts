import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EventFeedbackDetailsComponent } from './event-feedback-details.component';

describe('EventFeedbackDetailsComponent', () => {
  let component: EventFeedbackDetailsComponent;
  let fixture: ComponentFixture<EventFeedbackDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EventFeedbackDetailsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EventFeedbackDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
