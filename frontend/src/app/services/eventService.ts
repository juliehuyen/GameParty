import {Injectable} from "@angular/core";
import {environment} from "../environnement/environnement";
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, of} from "rxjs";
import {GameEvent, EventCreateInput} from "../data/gameEvent";
import {Router} from "@angular/router";
import BaseService from "./baseService";

@Injectable()
export class EventService extends BaseService<GameEvent, EventCreateInput>{
  private eventsUrl = `${environment.apiUrl}v1/events`;

  getEventById(id: string | null | undefined): Observable<GameEvent> {
    return this.http.get<GameEvent>(`${this.eventsUrl}/${id}`).pipe(catchError(this.handleError<GameEvent>('getEventById')));
  }

  getEventsByCategoryId(categoryId:string):Observable<GameEvent[]>{
    return this.http.get<GameEvent[]>(`${this.eventsUrl}/categories/categoryId?categoryId=${categoryId}`).pipe(catchError(this.handleError<GameEvent[]>('getEventsByCategoryId')));
  }

  update(event: GameEvent): Observable<GameEvent> {
    return this.http.put<GameEvent>(this.eventsUrl, event)
      .pipe(
        catchError(this.handleError<GameEvent>('update', event))
      )
  }

  getEventsPassed(): Observable<GameEvent[]> {
    return this.http.get<GameEvent[]>(`${this.eventsUrl}/passed`).pipe(catchError(this.handleError<GameEvent[]>('getEventsPassed')));
  }

  getEventsNotPassed(): Observable<GameEvent[]> {
    return this.http.get<GameEvent[]>(`${this.eventsUrl}/notPassed`).pipe(catchError(this.handleError<GameEvent[]>('getEventsNotPassed')));
  }

  getEventsNotPassedByCategory(categoryId: string): Observable<GameEvent[]> {
    return this.http.get<GameEvent[]>(`${this.eventsUrl}/notPassed/categories/categoryId?categoryId=${categoryId}`).pipe(catchError(this.handleError<GameEvent[]>('getEventsNotPassedByCategory')));
  }

  getEventsNotPassedSortedByDate(sorted: boolean): Observable<GameEvent[]> {
    return this.http.get<GameEvent[]>(`${this.eventsUrl}/notPassed/sorted-by-date?sorted=${sorted}`).pipe(catchError(this.handleError<GameEvent[]>('getEventsNotPassedSortedByDate')));
  }

  getEventsNotPassedSortedByParticipantsCount(sorted: boolean): Observable<GameEvent[]> {
    return this.http.get<GameEvent[]>(`${this.eventsUrl}/notPassed/sorted-by-participants?sorted=${sorted}`).pipe(catchError(this.handleError<GameEvent[]>('getEventsNotPassedSortedByParticipantsCount')));
  }

  getEventsPassedSortedByDate(sorted: boolean): Observable<GameEvent[]> {
    return this.http.get<GameEvent[]>(`${this.eventsUrl}/passed/sorted-by-date?sorted=${sorted}`).pipe(catchError(this.handleError<GameEvent[]>('getEventsPassedSortedByDate')));
  }

  getEventsPassedSortedByParticipantsCount(sorted: boolean): Observable<GameEvent[]> {
    return this.http.get<GameEvent[]>(`${this.eventsUrl}/passed/sorted-by-participants?sorted=${sorted}`).pipe(catchError(this.handleError<GameEvent[]>('getEventsPassedSortedByParticipantsCount')));
  }

  getEventsNotPassedSortedByDateByCategoryId(sorted: boolean, categoryId: string): Observable<GameEvent[]> {
    return this.http.get<GameEvent[]>(`${this.eventsUrl}/notPassed/sorted-by-date/categories/categoryId?sorted=${sorted}&categoryId=${categoryId}`).pipe(catchError(this.handleError<GameEvent[]>('getEventsNotPassedSortedByDate')));
  }

  getEventsNotPassedSortedByParticipantsCountByCategoryId(sorted: boolean, categoryId: string): Observable<GameEvent[]> {
    return this.http.get<GameEvent[]>(`${this.eventsUrl}/notPassed/sorted-by-participants/categories/categoryId?sorted=${sorted}&categoryId=${categoryId}`).pipe(catchError(this.handleError<GameEvent[]>('getEventsNotPassedSortedByParticipantsCount')));
  }

  getEndpointUrl(): string {
    return "v1/events";
  }
}
