import { Injectable } from '@angular/core';
import { CanActivate, CanActivateChild,Router} from '@angular/router';
import { SessionStorageService } from 'src/app/com/commondata/service/sessionstorage/service.sessionstorage';

@Injectable()
export class AuthGuard implements CanActivate, CanActivateChild {

constructor(
private _sessionStorageService : SessionStorageService,
private _router: Router,){
      
    }

  canActivate() {
    console.log('checking child route access');
    var userId = this._sessionStorageService.getObject("userId")
     console.log(userId);
    if(userId != 0)
            return true;        
    else{
        this._router.navigate(['']);
        return false;
    }
    
  }

  canActivateChild() {
    console.log('checking child route access');
      var userId = this._sessionStorageService.getObject("userId")
      if(userId != null)
        return true;        
      else
      {
        this._router.navigate(['']);
        return false;
      }
        
  }

}