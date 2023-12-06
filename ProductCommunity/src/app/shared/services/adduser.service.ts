import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdduserService {

  constructor(private httpClient:HttpClient) { }
  addUser(userDetail:any): Observable<any> {
    console.log(userDetail);
    return this.httpClient.post(`http://localhost:8091/user/register`,userDetail);
}

login(user:any){
  console.log("login")
  return this.httpClient.post(`http://localhost:8091/user/login`,user);

}
}
