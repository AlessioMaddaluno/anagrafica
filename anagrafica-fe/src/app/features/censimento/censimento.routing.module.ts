import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { CensimentoComponent } from "./censimento/censimento.component";


const routes: Routes = [
  {
    path: "",
    component: CensimentoComponent
  }
]

@NgModule({
  declarations:[],
  imports: [RouterModule.forChild(routes)]
})
export class CensimentoRoutingModule{}
