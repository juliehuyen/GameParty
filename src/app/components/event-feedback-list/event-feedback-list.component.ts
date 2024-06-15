import { Component } from '@angular/core';
import {GameEvent} from "../../data/gameEvent";
import {EventService} from "../../services/eventService";

@Component({
  selector: 'app-event-feedback-list',
  templateUrl: './event-feedback-list.component.html',
  styleUrl: './event-feedback-list.component.css'
})
export class EventFeedbackListComponent {
  events: GameEvent[] = [];

  constructor(private eventService: EventService) {}

  ngOnInit(): void {
    this.eventService.getEventsPassed().subscribe((events: GameEvent[]) => {
      this.events = events;
    })
  }
}
