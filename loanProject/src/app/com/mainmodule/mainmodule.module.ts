import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import {FormsModule, ReactiveFormsModule}  from '@angular/forms';
import { HttpModule } from '@angular/http';
import { SessionStorageService } from 'src/app/com/commondata/service/sessionstorage/service.sessionstorage';
import { AddcustomerComponent } from './addcustomer/addcustomer.component';
import { CreateloanComponent } from './createloan/createloan.component';
import { DisplayLoansComponent } from './display-loans/display-loans.component';



@NgModule({
  declarations: [AddcustomerComponent, CreateloanComponent, DisplayLoansComponent],
  exports: [   
    AddcustomerComponent, CreateloanComponent, DisplayLoansComponent
  ],

  imports: [
    CommonModule,
    RouterModule,FormsModule, ReactiveFormsModule,
    HttpModule
  ],
  providers:[SessionStorageService]
})
export class MainModuleModule { }
