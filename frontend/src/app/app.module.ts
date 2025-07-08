import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { TopBarComponent } from './components/top-bar/top-bar.component';
import { CategoryListComponent } from './components/category-list/category-list.component';
import { CategoryListItemComponent } from './components/category-list-item/category-list-item.component';
import {CategoryService} from "./services/categoryService";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {EventService} from "./services/eventService";
import { EventListComponent } from './components/event-list/event-list.component';
import { EventListItemComponent } from './components/event-list-item/event-list-item.component';
import {RegistrationService} from "./services/registrationService";
import {UserService} from "./services/userService";
import {TypeService} from "./services/typeService";
import { AddEventFormComponent } from './components/add-event-form/add-event-form.component';
import { EventFeedbackListComponent } from './components/event-feedback-list/event-feedback-list.component';
import { EventFeedbackItemComponent } from './components/event-feedback-item/event-feedback-item.component';
import { EventFeedbackDetailsComponent } from './components/event-feedback-details/event-feedback-details.component';
import { EventFeedbackDetailsItemComponent } from './components/event-feedback-details-item/event-feedback-details-item.component';
import {NgOptimizedImage} from "@angular/common";
import {FeedbackService} from "./services/feedbackService";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';

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
    EventFeedbackDetailsItemComponent,
    PageNotFoundComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgOptimizedImage,
    FormsModule,
    NgbModule
  ],
  providers: [CategoryService,EventService,RegistrationService,UserService,TypeService,FeedbackService],
  bootstrap: [AppComponent]
})
export class AppModule { }
