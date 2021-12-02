import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-modal-conferma',
  templateUrl: './modal-conferma.component.html',
  styleUrls: ['./modal-conferma.component.css']
})
export class ModalConfermaComponent implements OnInit {

  constructor(
    public dialogRef: MatDialogRef<ModalConfermaComponent>) { }

  ngOnInit(): void {
  }

}
