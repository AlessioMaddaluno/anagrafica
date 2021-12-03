import { Component, OnInit } from '@angular/core';
import {MatSnackBar, MatSnackBarConfig} from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { NotificationService } from './core/services/notification.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  matSnackConfig: MatSnackBarConfig = {
    duration: 5000
  }

  constructor(
    public router: Router,
    private notificationService:NotificationService,
    private snackBar: MatSnackBar
    ){

  }
  ngOnInit(): void {

    this.notificationService.connect().subscribe((notification) => {
      this.snackBar.open(notification.notificationMessage,'Chiudi',this.matSnackConfig);
    })

  }

}
