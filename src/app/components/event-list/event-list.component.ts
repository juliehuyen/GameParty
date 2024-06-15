import { Component } from '@angular/core';
import {EventService} from "../services/eventService";
import {GameEvent} from "../data/gameEvent"

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrl: './event-list.component.css'
})
export class EventListComponent {
  events: GameEvent[] = [];
  activeButton: string = 'events';

  constructor(private eventService: EventService) {}


  ngOnInit(): void {
    this.eventService.getEventsNotPassed().subscribe((events: GameEvent[]) => {
      this.events = events;
    })
  }

  setActive(buttonName: string) {
    this.activeButton = buttonName;
  }

}
