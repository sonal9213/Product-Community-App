import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent {
  constructor(private router:Router){

  }
  logout(){
     sessionStorage.removeItem('name');
     sessionStorage.removeItem('isLoggedIn');
     sessionStorage.removeItem('admin');
     location.reload();
     this.router.navigate(['/login']);
  }

}
