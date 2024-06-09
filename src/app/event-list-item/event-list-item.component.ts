import {Component, Input} from '@angular/core';
import {Event} from "../data/event";
import {User} from "../data/User";
import {EventService} from "../services/eventService";
import {RegistrationService} from "../services/registrationService";
import {RegistrationCreateInput} from "../data/registration";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";


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

  constructor(private registrationService: RegistrationService, private formBuilder: FormBuilder) {}

  ngOnInit(){
    this.registrationService.getUsersByEvent(this.event.eventId).subscribe(users =>{
      this.users = users;
    })
  }

  protected readonly onsubmit = onsubmit;
  newRegistration =this.formBuilder.group({
    username: ['', Validators.required],
  })

  getUsername() {
    return this.newRegistration.controls.username;
  }

  onSubmitRegistration() {
    if(this.newRegistration.valid){
      this.registrationCreateInput = {
        userId:this.newRegistration.controls.username ?? ''
      };
    }
  }
}
