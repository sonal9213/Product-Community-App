import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductServiceService } from '../../services/product-service.service';
import { FormControl, FormGroup } from '@angular/forms';
import { ReviewService } from '../../services/review.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent {
  username: any = sessionStorage.getItem('name');
  result: any = [];
  productId: any = "";
  product: any;
  countReview = 0;
  average=0;


  Review = new FormGroup({
    userName: new FormControl(this.username),
    heading: new FormControl(''),
    msg: new FormControl(''),
    rating: new FormControl('')

  })

  constructor(private route: ActivatedRoute, private productService: ProductServiceService, private ReviewService: ReviewService) {

  }
  // totalReviews:any=this.countReviews();
  ngOnInit() {

    this.productId = this.route.snapshot.paramMap.get('id');
    this.productService.getProductsById(this.productId).subscribe(data => {
      this.result = data;
      console.log(this.result);


    }

    );
    this.countReview = this.countReviews();
    this.average=this.ReviewAverage();
  }
  addReview() {
    console.log(this.Review.value);
    this.ReviewService.addReview(this.Review.value, this.productId).subscribe(data => { console.log(data); alert('review Added will show after approval by Admin'); this.Review.reset(); })
  };


  countReviews(): number {
    let count = 0;
    let product = this.productService.getProductsById(this.productId).subscribe(data => {
      product = data;
      console.log(this.product);
      this.ReviewService.countReview(product).subscribe(data => { this.countReview = data; console.log(data + "sonal") })
      console.log(count);
    });


    return count;

  };

  ReviewAverage(): number {
    let average = 0;
    let product = this.productService.getProductsById(this.productId).subscribe(data => {
      product = data;
      console.log(this.product);
      this.ReviewService.AverageReview(product).subscribe(data => { this.average = data; console.log(data + "sonal") })
      console.log(average);
    });


    return average;

  };

}



