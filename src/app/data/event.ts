import {Category} from "./category";
import {Type} from "./type";

export interface Event {
  eventId: string;
  title:string;
  description:string;
  eventDate:Date;
  location:string;
  category:Category;
  createdAt:Date;
  type:Type;
}
