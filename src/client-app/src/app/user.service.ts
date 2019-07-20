import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

let restAPI=``;
@Injectable({
  providedIn: 'root'
})
export class UserService {
  restAPI: string = "";
  constructor(private http: HttpClient) { 
    restAPI = environment.restAPI;
  }

  getUser(id: number): Observable<any> {
    return this.http.get(`${this.restAPI}/by-id/${id}`);
  }

  createUser(user: Object): Observable<Object> {
    return this.http.post(`${this.restAPI}/add`,user) ;
  }

  updateUser(user: Object): Observable<Object> {
    return this.http.put(`${this.restAPI}/update`, user);
  }

  deleteUser(id: number): Observable<any> {
    return this.http.delete(`${this.restAPI}/delete/${id}`, { responseType: 'text' });
  }

  getUserList(): Observable<any> {
    return this.http.get(`${this.restAPI}/all`);
  }
}