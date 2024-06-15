import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CategoryListComponent} from "./components/category-list/category-list.component";
import {EventListComponent} from "./components/event-list/event-list.component";
import {AddEventFormComponent} from "./components/add-event-form/add-event-form.component";

const routes: Routes = [
  { path: '', component: CategoryListComponent },
  { path: 'event-list', component: EventListComponent },
  { path: 'add-event', component: AddEventFormComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
