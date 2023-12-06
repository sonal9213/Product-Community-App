import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  constructor(private http:HttpClient) { }

  addReview(Review:any,ProductCode:any): Observable<any> {
    console.log(Review);
    
    
   
    return this.http.post(`http://localhost:8091/Review/${ProductCode}`,Review);
}

countReview(product:any):Observable<any> {
 
  
  
 
  return this.http.post(`http://localhost:8091/Review/countReviews`,product);
}
AverageReview(product:any):Observable<any> {
 
  return this.http.post(`http://localhost:8091/Review/average`,product);
}


}
