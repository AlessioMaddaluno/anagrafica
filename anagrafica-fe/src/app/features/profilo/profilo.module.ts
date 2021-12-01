import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { ProfiloComponent } from './profilo/profilo.component';
import { ProfiloRoutingModule } from './profilo.routing.module';



@NgModule({
  declarations: [
    ProfiloComponent
  ],
  imports: [
    CommonModule,
    ProfiloRoutingModule
  ]
})
export class ProfiloModule { }
