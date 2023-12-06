
import { Component } from '@angular/core';
import { ReviewsService } from '../../services/reviews.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-reviews',
  templateUrl: './reviews.component.html',
  styleUrls: ['./reviews.component.css']
})
export class ReviewsComponent {
  results:any=[]
  
  result:any;
  resultLength:number=0;
  constructor(private reviewService: ReviewsService,private router:Router){
    if (sessionStorage.getItem('isLoggedIn') == 'true') {
      if (sessionStorage.getItem('admin') == 'true') {
        // this.router.navigate(['/admin']);
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
    this.reviewService.getReviews().subscribe(data=>{
    
    this.results=data;
    this.results=this.results.filter((result:any)=>!result.approve);
    this.resultLength=this.results.length;
    console.log(this.results);
  });
    
    
  }
  approve(reviewCode:any){
    this.reviewService.approveReview(reviewCode).subscribe((data) => {
      
    },
    (error) => {
      alert(error.error.text);
      this.router.navigate(['/admin/reviews']);
    });
    this.results=this.results.filter((result:any)=>reviewCode!=result.reviewCode);
    this.resultLength=this.results.length;
  }

  delete(reviewCode:any){
    this.reviewService.deleteReview(reviewCode).subscribe((data) => {
      // Handle data
    },
    (error) => {
      
      alert(error.error.text);
      this.router.navigate(['/admin/reviews']);
    });
    this.results=this.results.filter((result:any)=>reviewCode!=result.reviewCode);
    this.resultLength=this.results.length;
  }

  mainPage(){
    this.router.navigate(['/admin']);
  }


}
