import { Component } from '@angular/core';
import {CategoryService} from "../../services/categoryService";
import {Category} from "../../data/category";

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrl: './category-list.component.css'
})
export class CategoryListComponent {
  categories: Category[] = [];

  constructor(private categoryService: CategoryService) {}

  ngOnInit(): void {
    this.categoryService.getAll().subscribe(categories => this.categories = categories);
  }

  activeButton: string = 'categories';
  setActive(buttonName: string) {
    this.activeButton = buttonName;
  }


}
