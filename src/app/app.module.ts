import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TopBarComponent } from './components/top-bar/top-bar.component';
import { CategoryListComponent } from './components/category-list/category-list.component';
import { CategoryListItemComponent } from './components/category-list-item/category-list-item.component';
import {CategoryService} from "./services/categoryService";
import {ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {EventService} from "./services/eventService";

@NgModule({
  declarations: [
    AppComponent,
    TopBarComponent,
    CategoryListComponent,
    CategoryListItemComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [CategoryService,EventService],
  bootstrap: [AppComponent]
})
export class AppModule { }
