import { Router } from '@angular/router';
import { Component } from '@angular/core';

@Component({
  selector: 'app-mid-page',
  templateUrl: './mid-page.component.html',
  styleUrls: ['./mid-page.component.css']
})
export class MidPageComponent {

  constructor(private router:Router){}

  showProducts(){
    this.router.navigate(['/product']);

  }
  loginAdmin(){
    sessionStorage.clear();
    this.router.navigate(['/admin/login']);
  }

}
