import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {environment} from "../../environment/environment";


@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private serverUrl = (window as any).appConfig.apiUrl;
  constructor(private http: HttpClient) {}

  login(credentials: { email: string; password: string }): Observable<any> {
    return this.http.post(this.serverUrl+"/login", credentials);
  }
  register(user: { firstName: string; lastName: string; email: string; password: string }) {
    return this.http.post(this.serverUrl+"/api/user", user);
  }


}
