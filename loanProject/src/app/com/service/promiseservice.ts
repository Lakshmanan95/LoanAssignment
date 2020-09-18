import { Injectable, Injector } from "@angular/core";
import { BaseService } from 'src/app/com/commondata/baseservice/baseservice';
import { SessionStorageService } from 'src/app/com/commondata/service/sessionstorage/service.sessionstorage';

@Injectable()   
export class PromiseService extends BaseService {


constructor(injector: Injector, private _sessionStorage: SessionStorageService){
    super(injector);
}

postService(request : any, url){
    return this._http.post(url, request, this._httpHeaderOptions)
        .toPromise()
        .then(res => res.json());
}

getService(url){    
    
    return this._http.get(url, this._httpHeaderOptions)
    .toPromise()
    .then(res => res.json());
}


}