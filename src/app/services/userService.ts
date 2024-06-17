import {Injectable} from "@angular/core";
import {environment} from "../environnement/environnement";
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, of} from "rxjs";
import {User, UserCreateInput} from "../data/User";
import {Router} from "@angular/router";

@Injectable()
export class UserService {
  private usersUrl = `${environment.apiUrl}v1/users`;

  constructor(private http: HttpClient, private router: Router ) {
  }

  getAll() : Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl).pipe(catchError(this.handleError<User[]>('getAll')));
  }

  create(user: UserCreateInput): Observable<User> {
    return this.http.post<User>(this.usersUrl, user).pipe(catchError(this.handleError<User>('create')));
  }

  delete(user: User): Observable<boolean> {
    return this.http.delete<boolean>(`${this.usersUrl}/${user.userId}`).pipe(catchError(this.handleError<boolean>('delete', false)));
  }

  findByName(name: string | null): Observable<User> {
    return this.http.get<User>(`${this.usersUrl}/name/${name}`).pipe(catchError(this.handleError<User>('findByName')));
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
