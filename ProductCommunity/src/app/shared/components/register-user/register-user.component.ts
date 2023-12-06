import { ActivatedRoute, Router } from '@angular/router';
// import { AdduserService } from './../../services/adduser.service';
import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { AdduserService } from '../../services/adduser.service';

@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})
export class RegisterUserComponent {

  

  userDetail= new FormGroup({
    email: new FormControl(''),
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    password:new FormControl(''),
    cpassword:new FormControl('')
    
  })
  constructor(private AdduserService:AdduserService,private router:Router,private route: ActivatedRoute){}
  

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      const data = params.get('data');
      console.log(data); // or process the data as per your requirement
    });
  }
  
  addUser(){
    let valid: boolean = this.validateEmail(this.userDetail.value.email);

    if(valid){
    if(this.userDetail.value.password==this.userDetail.value.cpassword){{
      this.AdduserService.addUser(this.userDetail.value).subscribe(data => { console.log(data);this.router.navigate(['/login'])}) };
  }
    else{
      alert("Password is not Matching");
      this.userDetail.reset();
    }
    
  }
  else{
    alert('Invalid Email');
  }
  }
  validateEmail(email: any): boolean {
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    return emailPattern.test(email);
  }

}
