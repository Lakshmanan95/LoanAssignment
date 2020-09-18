import {Injector, Inject, ReflectiveInjector} from '@angular/core';
import { RequestOptions, Headers, Http } from '@angular/http';
import { SessionStorageService } from 'src/app/com/commondata/service/sessionstorage/service.sessionstorage';
import { BaseComponent } from 'src/app/com/commondata/baseservice/basecomponent';

export class BaseService extends BaseComponent {
  protected _http: Http;
  // protected _APIURL : string;
  protected _httpHeaderOptions: any;

  constructor(injector: Injector ) {
      super(injector);
    this._http = injector.get(Http);

    console.log('Basic service');
    // this._APIURL = this._configService.getProperty("RESTAPIService");
    this._httpHeaderOptions = this.getHeaderOptions();
  }

  getHeaderOptions(){
    var headers = new Headers({
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin' : "*",
    });
    var options = new RequestOptions({
        headers : headers
    });
    return options;
}
}
