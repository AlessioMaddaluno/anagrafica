import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { RicercaComponent } from "./ricerca/ricerca.component";

const routes: Routes = [
  {
    path: "",
    component: RicercaComponent
  }
]

@NgModule({
  declarations:[],
  imports: [RouterModule.forChild(routes)]
})
export class RicercaRoutingModule{}
