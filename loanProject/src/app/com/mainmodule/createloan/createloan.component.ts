import { Component, OnInit, Injector } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BaseComponent } from 'src/app/com/commondata/baseservice/basecomponent';
import { PromiseService } from 'src/app/com/service/promiseservice';
import { LoanDetails } from 'src/app/com/mainmodule/model/loanDetails';
import { CONSTANT } from 'src/app/com/service/constant';

@Component({
  selector: 'app-createloan',
  templateUrl: './createloan.component.html',
  styleUrls: ['./createloan.component.css']
})
export class CreateloanComponent extends BaseComponent implements OnInit {
  user:any;
  loanDetails = new LoanDetails();
  loanForm : FormGroup;
  message:string;
  constructor(private _router: Router,private fb: FormBuilder,
    injector: Injector,
    private promiseService:PromiseService) { 
      super(injector);
      this.loanForm = this.fb.group({
        _loanType:['', Validators.required],
        _loanAmount:['', Validators.required],
        _tradeDate:['', Validators.required],
        _loanStartDate:['', Validators.required],
        _maturityDate:['', Validators.required],
        _paymentFrequency:['', Validators.required],
        _interestRate: ['',Validators.required]
      }) }


  ngOnInit(): void {
    this.user = this._sessionStorageService.getObject("user");
    if(this.user == null || this.user == undefined)
      this._router.navigate(['']);
  }

  createLoan(){
    var request = {
      "customerId":this.user,
      "loanType":this.loanDetails.loanType,
      "loanAmount": this.loanDetails.loanAmount,
      "tradeDate": this.loanDetails.tradeDate,
      "loanStartDate": this.loanDetails.loanStartDate,
      "maturityDate": this.loanDetails.maturityDate,
      "paymentFrequency": this.loanDetails.paymentFrequency,
      "interestRate": this.loanDetails.interestRate
    }
    this.promiseService.postService(request, CONSTANT.CREATE_LOAN).then(res => this.res_createLoan(res))
  }

  res_createLoan(res){
    if(res.status == "Success")
      this._router.navigate(["displayLoan"]);
    
  }

  
}
