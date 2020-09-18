import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddcustomerComponent } from 'src/app/com/mainmodule/addcustomer/addcustomer.component';
import { CreateloanComponent } from 'src/app/com/mainmodule/createloan/createloan.component';
import { AuthGuard } from 'src/app/com/commondata/gaurd/gaurd';
import { DisplayLoansComponent } from 'src/app/com/mainmodule/display-loans/display-loans.component';


const routes: Routes = [
  {path: '', component: AddcustomerComponent},
  {path: 'addLoan', canActivate: [AuthGuard], component: CreateloanComponent},
  {path: 'displayLoan', component:DisplayLoansComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
