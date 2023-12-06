import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StatsService {

  constructor(private httpClient:HttpClient) { }

  getCount(): Observable<any> {
    
    return this.httpClient.get("http://localhost:8091/count");
  }
}
