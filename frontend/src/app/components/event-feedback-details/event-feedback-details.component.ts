import {Component, ElementRef, ViewChild} from '@angular/core';
import {GameEvent} from "../../data/gameEvent";
import {ActivatedRoute, Router} from "@angular/router";
import {EventService} from "../../services/eventService";
import {Feedback, FeedbackCreateInput} from "../../data/feedback";
import {FeedbackService} from "../../services/feedbackService";
import {FormBuilder, Validators} from "@angular/forms";
import {UserService} from "../../services/userService";
import {User, UserCreateInput} from "../../data/User";
import Swal from "sweetalert2";
import * as bootstrap from 'bootstrap';

@Component({
  selector: 'app-event-feedback-details',
  templateUrl: './event-feedback-details.component.html',
  styleUrl: './event-feedback-details.component.css'
})
export class EventFeedbackDetailsComponent {
  eventId: string | null | undefined ;
  event: GameEvent | undefined;
  feedbacks: Feedback[] | undefined;
  rating: number = 0;
  feedbackCreateInput!: FeedbackCreateInput | undefined;
  userCreateInput!: UserCreateInput | undefined;
  @ViewChild('createFeedbackModal') createFeedbackModal!: ElementRef;
  loading: boolean = true;


  constructor(private route: ActivatedRoute, private eventService : EventService, private feedbackService : FeedbackService, private formBuilder : FormBuilder, private userService : UserService, private router : Router) {}

  ngOnInit(): void {
    this.loadFeedbacks();
  }

  private loadFeedbacks() {
    this.loading = true;
    this.eventId = this.route.snapshot.paramMap.get('eventId');
    this.eventService.getEventById(this.eventId).subscribe(
      event => {
        this.event = event;
        this.feedbackService.getFeedbacksByEventId(this.event.eventId).subscribe(
          feedbacks => {
            this.feedbacks = feedbacks;
            this.loading = false;
          }
        );
      });
  }

  newFeedback = this.formBuilder.group({
    rating: [this.rating, [Validators.required, Validators.min(1)]],
    username: ['', Validators.required],
    comments: ['']
  });
  get username() {
    return this.newFeedback.controls.username;
  }

  onSubmitFeedback() {
    console.log(this.newFeedback.controls.rating.value);
    console.log(this.newFeedback.controls.username.value);
    if(this.newFeedback.valid){
      this.userService.findByName(this.newFeedback.controls.username.value).subscribe(user => {
        if(user != null){
          this.createFeedbackCall(user);
        } else {
          this.userCreateInput = {
            username: this.newFeedback.controls.username.value ?? ''
          }
          this.userService.create(this.userCreateInput).subscribe(user => {
            this.createFeedbackCall(user);
          });
        }
      });
    }else{
      Swal.fire({
        icon: 'error',
        title: 'Erreur',
        text: 'Veuillez remplir tous les champs'
      });
      this.resetFormAndModal();
    }
  }

  private createFeedbackCall(user: User) {
    this.feedbackService.getFeedbackByUserIdAndEventId(user.userId, this.eventId).subscribe(feedback => {
      if (feedback == null) {
        this.eventService.getEventById(this.eventId).subscribe(event =>{
          const currentDate = new Date();
          if(event.eventDate < currentDate){
            this.feedbackCreateInput = {
              rating: this.rating,
              userId: user.userId,
              comments: this.newFeedback.controls.comments.value ?? '',
              eventId: this.eventId ?? ''
            }
            if (this.feedbackCreateInput) {
              this.feedbackService.create(this.feedbackCreateInput).subscribe(feedback => {
                this.displayToast(true, user);
                this.loadFeedbacks();
              });
            }
          } else{
            Swal.fire({
              icon : "error",
              title: "L'évènement n'est pas encore passé, impossible d'y ajouter un avis !"
            });
          }
        });

      } else {
        this.displayToast(false, user);
        this.resetFormAndModal();
      }
    });
  }

  displayToast(valid : boolean, user : User){
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
        title: 'Avis créé avec succès'
      });
    } else{
      Toast.fire({
        icon: 'error',
        title: 'L\'utilisateur : ' + user.username +' a déjà donné un avis sur cet évènement'
      })
    }
  }

  onRatingChange(newRating: number) {
    this.newFeedback.controls.rating.setValue(newRating);
  }

  resetFormAndModal() {
    this.newFeedback.reset();
    this.rating = 0;
    const modalElement = this.createFeedbackModal.nativeElement;
    const modalInstance = bootstrap.Modal.getInstance(modalElement);
    if (modalInstance) {
      modalInstance.hide();
    }
  }
}
