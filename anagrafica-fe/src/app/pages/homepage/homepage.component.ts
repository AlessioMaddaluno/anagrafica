import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { CustomValidators } from 'src/app/utility/custom.validators';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  loginErrors:any = []
  registerErrors:any = []

  accediForm = this.formBuilder.group({
    username: ['', [Validators.required,Validators.minLength(4),Validators.maxLength(8),Validators.pattern("[a-z][A-Za-z0-9]*")]],
    password: ['', [Validators.required,Validators.minLength(4),Validators.maxLength(15)]]
  })

  registratiForm = this.formBuilder.group({
    username: ['',[Validators.required,Validators.minLength(4),Validators.maxLength(8),Validators.pattern("[a-z][A-Za-z0-9]*")]],
    password: ['',[Validators.required,Validators.minLength(4),Validators.maxLength(15)]],
    rpassword: ['',[Validators.required]]
  });

  constructor(private router:Router, private formBuilder: FormBuilder, private authService: AuthService) { }

  ngOnInit(): void {}

  onLogin(){

    if(this.accediForm.valid){
      const dto = {
        'username': this.accediForm.controls.username.value,
        'password': this.accediForm.controls.password.value
      }

      this.authService.signIn(dto).subscribe(() => {
        this.router.navigate(['ricerca']);
      },(err) => {
         this.loginErrors = [err.error.message]
         this.accediForm.reset();
      })

    }

  }

  onRegister(){
    if(this.registratiForm.valid){
      const dto = {
        'username': this.registratiForm.controls.username.value,
        'password': this.registratiForm.controls.password.value
      }

      this.authService.register(dto).subscribe(() => {
        this.router.navigate(['ricerca']);
      }, (err) => {
        this.registerErrors = [err.error.message]
        this.accediForm.reset();
      })
    }
  }



}
