import { Component } from '@angular/core';
import {EventService} from "../services/eventService";
import {Event} from "../data/event"

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrl: './event-list.component.css'
})
export class EventListComponent {
  events: Event[] = [];
  activeButton: string = 'events';

  constructor(private eventService: EventService) {}


  ngOnInit(): void {
    this.eventService.getAll().subscribe((events: Event[]) => {
      this.events = events;
    })
  }

  setActive(buttonName: string) {
    this.activeButton = buttonName;
  }

}
