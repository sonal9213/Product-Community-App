import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReviewsService {

  constructor(private httpClient:HttpClient) { }
  getReviews(): Observable<any> {
    
    return this.httpClient.get("http://localhost:8091/Reviews");
  }

  approveReview(reviewCode:any): Observable<any>{
    return this.httpClient.patch(`http://localhost:8091/Review/${reviewCode}/approve`,"")

  }
  
  deleteReview(reviewCode:any): Observable<any>{
    return this.httpClient.delete(`http://localhost:8091/Review/${reviewCode}`)

  }
}
