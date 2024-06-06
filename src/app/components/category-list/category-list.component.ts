import { Component } from '@angular/core';
import {CategoryService} from "../../services/categoryService";
import {Category} from "../../data/category";
import {Observable, of} from "rxjs";

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrl: './category-list.component.css'
})
export class CategoryListComponent {
  allCategories: Category[] = [];
  categoriesFromSearch: Observable<Category[]> | undefined;
  searchQuery: string = '';

  constructor(private categoryService: CategoryService) {}

  ngOnInit(): void {
    this.categoryService.getAll().subscribe(categories =>  this.allCategories = categories);
  }


  onSearchCategory(event: Event): void {
    console.log("coucou je change");
    const inputElement = event.target as HTMLInputElement;
    this.searchQuery = inputElement.value;
    if (this.searchQuery) {
      console.log(this.searchQuery);
      this.categoriesFromSearch = this.categoryService.findByName(this.searchQuery);
    } else {
      this.categoriesFromSearch = of(this.allCategories); // Revenir à toutes les catégories si la recherche est vide
    }
  }

  activeButton: string = 'categories';
  setActive(buttonName: string) {
    this.activeButton = buttonName;
  }


}
