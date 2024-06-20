import { Component } from '@angular/core';
import {GameEvent} from "../../data/gameEvent";
import {EventService} from "../../services/eventService";

@Component({
  selector: 'app-event-feedback-list',
  templateUrl: './event-feedback-list.component.html',
  styleUrl: './event-feedback-list.component.css'
})
export class EventFeedbackListComponent {
  allEvents: GameEvent[] = [];
  activeButton: string = '';
  sortOrder: 'date-asc' | 'date-desc' | 'part-asc' | 'part-desc' = 'part-desc';
  loading: boolean = true;

  constructor(private eventService: EventService) {}

  ngOnInit(): void {
    this.loading = true;
    this.eventService.getEventsPassed().subscribe((events: GameEvent[]) => {
      this.allEvents = events;
      this.loading = false;
    })
  }

  setActive(buttonName: string) {
    this.activeButton = buttonName;
  }

  setSortOrder(order: Event): void {
    const selectElement = order.target as HTMLSelectElement;
    this.sortOrder = selectElement.value as 'date-asc' | 'date-desc' | 'part-asc' | 'part-desc';
    this.sortEvents();
  }

  sortEvents(): void {
    this.loading = true;
    if (this.sortOrder === 'date-asc') {
      this.eventService.getEventsPassedSortedByDate(true).subscribe((events: GameEvent[]) => {
        this.allEvents = events;
        this.loading = false;
      });
    }
    if (this.sortOrder === 'date-desc') {
      this.eventService.getEventsPassedSortedByDate(false).subscribe((events: GameEvent[]) => {
        this.allEvents = events;
        this.loading = false;
      });
    }
    if (this.sortOrder === 'part-asc') {
      this.eventService.getEventsPassedSortedByParticipantsCount(false).subscribe((events: GameEvent[]) => {
        this.allEvents = events;
        this.loading = false;
      });
    }
    if (this.sortOrder === 'part-desc') {
      this.eventService.getEventsPassedSortedByParticipantsCount(true).subscribe((events: GameEvent[]) => {
        this.allEvents = events;
        this.loading = false;
      });
    }
  }

  scrollToTop() {
    window.scrollTo(0, 0);
  }
}
