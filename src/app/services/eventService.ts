import {Injectable} from "@angular/core";
import {environment} from "../environnement/environnement";
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, of} from "rxjs";
import {Category} from "../data/category";

@Injectable()
export class EventService {
  private eventsUrl = `${environment.apiUrl}v1/events`;


  constructor(private http: HttpClient) {
  }

  getAll() : Observable<Category[]> {
    return this.http.get<Category[]>(this.eventsUrl).pipe(catchError(this.handleError<Category[]>('getAll')));
  }

  getEventById(id:string): Observable<Category> {
    return this.http.get<Category>(`${this.eventsUrl}/${id}`).pipe(catchError(this.handleError<Category>('getEventById')));
  }

  getEventsByCategoryId(categoryId:string):Observable<Event[]>{
    return this.http.get<Event[]>(`${this.eventsUrl}/category/categoryId?categoryId=${categoryId}`).pipe();
  }

  findByName(name: string): Observable<Category[]> {
    return this.http.get<Category[]>(`${this.eventsUrl}/name?name=${name}`).pipe(catchError(this.handleError<Category[]>('getAll')));
  }

  update(category: Category): Observable<Category> {
    return this.http.put<Category>(this.eventsUrl, category)
      .pipe(
        catchError(this.handleError<Category>('update', category))
      )
  }
  protected handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(`${operation} failed: ${error.message}`, error); // log to console
// Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
  delete(category: Category): Observable<boolean> {
    return this.http.delete<boolean>(`${this.eventsUrl}/${category.categoryId}`);
  }
}
