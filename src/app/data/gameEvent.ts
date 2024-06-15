import {Category} from "./category";
import {Type} from "./type";

export interface GameEvent {
  eventId: string;
  title:string;
  description:string;
  eventDate:Date;
  location:string;
  category:Category;
  createdAt:Date;
  type:Type;
}

export type EventCreateInput = Omit<Event,'eventId' |'category' | 'type' | 'createdAt'>&{
  categoryId:string;
  typeId:string;
}
