import { AdduserService } from './../../services/adduser.service';
import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  result: any = [];
  ngOnInit(){
   if(sessionStorage.getItem('isLoggedIn')=='true'&& !sessionStorage.getItem('admin')){
      this.router.navigate(['/product'])
    }
    else if(sessionStorage.getItem('isLoggedIn')=='true'&& sessionStorage.getItem('admin')){
      this.router.navigate(['/admin'])
    }
  }
  constructor(private adduser: AdduserService, private router: Router) { }

  LoginCredential = new FormGroup({
    email: new FormControl(''),
    password: new FormControl('')

  })
  

  login() {

    let valid: boolean = this.validateEmail(this.LoginCredential.value.email);
    if (valid) {
      this.adduser.login(this.LoginCredential.value).subscribe(data => {
        this.result = data; if (this.result.password != null) {

          sessionStorage.setItem("isLoggedIn", 'true');
          sessionStorage.setItem('name', this.result.firstName + " " + this.result.lastName);
          sessionStorage.setItem('admin', this.result.admin);
          if (!this.result.admin) {
            this.router.navigate(['/product']);
          }
          else {
            alert("Login Credentials are wrong");
            this.LoginCredential.reset();
          }



        }


      })
    }
    else{
      alert('Invalid Email')
    }
  }
  

  validateEmail(email: any): boolean {
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    return emailPattern.test(email);
  }
}


