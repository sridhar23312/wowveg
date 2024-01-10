import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UplodeComponent } from './uplode/uplode.component';
import { AppComponent } from './app.component';


const routes: Routes = [
  {path:'upload',component:UplodeComponent}
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
