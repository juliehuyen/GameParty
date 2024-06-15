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
import { EventListComponent } from './components/event-list/event-list.component';
import { EventListItemComponent } from './components/event-list-item/event-list-item.component';
import {RegistrationService} from "./services/registrationService";
import {UserService} from "./services/userService";
import {TypeService} from "./services/typeService";
import { AddEventFormComponent } from './add-event-form/add-event-form.component';
import { EventFeedbackListComponent } from './event-feedback-list/event-feedback-list.component';
import { EventFeedbackItemComponent } from './event-feedback-item/event-feedback-item.component';
import { EventFeedbackDetailsComponent } from './event-feedback-details/event-feedback-details.component';

@NgModule({
  declarations: [
    AppComponent,
    TopBarComponent,
    CategoryListComponent,
    CategoryListItemComponent,
    EventListComponent,
    EventListItemComponent,
    AddEventFormComponent,
    EventFeedbackListComponent,
    EventFeedbackItemComponent,
    EventFeedbackDetailsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [CategoryService,EventService,RegistrationService,UserService,TypeService],
  bootstrap: [AppComponent]
})
export class AppModule { }
