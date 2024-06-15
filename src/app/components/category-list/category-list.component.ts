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
  categoriesResult : Category[] = [];
  searchQuery: string = '';
  categoryEventCounts: Map<Category, number> = new Map();
  sortOrder: 'asc' | 'desc' = 'desc';

  constructor(private categoryService: CategoryService, private eventService: EventService) {}

  ngOnInit(): void {
    this.categoryService.getAll().subscribe(categories =>{
      this.allCategories = categories;
      this.loadEventCounts(categories);
      this.sortCategories();
    });

  }

  loadEventCounts(categories:Category[]): void {
    if (this.allCategories.length === 0){
      return;
    }

    const requests = categories.map(category =>
      this.eventService.getEventsNotPassedByCategory(category.categoryId).pipe(
        map(events => events.length), // Transform the array of events to its length
        catchError(() => of(0)) // Handle errors by returning 0
      )
    );

    forkJoin(requests).subscribe(results => {
      results.forEach((eventCount, index) => {
        const categoryId = categories[index].categoryId;
        this.categoryEventCounts.set(categories[index], eventCount);
      });
    });
  }

  onSearchCategory(event: Event): void {
    const inputElement = event.target as HTMLInputElement;
    this.searchQuery = inputElement.value;
    if (this.searchQuery) {
      this.searchCategories();
    } else {
      this.categoriesFromSearch = undefined;
      this.categoryService.getAll().subscribe(categories =>{
        this.allCategories = categories;
        this.loadEventCounts(categories);
        this.sortCategories();
      });
    }
  }

  activeButton: string = 'categories';
  setActive(buttonName: string) {
    this.activeButton = buttonName;
  }

  sortCategories(): void {
    if(this.sortOrder == 'asc'){
      this.categoryService.getAllSorted(false).subscribe(categories =>{
        this.allCategories = categories;
        this.loadEventCounts(categories);
      });
    } else{
      this.categoryService.getAllSorted(true).subscribe(categories =>{
        this.allCategories = categories;
        this.loadEventCounts(categories);
      });
    }
  }

  setSortOrder(order: Event): void {
    const selectElement = order.target as HTMLSelectElement;
    this.sortOrder = selectElement.value as 'asc' | 'desc';
    this.sortCategories();
    if (this.searchQuery) {
      this.searchCategories();
    }
  }

  private searchCategories() {
    if (this.sortOrder == 'desc') {
      this.categoriesFromSearch = this.categoryService.findByName(this.searchQuery, true);
    } else {
      this.categoriesFromSearch = this.categoryService.findByName(this.searchQuery, false);
    }
    this.categoriesFromSearch.subscribe(categories => {
      this.categoriesResult = categories;
      this.loadEventCounts(categories);
    });
  }
}
