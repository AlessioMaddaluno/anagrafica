import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CensimentoComponent } from './pages/censimento/censimento.component';
import { HomepageComponent } from './pages/homepage/homepage.component';
import { ProfiloComponent } from './pages/profilo/profilo.component';
import { RicercaComponent } from './pages/ricerca/ricerca.component';
import { AuthGuard } from './utility/auth.guard';

const routes: Routes = [
  { path: "", component:RicercaComponent, canActivate:[AuthGuard] },
  { path: "login", component: HomepageComponent},
  { path: "profilo", component: ProfiloComponent, canActivate:[AuthGuard]},
  { path: "censimento", component: CensimentoComponent, canActivate:[AuthGuard]},
  { path: "ricerca", component: RicercaComponent, canActivate:[AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
