import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainModuleModule } from 'src/app/com/mainmodule/mainmodule.module';
import { PromiseService } from 'src/app/com/service/promiseservice';
import { HttpModule } from '@angular/http';
import { AddcustomerComponent } from 'src/app/com/mainmodule/addcustomer/addcustomer.component';
import { HeaderComponent } from './com/commondata/header/header.component';
import { AuthGuard } from 'src/app/com/commondata/gaurd/gaurd';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MainModuleModule,
    HttpModule
  ],
  providers: [PromiseService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
