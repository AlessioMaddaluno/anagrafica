import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CensimentoComponent } from './censimento/censimento.component';
import { CensimentoRoutingModule } from './censimento.routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { SharedModule } from 'src/app/shared/shared.module';
import { MatButtonModule } from '@angular/material/button';



@NgModule({
  declarations: [
    CensimentoComponent
  ],
  imports: [
    CommonModule,
    CensimentoRoutingModule,
    ReactiveFormsModule,
    SharedModule
  ]
})
export class CensimentoModule { }
