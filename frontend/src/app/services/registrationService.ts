import {Injectable} from "@angular/core";
import {environment} from "../environnement/environnement";
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, of} from "rxjs";
import {User} from "../data/User";
import {Registration, RegistrationCreateInput} from "../data/registration";
import {Router} from "@angular/router";
import BaseService from "./baseService";

@Injectable()
export class RegistrationService extends BaseService<Registration, RegistrationCreateInput>{
  private registrationUrl = `${environment.apiUrl}v1/registrations`;

  getUsersByEvent(eventId : string) : Observable<User[]> {
    return this.http.get<User[]>(`${this.registrationUrl}/events/eventId?eventId=${eventId}`).pipe(catchError(this.handleError<User[]>('getUsersByEvent')));
  }

  isUserRegistered(username: string, eventId: string): Observable<boolean> {
    return this.http.get<boolean>(`${this.registrationUrl}/events/${eventId}/users/${username}`).pipe(catchError(this.handleError<boolean>('isUserRegistered')));
  }

  getEndpointUrl(): string {
    return "v1/registrations";
  }

}
