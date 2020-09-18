import { Component, OnInit, Injector } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { BaseComponent } from 'src/app/com/commondata/baseservice/basecomponent';
import { PromiseService } from 'src/app/com/service/promiseservice';
import { Customer } from 'src/app/com/mainmodule/model/customer';
import { CONSTANT } from 'src/app/com/service/constant';

@Component({
  selector: 'app-addcustomer',
  templateUrl: './addcustomer.component.html',
  styleUrls: ['./addcustomer.component.css']
})
export class AddcustomerComponent extends BaseComponent implements OnInit {

  customer = new Customer();
  customerForm : FormGroup;
  message:string;
  constructor(private _router: Router,private fb: FormBuilder,
    injector: Injector,
    private promiseService:PromiseService) { 
      super(injector);
      this.customerForm = this.fb.group({
        _customerName:['', Validators.required],
        _emailId:['', Validators.required],
        _phoneNumber:['', Validators.required],
        _salary:['', Validators.required]
      }) }

  ngOnInit(): void {
  }

  addcustomer(){
    console.log(this.customer)
    var request = {
      "customerName": this.customer.customerName,
      "emailId":this.customer.emailId,
      "phoneNumber":this.customer.phoneNumber,
      "salary":this.customer.salary
    }
    this.promiseService.postService(request, CONSTANT.CREATE_CUSTOMER).then(res => this.res_addCustomer(res))
  }
  res_addCustomer(res){
    if(res.status == "Success"){
      this._sessionStorageService.setObject("user",res.customer.id);
      this._router.navigate(['/addLoan']);
    }
    else
      this.message = "Customer Added Failed";
  }
 
}
