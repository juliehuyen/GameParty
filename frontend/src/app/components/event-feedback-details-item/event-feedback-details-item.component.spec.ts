import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EventFeedbackDetailsItemComponent } from './event-feedback-details-item.component';

describe('EventFeedbackDetailsItemComponent', () => {
  let component: EventFeedbackDetailsItemComponent;
  let fixture: ComponentFixture<EventFeedbackDetailsItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EventFeedbackDetailsItemComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EventFeedbackDetailsItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
