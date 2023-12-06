import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ProductServiceService } from 'src/app/shared/services/product-service.service';
import { ProductService } from '../../services/product.service';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent {
  results: any = [];
  constructor(private productService: ProductServiceService, private router: Router, private productservice: ProductService) {
    if (sessionStorage.getItem('isLoggedIn') == 'true') {
      if (sessionStorage.getItem('admin') == 'true') {
        this.router.navigate(['/admin']);
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
  ngOnInit() {
    this.productService.getProducts().subscribe(data => {
      this.results = data;
      console.log(this.results[0])
    });


  }

  deleteProduct(productCode: any) {
    this.productservice.deleteProduct(productCode).subscribe((data) => {
      this.router.navigate(['/admin'])
    },
      (error) => {

        alert(error.error.text);
        this.router.navigate(['/admin/reviews']);
      });
  }

  reviewPage() {
    this.router.navigate(['/admin/reviews']);

  }
  addProductForm() {
    this.router.navigate(['/admin/AddProduct']);

  }


}
