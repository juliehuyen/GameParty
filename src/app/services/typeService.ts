import {Injectable} from "@angular/core";
import {environment} from "../environnement/environnement";

@Injectable()
export class TypeService {
  private typesUrl = `${environment.apiUrl}v1/types`;

}
