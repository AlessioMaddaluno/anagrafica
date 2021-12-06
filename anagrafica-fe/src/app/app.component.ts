import { Component, HostBinding, OnInit } from '@angular/core';
import {MatSnackBar, MatSnackBarConfig} from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { DarkModeService } from './core/services/darkmode.service';
import { NotificationService } from './core/services/notification.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  darkMode: boolean = false;
  @HostBinding('class')
  get themeMode(){
    return this.darkMode ? 'dark-mode' : 'light-mode';
  }

  onToggle(){
    this.darkMode = !this.darkMode;
    console.log(this.darkMode)
  }

  matSnackConfig: MatSnackBarConfig = {
    duration: 5000
  }

  constructor(
    public router: Router,
    private notificationService:NotificationService,
    private snackBar: MatSnackBar,
    private darkModeService:DarkModeService
    ){

  }
  ngOnInit(): void {

    this.notificationService.connect().subscribe((notification) => {
      this.snackBar.open(notification.notificationMessage,'Chiudi',this.matSnackConfig);
    })

    this.darkModeService.darkModeToggle.subscribe((darkMode) => {
      this.darkMode = darkMode;
    })

  }



}
