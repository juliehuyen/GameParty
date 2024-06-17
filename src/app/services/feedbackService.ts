import {Injectable} from "@angular/core";
import {environment} from "../environnement/environnement";
import {HttpClient} from "@angular/common/http";
import {Feedback, FeedbackCreateInput} from "../data/feedback";
import {catchError, Observable, of} from "rxjs";
import {Router} from "@angular/router";

@Injectable()
export class FeedbackService  {
  private feedbacksUrl = `${environment.apiUrl}v1/feedbacks`;

  constructor(private http: HttpClient, private router: Router) {
  }

  getFeedbacksByEventId(eventId: string | null): Observable<Feedback[]> {
    return this.http.get<Feedback[]>(`${this.feedbacksUrl}/events/eventId?eventId=${eventId}`).pipe(catchError(this.handleError<Feedback[]>('getFeedbacksByEventId')));
  }

  createFeedback(feedbackCreateInput: FeedbackCreateInput): Observable<Feedback> {
    return this.http.post<Feedback>(this.feedbacksUrl, feedbackCreateInput).pipe(catchError(this.handleError<Feedback>('createFeedback')));
  }

  getFeedbackByUserIdAndEventId(userId: string, eventId: string | null | undefined): Observable<Feedback> {
    return this.http.get<Feedback>(`${this.feedbacksUrl}/users/${userId}/events/${eventId}`).pipe(catchError(this.handleError<Feedback>('getFeedbackByUserIdAndEventId')));
  }

  protected handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(`${operation} failed: ${error.message}`, error); // log to console
// Let the app keep running by returning an empty result.
      this.router.navigate(['/error']);
      return of(result as T);
    };
  }
}
