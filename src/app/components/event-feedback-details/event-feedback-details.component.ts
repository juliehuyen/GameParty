import {Component, Input} from '@angular/core';
import {GameEvent} from "../../data/gameEvent";

@Component({
  selector: 'app-event-feedback-details',
  templateUrl: './event-feedback-details.component.html',
  styleUrl: './event-feedback-details.component.css'
})
export class EventFeedbackDetailsComponent {
  @Input()
  event!: GameEvent;
}
