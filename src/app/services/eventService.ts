import {Injectable} from "@angular/core";
import {environment} from "../environnement/environnement";
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, of} from "rxjs";
import {GameEvent, EventCreateInput} from "../data/gameEvent";

@Injectable()
export class EventService {
  private eventsUrl = `${environment.apiUrl}v1/events`;

  constructor(private http: HttpClient) {
  }

  create(event: EventCreateInput): Observable<Event> {
    return this.http.post<Event>(this.eventsUrl, event);
  }

  getAll() : Observable<GameEvent[]> {
    return this.http.get<GameEvent[]>(this.eventsUrl).pipe(catchError(this.handleError<GameEvent[]>('getAll')));
  }

  getEventById(id:string): Observable<Event> {
    return this.http.get<Event>(`${this.eventsUrl}/${id}`).pipe(catchError(this.handleError<Event>('getEventById')));
  }

  getEventsByCategoryId(categoryId:string):Observable<GameEvent[]>{
    return this.http.get<GameEvent[]>(`${this.eventsUrl}/category/categoryId?categoryId=${categoryId}`).pipe();
  }

  update(event: GameEvent): Observable<GameEvent> {
    return this.http.put<GameEvent>(this.eventsUrl, event)
      .pipe(
        catchError(this.handleError<GameEvent>('update', event))
      )
  }
  protected handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(`${operation} failed: ${error.message}`, error); // log to console
// Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
  delete(event: GameEvent): Observable<boolean> {
    return this.http.delete<boolean>(`${this.eventsUrl}/${event.eventId}`);
  }

  getEventsPassed(): Observable<GameEvent[]> {
    return this.http.get<GameEvent[]>(`${this.eventsUrl}/passed`).pipe(catchError(this.handleError<GameEvent[]>('getEventsPassed')));
  }

  getEventsNotPassed(): Observable<GameEvent[]> {
    return this.http.get<GameEvent[]>(`${this.eventsUrl}/notPassed`).pipe(catchError(this.handleError<GameEvent[]>('getEventsNotPassed')));
  }
}
