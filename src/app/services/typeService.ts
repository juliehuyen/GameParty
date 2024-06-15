import {Injectable} from "@angular/core";
import {environment} from "../environnement/environnement";
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, of} from "rxjs";
import {Type} from "../data/type";
import {Event} from "../data/event";

@Injectable()
export class TypeService {
  private typesUrl = `${environment.apiUrl}v1/types`;

  constructor(private http: HttpClient) {
  }

  getAll() {
    return this.http.get<Type[]>(this.typesUrl).pipe(catchError(this.handleError<Type[]>('getAll')));
  }

  protected handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(`${operation} failed: ${error.message}`, error); // log to console
// Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
