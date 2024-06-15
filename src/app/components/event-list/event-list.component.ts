import { Component } from '@angular/core';
import {GameEvent} from "../../data/gameEvent";
import {EventService} from "../../services/eventService";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrl: './event-list.component.css'
})
export class EventListComponent {
  events: GameEvent[] = [];
  activeButton: string = 'events';
  categoryId: string | null = '';

  // constructor(private eventService: EventService) {}
  //
  //
  // ngOnInit(): void {
  //   this.eventService.getEventsNotPassed().subscribe((events: GameEvent[]) => {
  //     this.events = events;
  //   })
  // }
  constructor(private eventService: EventService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.categoryId = params.get('categoryId');
      this.loadEvents();
    });
  }

  setActive(buttonName: string) {
    this.activeButton = buttonName;
  }

  private loadEvents() {
    if (this.categoryId && this.categoryId !== '') {
      this.eventService.getEventsNotPassedByCategory(this.categoryId).subscribe((events: GameEvent[]) => {
        this.events = events;
      });
    } else {
      this.eventService.getEventsNotPassed().subscribe((events: GameEvent[]) => {
        this.events = events;
      });
    }
  }

}
