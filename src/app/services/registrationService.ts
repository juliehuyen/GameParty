import {Injectable} from "@angular/core";
import {environment} from "../environnement/environnement";
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, of} from "rxjs";
import {User} from "../data/User";
import {Registration, RegistrationCreateInput} from "../data/registration";
import {Router} from "@angular/router";

@Injectable()
export class RegistrationService {
  private registrationUrl = `${environment.apiUrl}v1/registrations`;

  constructor(private http: HttpClient, private router: Router ) {
  }

  getUsersByEvent(eventId : string) : Observable<User[]> {
    return this.http.get<User[]>(`${this.registrationUrl}/event/eventId?eventId=${eventId}`).pipe(catchError(this.handleError<User[]>('getUsersByEvent')));
  }

  createRegistration(registration : RegistrationCreateInput) : Observable<Registration> {
    return this.http.post<Registration>(this.registrationUrl, registration).pipe(catchError(this.handleError<Registration>('createRegistration')));
  }

  isUserRegistered(username: string, eventId: string): Observable<boolean> {
    return this.http.get<boolean>(`${this.registrationUrl}/event/${eventId}/user/${username}`).pipe(catchError(this.handleError<boolean>('isUserRegistered')));
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
