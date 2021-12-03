import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { NotificationService } from './core/services/notification.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{

  constructor(public router: Router,private notificationService:NotificationService){
    this.notificationService.connect();
  }


}
