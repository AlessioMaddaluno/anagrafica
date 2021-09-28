import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-profilo',
  templateUrl: './profilo.component.html',
  styleUrls: ['./profilo.component.css']
})
export class ProfiloComponent implements OnInit {

  userData:any;

  constructor(private authService:AuthService) { }

  ngOnInit(): void {

    this.authService.getMe().subscribe((data) => {
        this.userData = data;
    })
  }

}
