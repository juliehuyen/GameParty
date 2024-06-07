import {Component, numberAttribute} from '@angular/core';
import {CategoryService} from "../../services/categoryService";
import {Category} from "../../data/category";
import {catchError, forkJoin, map, Observable, of} from "rxjs";
import {EventService} from "../../services/eventService";

@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrl: './category-list.component.css'
})
export class CategoryListComponent {
  allCategories: Category[] = [];
  categoriesFromSearch: Observable<Category[]> | undefined;
  searchQuery: string = '';
  categoryEventCounts: Map<Category, number> = new Map();

  constructor(private categoryService: CategoryService, private eventService: EventService) {}

  ngOnInit(): void {
    this.categoryService.getAll().subscribe(categories =>{
      this.allCategories = categories;
      this.loadEventCounts();
    });
  }

  loadEventCounts(): void {
    if (this.allCategories.length === 0){
      console.log("souciiiis");
      return;
    }

    const requests = this.allCategories.map(category =>
      this.eventService.getEventsByCategoryId(category.categoryId).pipe(
        map(events => events.length), // Transform the array of events to its length
        catchError(() => of(0)) // Handle errors by returning 0
      )
    );

    forkJoin(requests).subscribe(results => {
      results.forEach((eventCount, index) => {
        const categoryId = this.allCategories[index].categoryId;
        this.categoryEventCounts.set(this.allCategories[index], eventCount);
      });
    });
  }

  onSearchCategory(event: Event): void {
    const inputElement = event.target as HTMLInputElement;
    this.searchQuery = inputElement.value;
    if (this.searchQuery) {
      this.categoriesFromSearch = this.categoryService.findByName(this.searchQuery);
      this.categoriesFromSearch.subscribe(categories => {
        this.allCategories = categories;
        this.loadEventCounts();
      });
    } else {
      this.categoriesFromSearch = of(this.allCategories); // Revenir à toutes les catégories si la recherche est vide
    }
  }

  activeButton: string = 'categories';
  setActive(buttonName: string) {
    this.activeButton = buttonName;
  }


}
