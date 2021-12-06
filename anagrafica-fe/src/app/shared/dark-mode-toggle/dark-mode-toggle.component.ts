import { Component, HostBinding, OnInit } from '@angular/core';
import { DarkModeService } from 'src/app/core/services/darkmode.service';

@Component({
  selector: 'app-dark-mode-toggle',
  templateUrl: './dark-mode-toggle.component.html',
  styleUrls: ['./dark-mode-toggle.component.css']
})
export class DarkModeToggleComponent {

  darkMode: boolean = false;

  constructor(private darkModeService:DarkModeService) { }

  onToggle(){
    this.darkMode = !this.darkMode;
    this.darkModeService.toggleDarkMode()
  }

}
