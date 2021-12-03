import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dark-mode-toggle',
  templateUrl: './dark-mode-toggle.component.html',
  styleUrls: ['./dark-mode-toggle.component.css']
})
export class DarkModeToggleComponent implements OnInit {

  darkMode: boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  onToggle(){
    this.darkMode = !this.darkMode;
    console.log(this.darkMode)
  }

}
