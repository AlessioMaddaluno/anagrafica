import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CensimentoComponent } from './censimento/censimento.component';
import { CensimentoRoutingModule } from './censimento.routing.module';
import { ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    CensimentoComponent
  ],
  imports: [
    CommonModule,
    CensimentoRoutingModule,
    ReactiveFormsModule
  ]
})
export class CensimentoModule { }
