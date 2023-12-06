import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  constructor(private httpClient: HttpClient) { }
  getProducts(): Observable<any> {
    
    return this.httpClient.get("http://localhost:8091/products");
  }

  getProductsById(id:any): Observable<any> {
    
    return this.httpClient.get(`http://localhost:8091/product/${id}`);
  }

  


}
