import { FormControl, FormGroup } from '@angular/forms';
import { ProductServiceService } from './../../services/product-service.service';
import { Component, OnInit } from '@angular/core';
import { SearchService } from '../../services/search.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-page',
  templateUrl: './product-page.component.html',
  styleUrls: ['./product-page.component.css']
})
export class ProductPageComponent{
  results:any=[];
  result:any=[];
  resultLength=this.result.length;

  constructor(private SearchService:SearchService,private productService:ProductServiceService,private router:Router){
    console.log(sessionStorage.getItem('isLoggeIn'));
    if(sessionStorage.getItem('isLoggedIn')==null){
      this.router.navigate(['login']);
    }
  }
  

  SearchProduct= new FormGroup({
    productCode: new FormControl(''),
    Brand: new FormControl(''),
    productName: new FormControl('')

    
  })

 ngOnit(){
  // sessionStorage.getItem('isLoggedIn');
  if(sessionStorage.getItem('isLoggedIn')==null){
    this.router.navigate(['login']);
  }
 }
 
 
  search(){
    if(this.SearchProduct.value.Brand==null&&this.SearchProduct.value.productCode==null&&this.SearchProduct.value.productCode==null){
      alert('Provide atleast One Value')
    }
    else{
      this.SearchService.getbySearch(this.SearchProduct.value).subscribe(data=>{this.result=data;
      
      if(this.result.length==0){
        alert('No result Found');
        location.reload;
        this.SearchProduct.reset();
      }
      else{
      this.results=this.result;
    }
      
    
        });
      }
      

  }

  ngOnInit() {
    
    this.productService.getProducts().subscribe(data=>{this.results=data;
    console.log(this.results[0])});
    
    
  }


}
