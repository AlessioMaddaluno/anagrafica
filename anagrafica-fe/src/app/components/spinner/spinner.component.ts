import { Component, Input, OnInit } from '@angular/core';
import { SpinnerService } from 'src/app/services/spinner.service';

@Component({
  selector: 'app-spinner',
  templateUrl: './spinner.component.html',
  styleUrls: ['./spinner.component.css']
})
export class SpinnerComponent implements OnInit {

  @Input()
  loading: boolean = false;

  constructor(private spinnerService:SpinnerService) { }

  ngOnInit(): void {
    this.spinnerService.onChange().subscribe((isLoading) => {
      this.loading = isLoading;
      console.log("CAMBIO STATO SPINNER",isLoading)
    })
  }

}
