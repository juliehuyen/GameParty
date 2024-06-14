import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EventFeedbackListComponent } from './event-feedback-list.component';

describe('EventFeedbackListComponent', () => {
  let component: EventFeedbackListComponent;
  let fixture: ComponentFixture<EventFeedbackListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EventFeedbackListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(EventFeedbackListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
