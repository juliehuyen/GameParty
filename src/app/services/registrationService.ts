import {Injectable} from "@angular/core";
import {environment} from "../environnement/environnement";
import {HttpClient} from "@angular/common/http";
import {catchError, Observable} from "rxjs";
import {User} from "../data/User";
import {Category} from "../data/category";
import {Registration, RegistrationCreateInput} from "../data/registration";

@Injectable()
export class RegistrationService {
  private registrationUrl = `${environment.apiUrl}v1/registrations`;

  constructor(private http: HttpClient) {
  }

  getUsersByEvent(eventId : string) : Observable<User[]> {
    return this.http.get<User[]>(`${this.registrationUrl}/event/eventId?eventId=${eventId}`).pipe();
  }

  createRegistration(registration : RegistrationCreateInput) : Observable<Registration> {
    return this.http.post<Registration>(this.registrationUrl, registration);
  }

  isUserRegistered(username: string, eventId: string): Observable<boolean> {
    return this.http.get<boolean>(`${this.registrationUrl}/event/${eventId}/user/${username}`).pipe();
  }
}
