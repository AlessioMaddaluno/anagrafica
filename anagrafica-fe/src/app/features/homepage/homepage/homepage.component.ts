import { Component, OnInit } from '@angular/core';
import { Validators, FormBuilder, AbstractControl } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/core/services/auth.service';

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
        'username': this.inputAccessoUsername.value,
        'password': this.inputAccessoPassword.value
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
        'username': this.inputRegistrazioneUsername.value,
        'password': this.inputRegistrazionePassword.value
      }

      this.authService.register(dto).subscribe(() => {
        this.router.navigate(['ricerca']);
      }, (err) => {
        this.registerErrors = [err.error.message]
        this.accediForm.reset();
      })
    }
  }

  get inputRegistrazioneUsername() :AbstractControl {
    return this.registratiForm.get('username')!
  }

  get inputRegistrazionePassword() :AbstractControl {
    return this.registratiForm.get('password')!
  }

  get inputAccessoUsername() :AbstractControl {
    return this.accediForm.get('username')!
  }

  get inputAccessoPassword() :AbstractControl {
    return this.accediForm.get('password')!
  }


}
