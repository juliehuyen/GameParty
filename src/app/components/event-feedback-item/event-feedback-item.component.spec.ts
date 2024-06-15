import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EventFeedbackItemComponent } from './event-feedback-item.component';

describe('EventFeedbackItemComponent', () => {
  let component: EventFeedbackItemComponent;
  let fixture: ComponentFixture<EventFeedbackItemComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EventFeedbackItemComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EventFeedbackItemComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
