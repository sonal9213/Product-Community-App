import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http:HttpClient) { }

  deleteProduct(productCode:any)
  {
    return this.http.delete(`http://localhost:8091/products/delete/${productCode}`);
  }

  addProduct(product:any){
    return this.http.post(`http://localhost:8091/products`,product);
  }
}
