import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {environment} from "../../environment/environment";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = `${(window as any).appConfig.apiUrl}/api/user`;
  constructor(private http: HttpClient) {}

  getProfile(): Observable<any> {
    return this.http.get(this.apiUrl);
  }

  getUserByEmail(email: string): Observable<any> {
    return this.http.get(`${this.apiUrl}/${email}`);
  }


}
