import {Component, Input} from '@angular/core';
import {Feedback} from "../../data/feedback";

@Component({
  selector: 'app-event-feedback-details-item',
  templateUrl: './event-feedback-details-item.component.html',
  styleUrl: './event-feedback-details-item.component.css'
})
export class EventFeedbackDetailsItemComponent {
  @Input() feedback!: Feedback;
  stars: boolean[] = Array(5).fill(false);

  ngOnInit() {
    this.stars = this.stars.map((_, index) => index < this.feedback.rating);
  }
}
