import { Injectable } from "@angular/core";
import { BehaviorSubject, Subject } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class DarkModeService {

  darkModeEnabled:boolean
  darkModeToggle: BehaviorSubject<boolean>;

  constructor(){
    this.darkModeEnabled = (localStorage.getItem('DARK_MODE') === '1')
    this.darkModeToggle = new BehaviorSubject(this.darkModeEnabled)
  }

  toggleDarkMode(){

    this.darkModeEnabled = !this.darkModeEnabled

    if(this.darkModeEnabled)
      localStorage.setItem('DARK_MODE','1')
    else
      localStorage.setItem('DARK_MODE','0')

    this.darkModeToggle.next(this.darkModeEnabled)
  }




}
