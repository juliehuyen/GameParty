import {Component, Input, input} from '@angular/core';
import {GameEvent} from "../../data/gameEvent";
import {User} from "../../data/User";
import {RegistrationService} from "../../services/registrationService";
import {FormBuilder, Validators} from "@angular/forms";
import {UserService} from "../../services/userService";
@Component({
  selector: 'app-event-feedback-item',
  templateUrl: './event-feedback-item.component.html',
  styleUrl: './event-feedback-item.component.css'
})
export class EventFeedbackItemComponent {
  @Input()
  event!: GameEvent;
  users : User[] = [];

  constructor(private registrationService: RegistrationService, private formBuilder: FormBuilder, private userService: UserService) {}

  ngOnInit(){
    this.loadUsers(this.event.eventId);
  }
  loadUsers(eventId: string){
    this.registrationService.getUsersByEvent(eventId).subscribe(users => {
      this.users = users;
    })
  }

}

