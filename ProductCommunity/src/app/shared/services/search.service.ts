import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SearchService {
  

  constructor(private http:HttpClient) { }

  getbySearch(SearchProduct:any): Observable<any> {
    console.log(SearchProduct);
    let params = new HttpParams();

    if(SearchProduct.Brand){
      console.log("brand");
      params=params.append('brand',SearchProduct.Brand)

    }
    if(SearchProduct.productCode){
      params=params.append('productCode',SearchProduct.productCode)
    }

    if(SearchProduct.productName){
      params=params.append('productName',SearchProduct.productName)
    }
    // console.log(params.toString());
    // console.log(params.);
    // console.log(params.get("productName"));
   
    return this.http.get<any>('http://localhost:8091/product/search',{params});
}
}
