import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FarmComponent } from './farm/farm.component';
import { ChickenComponent } from './chicken/chicken.component';
import { EggComponent } from './egg/egg.component'

const routes: Routes = [
  {path:'', redirectTo: '/farms', pathMatch: 'full'},
  {path: 'farms', component: FarmComponent},
  {path: 'eggs', component: ChickenComponent},
  {path: 'chickens', component: EggComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
