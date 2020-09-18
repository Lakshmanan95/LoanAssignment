import { Component, OnInit, Injector } from '@angular/core';
import { PromiseService } from 'src/app/com/service/promiseservice';
import { Router } from '@angular/router';
import { CONSTANT } from 'src/app/com/service/constant';
import { BaseComponent } from 'src/app/com/commondata/baseservice/basecomponent';

@Component({
  selector: 'app-display-loans',
  templateUrl: './display-loans.component.html',
  styleUrls: ['./display-loans.component.css']
})
export class DisplayLoansComponent   extends BaseComponent implements OnInit {
  userId:any;
  loanDetails:any;
  paymentSchedule:any;
  scheduleId:number;
  constructor(private _router: Router,injector:Injector,
    private promiseService:PromiseService){
      super(injector);
     }

  ngOnInit() {
    this.userId = this._sessionStorageService.getObject("user");
    if(this.userId == null || this.userId == undefined)
      this._router.navigate(['']);
    this.getLoanByUser();
  }

  getLoanByUser(){
    var request = {
      customerId : this.userId
    }
    this.promiseService.postService(request, CONSTANT.GET_LOAN_BY_USER).then(res => this.res_getLoanByUser(res))
  }

  res_getLoanByUser(res){
    if(res.status == "Success"){
      this.loanDetails = res.loanDetails;
    }
  }

  getPaymentSchedule(scheduleId){
    this.scheduleId = scheduleId;
    this.promiseService.getService(CONSTANT.GET_PAYMENT_SCHEDULE+"/"+scheduleId).then(res => this.res_getPaymentSchedule(res) )
  }

  res_getPaymentSchedule(res){
    if(res.status == "Success"){
      this.paymentSchedule = res.paymentSchedule;
    }
  }

  createLoan(){
    this._router.navigate(["addLoan"]);
  }
}
