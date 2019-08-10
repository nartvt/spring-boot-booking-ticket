import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MovieService {
seatMap = [
  'aaaaaaaaaa',
  'aaaaaaaaaa',
  '__________',
  'aaaaaaaa__',
  'aaaaaaaaaa',
  'aaaaaaaaaa',
  'aaaaaaaaaa',
  'aaaaaaaaaa',
  'aaaaaaaaaa',
  '__aaaaaa__'
];
seatStatus = {
  node: $('#legend'),
  items: [
    ['a', 'available', 'Available'],
    ['a', 'unavailable', 'Sold'],
    ['a', 'selected', 'Selected']
  ]
}
  constructor() { }
}
