import { ProductService } from './../../services/product.service';
import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent {
   constructor(private productService:ProductService,private router:Router){
    if (sessionStorage.getItem('isLoggedIn') == 'true') {
      if (sessionStorage.getItem('admin') == 'true') {
        // this.router.navigate(['/admin/add']);
      }
      else {
        alert('You are Login as a User. You can not use Admin');
        this.router.navigate(['/product']);
      }

    }
    else {
      this.router.navigate(['/admin/login']);
    }

   }
  
  Product=new FormGroup({
    productCode: new FormControl(''),
    brand: new FormControl(''),
    description: new FormControl(''),
    img: new FormControl(''),
    productName:new FormControl(''),
    price: new FormControl('')
    
  })


  addProduct(){
    if(this.Product.value.productCode==''){
      alert('Enter Product Code');
    }
    this.productService.addProduct(this.Product.value).subscribe((data) => {
     
      alert('Product Added')
      this.router.navigate(['/admin']);
      // Handle data
    },
    (error) => {
      
      alert(error.error.text);
      this.router.navigate(['/admin']);
    });

  }

}
