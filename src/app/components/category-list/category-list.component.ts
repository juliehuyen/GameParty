import { Component } from '@angular/core';
import {CategoryService} from "../../services/categoryService";

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrl: './category-list.component.css'
})
export class CategoryListComponent {

  //constructor(private categoryService: CategoryService) {}

  activeButton: string = 'categories';
  setActive(buttonName: string) {
    this.activeButton = buttonName;
  }


}
