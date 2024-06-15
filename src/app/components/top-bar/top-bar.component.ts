import { Component } from '@angular/core';
import {ModalService} from "../../services/modalService";

@Component({
  selector: 'app-top-bar',
  templateUrl: './top-bar.component.html',
  styleUrl: './top-bar.component.css'
})
export class TopBarComponent {

  constructor(private modalService: ModalService) {}

  openAddEventModal() {
    this.modalService.triggerOpenModal();
  }
}
