import {Injectable} from "@angular/core";
import {environment} from "../environnement/environnement";
import {HttpClient} from "@angular/common/http";
import {Feedback, FeedbackCreateInput} from "../data/feedback";
import {Observable} from "rxjs";

@Injectable()
export class FeedbackService  {
  private feedbacksUrl = `${environment.apiUrl}v1/feedbacks`;

  constructor(private http: HttpClient) {
  }

  getFeedbacksByEventId(eventId: string | null): Observable<Feedback[]> {
    return this.http.get<Feedback[]>(`${this.feedbacksUrl}/event/eventId?eventId=${eventId}`).pipe();
  }

  createFeedback(feedbackCreateInput: FeedbackCreateInput): Observable<Feedback> {
    return this.http.post<Feedback>(this.feedbacksUrl, feedbackCreateInput).pipe();
  }

  getFeedbackByUserIdAndEventId(userId: string, eventId: string | null | undefined): Observable<Feedback> {
    return this.http.get<Feedback>(`${this.feedbacksUrl}/user/${userId}/event/${eventId}`).pipe();
  }
}
