import {Injectable} from "@angular/core";
import {environment} from "../environnement/environnement";
import {catchError, Observable, of} from "rxjs";
import {User, UserCreateInput} from "../data/User";
import BaseService from "./baseService";

@Injectable()
export class UserService extends BaseService<User, UserCreateInput>{
  private usersUrl = `${environment.apiUrl}v1/users`;

  findByName(name: string | null): Observable<User> {
    return this.http.get<User>(`${this.usersUrl}/name/${name}`).pipe(catchError(this.handleError<User>('findByName')));
  }

  getEndpointUrl(): string {
    return "v1/users";
  }
}
