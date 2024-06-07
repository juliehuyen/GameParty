import {Component, Input} from '@angular/core';
import {Category} from "../../data/category";

@Component({
  selector: 'app-category-list-item',
  templateUrl: './category-list-item.component.html',
  styleUrl: './category-list-item.component.css'
})
export class CategoryListItemComponent {

  @Input()
  category!:Category;
  @Input()
  eventsCount:number = 0;
}
