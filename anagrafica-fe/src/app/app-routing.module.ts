import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './core/utility/auth.guard';
import { CensimentoModule } from './features/censimento/censimento.module';
import { HomepageModule } from './features/homepage/homepage.module';
import { ProfiloModule } from './features/profilo/profilo.module';
import { RicercaModule } from './features/ricerca/ricerca.module';

const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./features/ricerca/ricerca.module').then( m => RicercaModule),
    canActivate:[AuthGuard]
  },
  {
    path: 'login',
    loadChildren: () => import('./features/homepage/homepage.module').then( m => HomepageModule)
  },
  {
    path: 'profilo',
    loadChildren: () => import('./features/profilo/profilo.module').then(m => ProfiloModule),
    canActivate:[AuthGuard]
  },
  {
    path: 'ricerca',
    loadChildren: () => import('./features/ricerca/ricerca.module').then( m => RicercaModule),
    canActivate:[AuthGuard]
  },
  {
    path: 'censimento',
    loadChildren: () => import('./features/censimento/censimento.module').then( m => CensimentoModule),
    canActivate:[AuthGuard]
  }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
