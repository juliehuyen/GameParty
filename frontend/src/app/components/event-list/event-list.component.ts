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
  allEvents: GameEvent[] = [];
  activeButton: string = 'events';
  categoryId: string | null = '';
  sortOrder: 'date-asc' | 'date-desc' | 'part-asc' | 'part-desc' = 'part-desc';
  loading: boolean = true;

  constructor(private eventService: EventService, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.categoryId = params.get('categoryId');
      this.sortEvents();
      // this.loadEvents();
    });
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
    if (this.categoryId == '' || this.categoryId == null) {
      if (this.sortOrder === 'date-asc') {
        this.eventService.getEventsNotPassedSortedByDate(true).subscribe((events: GameEvent[]) => {
          this.allEvents = events;
          this.loading = false;
        });
      }
      if (this.sortOrder === 'date-desc') {
        this.eventService.getEventsNotPassedSortedByDate(false).subscribe((events: GameEvent[]) => {
          this.allEvents = events;
          this.loading = false;
        });
      }
      if (this.sortOrder === 'part-asc') {
        this.eventService.getEventsNotPassedSortedByParticipantsCount(false).subscribe((events: GameEvent[]) => {
          this.allEvents = events;
          this.loading = false;
        });
      }
      if (this.sortOrder === 'part-desc') {
        this.eventService.getEventsNotPassedSortedByParticipantsCount(true).subscribe((events: GameEvent[]) => {
          this.allEvents = events;
          this.loading = false;
        });
      }
    }
    else {
      if (this.sortOrder === 'date-asc') {
        this.eventService.getEventsNotPassedSortedByDateByCategoryId(true, this.categoryId).subscribe((events: GameEvent[]) => {
          this.allEvents = events;
          this.loading = false;
        });
      }
      if (this.sortOrder === 'date-desc') {
        this.eventService.getEventsNotPassedSortedByDateByCategoryId(false, this.categoryId).subscribe((events: GameEvent[]) => {
          this.allEvents = events;
          this.loading = false;
        });
      }
      if (this.sortOrder === 'part-asc') {
        this.eventService.getEventsNotPassedSortedByParticipantsCountByCategoryId(false, this.categoryId).subscribe((events: GameEvent[]) => {
          this.allEvents = events;
          this.loading = false;
        });
      }
      if (this.sortOrder === 'part-desc') {
        this.eventService.getEventsNotPassedSortedByParticipantsCountByCategoryId(true, this.categoryId).subscribe((events: GameEvent[]) => {
          this.allEvents = events;
          this.loading = false;
        });
      }
    }

  }

  scrollToTop(): void {
    window.scrollTo(0, 0);
  }
}
