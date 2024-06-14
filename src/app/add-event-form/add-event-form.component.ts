import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {FormBuilder, Validators} from "@angular/forms";
import {CategoryService} from "../services/categoryService";
import {Category} from "../data/category";
import {Type} from "../data/type";

class EventCreateInput {
}

@Component({
  selector: 'app-add-event-form',
  templateUrl: './add-event-form.component.html',
  styleUrl: './add-event-form.component.css'
})
export class AddEventFormComponent {
  categories: Category[] = [];
  types: Type[] = [];
  EventCreateInput! : EventCreateInput;
  constructor(private formBuilder: FormBuilder, private categoryService: CategoryService, private router : Router) { }

  addEvent= this.formBuilder.group({
    title: ['', {validators: [Validators.required, Validators.minLength(5), Validators.maxLength(150)]}],
    category: ['', Validators.required],
    description: ['', {validators: [Validators.required, Validators.maxLength(2500)]}],
    eventDate: ['', Validators.required],
    type: ['', Validators.required],
    location: ['', Validators.required]
   })

  get title() {
    return this.addEvent.controls['title'];
  }
  get category() {
    return this.addEvent.controls['category'];
  }
  get description() {
    return this.addEvent.controls['description'];
  }
  get eventDate() {
    return this.addEvent.controls['eventDate'];
  }
  get type() {
    return this.addEvent.controls['type'];
  }
  get location() {
    return this.addEvent.controls['location'];
  }
  onSubmit() {

  }

  onClose() {
    this.router.navigate(['/']);
  }
}
