import { Component } from '@angular/core';
import {ReflectiveInjector,Injector} from '@angular/core';
import { ConnectionBackend,Http } from '@angular/http';
import { SessionStorageService } from 'src/app/com/commondata/service/sessionstorage/service.sessionstorage';
import { SessionDataService } from 'src/app/com/commondata/service/sessiondata/service.sessiondata';

export class BaseComponent {

    protected _sessionStorageService :SessionStorageService;
    protected _APIURL : string;

    constructor(injector2:Injector) {

        var injector = ReflectiveInjector.resolveAndCreate([
                            SessionStorageService
                            ]);

                            console.log("Base Component")
         // this._configService = injector.get(ConfigService);
           this._sessionStorageService = injector.get(SessionStorageService);
       //   alert(this._sessionStorageService.getObject("configData"));
         //  alert(JSON(.stringthis._sessionStorageService.getObject("configData")));
         // this._APIURL = this._configService.getProperty("RESTAPIService");

        // this._APIURL =  SessionDataService.init().getData("configData").RESTAPIService;

    //     this._APIURL = this._sessionStorageService.getObjectFromLocalStorage("configData").RESTAPIService;
       //  alert(this._APIURL)
     //  alert(sessionStorage.getItem("configData"))
   //    this._APIURL="http://localhost:8080/ebizWAPI";
        console.log("base component loaded");
    }

}

