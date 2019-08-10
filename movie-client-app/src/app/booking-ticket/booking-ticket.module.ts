import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BookingTicketComponent } from './booking-ticket.component';

@NgModule({
  declarations: [BookingTicketComponent],
  exports:[
    BookingTicketComponent
  ],
  imports: [
    CommonModule
  ]
})
export class BookingTicketModule { }
