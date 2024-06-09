import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CategoryListComponent} from "./components/category-list/category-list.component";
import {EventListComponent} from "./event-list/event-list.component";

const routes: Routes = [
  { path: '', component: CategoryListComponent },
  { path: 'event-list', component: EventListComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
