import {Component, ElementRef, Input, ViewChild} from '@angular/core';
import {Event} from "../data/event";
import {User, UserCreateInput} from "../data/User";
import Swal from 'sweetalert2';
import {RegistrationService} from "../services/registrationService";
import {RegistrationCreateInput} from "../data/registration";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../services/userService";


@Component({
  selector: 'app-event-list-item',
  templateUrl: './event-list-item.component.html',
  styleUrl: './event-list-item.component.css'
})
export class EventListItemComponent {
  @Input()
  event!:Event;
  users : User[] = [];
  registrationCreateInput! : RegistrationCreateInput;
  userCreateInput! : UserCreateInput;
  @ViewChild('registrationModal') registrationModal!: ElementRef;
  @ViewChild('registeredUsersModal') registeredUsersModal!: ElementRef;

  constructor(private registrationService: RegistrationService, private formBuilder: FormBuilder, private userService: UserService) {}

  ngOnInit(){
    this.loadUsers(this.event.eventId);
  }

  ngAfterViewInit(){
    this.registrationModal.nativeElement.addEventListener('shown.bs.modal', () => {
      this.resetModal();
    })
    this.registeredUsersModal.nativeElement.addEventListener('shown.bs.modal', () => {
      this.users = [];
      this.loadUsers(this.event.eventId);
    });
  }



  protected readonly onsubmit = onsubmit;
  newRegistration =this.formBuilder.group({
    username: ['', Validators.required],
  })

  getUsername() {
    return this.newRegistration.controls.username;
  }

  onSubmitRegistration() {
    let username: string | null;
    if (this.newRegistration.valid) {
      username = this.newRegistration.controls.username.value;
      this.userService.findByName(username).subscribe(user => {
        if(user != null){
          this.displayToast(false);
        } else{
          this.userCreateInput = {
            username: username ?? ''
          }
          this.userService.create(this.userCreateInput).subscribe(user => {
            this.registrationCreateInput = {
              userId: user.userId,
              eventId: this.event.eventId,
            }
            this.registrationService.createRegistration(this.registrationCreateInput).subscribe(registration => {
              this.displayToast(true);
              this.registrationService.getUsersByEvent(this.event.eventId).subscribe(users => {
                this.users = users;
              })
            })
          })
        }
      })
    }
  }

  get username(){
    return this.newRegistration.controls.username;
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
        title: 'Inscription faite avec succès'
      });
    } else{
      Toast.fire({
        icon: 'error',
        title: 'L\'utilisateur est déjà inscrit à cet événement'
      })
    }
  }

  resetModal(){
    this.newRegistration.reset();
  }

  loadUsers(eventId: string){
    console.log(eventId);
    this.registrationService.getUsersByEvent(eventId).subscribe(users => {
      this.users = users;
    })
  }
}
