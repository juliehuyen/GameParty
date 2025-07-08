import {Injectable} from "@angular/core";
import {environment} from "../environnement/environnement";
import {catchError, Observable, of} from "rxjs";
import {Category, CategoryCreateInput} from "../data/category";
import BaseService from "./baseService";


@Injectable()
export class CategoryService extends BaseService<Category, CategoryCreateInput>{
  private categoriesUrl = `${environment.apiUrl}v1/categories`;

  findByName(name: string, sorted:boolean): Observable<Category[]> {
    return this.http.get<Category[]>(`${this.categoriesUrl}/name/sorted?name=${name}&sorted=${sorted}`).pipe(catchError(this.handleError<Category[]>('getAll')));
  }

  update(category: Category): Observable<Category> {
    return this.http.put<Category>(this.categoriesUrl, category)
      .pipe(
        catchError(this.handleError<Category>('update', category))
      )
  }

  getAllSorted(sorted : boolean): Observable<Category[]> {
    return this.http.get<Category[]>(`${this.categoriesUrl}/sorted?sorted=${sorted}`).pipe(catchError(this.handleError<Category[]>('getAllSorted')));
  }

  getEndpointUrl(): string {
    return "v1/categories";
  }
}
