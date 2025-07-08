import {Feedback} from "./feedback";

export interface Category {
  categoryId:string;
  name:string;
  url:string;
}
export type CategoryCreateInput = Omit<Category, 'categoryId'>;
