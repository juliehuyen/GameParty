import {Injectable} from "@angular/core";
import {environment} from "../environnement/environnement";
import {HttpClient} from "@angular/common/http";
import {catchError, Observable, of} from "rxjs";
import {Category} from "../data/category";

@Injectable()
export class CategoryService {
  private categoriesUrl = `${environment.apiUrl}v1/categories`;


  constructor(private http: HttpClient) {
  }

  getAll() : Observable<Category[]> {
    return this.http.get<Category[]>(this.categoriesUrl).pipe(catchError(this.handleError<Category[]>('getAll')));
  }

  findByName(name: string, sorted:boolean): Observable<Category[]> {
    return this.http.get<Category[]>(`${this.categoriesUrl}/name/sorted?name=${name}&sorted=${sorted}`).pipe(catchError(this.handleError<Category[]>('getAll')));
  }

  update(category: Category): Observable<Category> {
    return this.http.put<Category>(this.categoriesUrl, category)
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
    return this.http.delete<boolean>(`${this.categoriesUrl}/${category.categoryId}`);
  }

  getAllSorted(sorted : boolean): Observable<Category[]> {
    return this.http.get<Category[]>(`${this.categoriesUrl}/sorted?sorted=${sorted}`).pipe(catchError(this.handleError<Category[]>('getAllSorted')));
  }
}
