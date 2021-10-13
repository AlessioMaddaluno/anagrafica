import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SpinnerService {

  private subject = new BehaviorSubject<boolean>(false)

  constructor() { }

  showSpinner(){
    this.subject.next(true);
  }

  hideSpinner(){
    this.subject.next(false);
  }

  onChange(){
    return this.subject.asObservable();
  }


}
