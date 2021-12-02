import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RicercaComponent } from './ricerca/ricerca.component';
import { RicercaRoutingModule } from './ricerca.routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';
import { ModalConfermaComponent } from './modal-conferma/modal-conferma.component';



@NgModule({
  declarations: [
    RicercaComponent,
    ModalConfermaComponent
  ],
  imports: [
    CommonModule,
    RicercaRoutingModule,
    ReactiveFormsModule,
    SharedModule
  ]
})
export class RicercaModule { }
