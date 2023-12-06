import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AdduserService } from 'src/app/shared/services/adduser.service';

@Component({
  selector: 'app-login-admin',
  templateUrl: './login-admin.component.html',
  styleUrls: ['./login-admin.component.css']
})
export class LoginAdminComponent {

  result: any = [];
  LoginCredential = new FormGroup({
    email: new FormControl(''),
    password: new FormControl('')

  })
  constructor(private adduser: AdduserService, private router: Router) { }
  validateEmail(email: any): boolean {
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    return emailPattern.test(email);
  }
  
  login() {
    let valid: boolean = this.validateEmail(this.LoginCredential.value.email);
    if (valid) {
      this.adduser.login(this.LoginCredential.value).subscribe(data => {
        this.result = data; if (this.result.password != null) {


          if (this.result.admin) {
            sessionStorage.setItem("isLoggedIn", 'true');
            sessionStorage.setItem('name', this.result.firstName + this.result.lastName);
            sessionStorage.setItem('admin', this.result.admin);
            this.router.navigate(['/admin']);
          }
          else {
            alert('You can not login as a Admin');
            this.LoginCredential.reset();
          }



        } else {
          alert("Login Credentials are wrong");
          this.LoginCredential.reset();
        }
      })
    }
    else{
      alert('Invalid Email');
    }

    }

     


  }

