import {Injectable} from "@angular/core";
import {environment} from "../environnement/environnement";
import {Type, TypeCreateInput} from "../data/type";
import BaseService from "./baseService";

@Injectable()
export class TypeService extends BaseService<Type, TypeCreateInput>{
  private typesUrl = `${environment.apiUrl}v1/types`;

  getEndpointUrl(): string {
    return "v1/types";
  }
}
