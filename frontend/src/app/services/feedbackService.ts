import {Injectable} from "@angular/core";
import {environment} from "../environnement/environnement";
import {HttpClient} from "@angular/common/http";
import {Feedback, FeedbackCreateInput} from "../data/feedback";
import {catchError, Observable, of} from "rxjs";
import {Router} from "@angular/router";
import BaseService from "./baseService";

@Injectable()
export class FeedbackService extends BaseService<Feedback, FeedbackCreateInput>{
  private feedbacksUrl = `${environment.apiUrl}v1/feedbacks`;

  getFeedbacksByEventId(eventId: string | null): Observable<Feedback[]> {
    return this.http.get<Feedback[]>(`${this.feedbacksUrl}/events/eventId?eventId=${eventId}`).pipe(catchError(this.handleError<Feedback[]>('getFeedbacksByEventId')));
  }

  getFeedbackByUserIdAndEventId(userId: string, eventId: string | null | undefined): Observable<Feedback> {
    return this.http.get<Feedback>(`${this.feedbacksUrl}/users/${userId}/events/${eventId}`).pipe(catchError(this.handleError<Feedback>('getFeedbackByUserIdAndEventId')));
  }

  getEndpointUrl(): string {
    return "v1/feedbacks";
  }
}
