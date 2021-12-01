import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RicercaComponent } from './ricerca/ricerca.component';
import { RicercaRoutingModule } from './ricerca.routing.module';
import { ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    RicercaComponent
  ],
  imports: [
    CommonModule,
    RicercaRoutingModule,
    ReactiveFormsModule
  ]
})
export class RicercaModule { }
