import { Component } from '@angular/core';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  constructor(private router:Router){

  }
  isLoggedIn:any=sessionStorage.getItem('isLoggedIn');
  name:any=sessionStorage.getItem('name');

  registerPage(){
    console.log("register")
    this.router.navigate(['/register']);

  }
  loginPage(){
    this.router.navigate(['/login']);
  }

  logout(){
    sessionStorage.clear();
    this.router.navigate(['']);
  }

}
