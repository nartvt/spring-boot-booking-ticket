import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-booking-ticket',
  templateUrl: './booking-ticket.component.html',
  styleUrls: ['./booking-ticket.component.scss']
})
export class BookingTicketComponent implements OnInit {

  public COLUMNS_ARRAYS = [1,2,3,4,5,6,7,8,9,10,11,12];
  public ROWS_ARRAYS = ['A','B','C','D','E','F','G','H','I','J'];
  public mapingDatas:any = [ ];
  constructor() { }

  ngOnInit() {
    this. mapingColumnRow();
    console.log(this.mapingDatas.length);
  }

  mapingColumnRow(){
    this.COLUMNS_ARRAYS.forEach((element,index) => {
      // console.log(element);
      let data = {
        column: element,
        row: this.ROWS_ARRAYS[element-1]
      };
      this.mapingDatas.push(data);

    });
  }

}
