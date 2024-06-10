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
import { EventListComponent } from './event-list/event-list.component';
import { EventListItemComponent } from './event-list-item/event-list-item.component';
import {RegistrationService} from "./services/registrationService";
import {UserService} from "./services/userService";

@NgModule({
  declarations: [
    AppComponent,
    TopBarComponent,
    CategoryListComponent,
    CategoryListItemComponent,
    EventListComponent,
    EventListItemComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [CategoryService,EventService,RegistrationService,UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
