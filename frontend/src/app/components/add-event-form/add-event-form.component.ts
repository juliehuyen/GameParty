import {Component, ElementRef, ViewChild} from '@angular/core';
import {Router} from "@angular/router";
import {FormBuilder, Validators} from "@angular/forms";
import {CategoryService} from "../../services/categoryService";
import {Category} from "../../data/category";
import {Type} from "../../data/type";
import {TypeService} from "../../services/typeService";
import Swal from "sweetalert2";
import {EventService} from "../../services/eventService";
import {EventCreateInput} from "../../data/gameEvent";
import {ModalService} from "../../services/modalService";
import * as bootstrap from 'bootstrap';
import {dateNotBeforeTodayValidator} from "../../validators/custom-validators";

@Component({
  selector: 'app-add-event-form',
  templateUrl: './add-event-form.component.html',
  styleUrl: './add-event-form.component.css'
})
export class AddEventFormComponent {
  categories: Category[] = [];
  types: Type[] = [];
  minDate: string = new Date().toISOString().split('T')[0];
  eventCreateInput! : EventCreateInput;
  @ViewChild('addEventModal') addEventModal!: ElementRef;

  constructor(private formBuilder: FormBuilder, private typeService: TypeService, private categoryService: CategoryService, private eventService: EventService, private router : Router, private modalService : ModalService) {
    this.modalService.openModal$.subscribe(() => {
      this.openModal();
    });
  }
  ngOnInit() {
    this.categoryService.getAll().subscribe(categories => this.categories = categories);
    this.typeService.getAll().subscribe(types => this.types = types);
  }

  openModal() {
    const modalElement = this.addEventModal.nativeElement;
    const modalInstance = new bootstrap.Modal(modalElement);
    modalInstance.show();
  }

  closeModal() {
    this.addEvent.reset();
    const modalElement = this.addEventModal.nativeElement;
    const modalInstance = bootstrap.Modal.getInstance(modalElement) || new bootstrap.Modal(modalElement);
    modalInstance.hide();
  }

  addEvent= this.formBuilder.group({
    title: ['', {validators: [Validators.required, Validators.minLength(5), Validators.maxLength(150)]}],
    category: ['', Validators.required],
    description: ['', {validators: [Validators.required, Validators.maxLength(2500)]}],
    eventDate: ['', [Validators.required, dateNotBeforeTodayValidator()]],
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
    console.log(this.minDate);
    if (this.addEvent.valid) {
      this.eventCreateInput = {
        title: this.addEvent.value.title ?? '',
        categoryId: this.addEvent.value.category ?? '',
        description: this.addEvent.value.description ?? '',
        eventDate: new Date(this.addEvent.value.eventDate ?? ''),
        typeId: this.addEvent.value.type ?? '',
        location: this.addEvent.value.location ?? ''
      };
      this.eventService
        .create(this.eventCreateInput)
        .subscribe(() => {
          this.closeModal();
          this.displayToast(true);
          setTimeout(() => {
            this.router.navigate(['/']);
          }, 1500);
      })
    }
    else{
      this.displayToast(false);
    }
  }

  displayToast(valid : boolean){
    const Toast = Swal.mixin({
      toast: true,
      position: "top",
      showConfirmButton: false,
      timer: 3000,
      timerProgressBar: true,
      didOpen: (toast) => {
        toast.onmouseenter = Swal.stopTimer;
        toast.onmouseleave = Swal.resumeTimer;
      }
    });
    if(valid){
      Toast.fire({
        icon: 'success',
        title: 'Evènement créé avec succès'
      });
    } else{
      Toast.fire({
        icon: 'error',
        title: 'Veuillez vérifier votre formulaire'
      })
    }
  }
}
