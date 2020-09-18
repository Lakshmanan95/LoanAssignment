import {Injectable} from '@angular/core';
import { SessionDataService } from 'src/app/com/commondata/service/sessiondata/service.sessiondata';
import { JsonPipe } from '@angular/common';


@Injectable()
export class SessionStorageService {
  data = {};
  isStorage = true;


  isStorageSupported() {
    var testKey = 'test', storage = window.sessionStorage;
    try {
      storage.setItem(testKey, '1');
      storage.removeItem(testKey);
      return true;
    } catch (error) {
      return false;
    }
  }

  constructor() {
    if (this.isStorageSupported()) {
      this.isStorage = true;
    } else {
      this.isStorage = false;
    }

    console.log('Session Storage loaded..private browsing..' + this.isStorage);
  }

  private setItem(key, valueObj) {
    if (this.isStorage) {
      sessionStorage.setItem(key, valueObj);
    } else {
      SessionDataService.init().setData(key, valueObj);
    }

  }

  private getItem(key) {
    if (this.isStorage) {
      return sessionStorage.getItem(key);
    } else {
      return SessionDataService.init().getData(key);
    }
  }

  setObject(key, valueObj) {
    if (this.isStorage) {
      sessionStorage.setItem(key,  JSON.stringify(valueObj));
    } else {
      SessionDataService.init().setData(key, valueObj);
    }
  }

  getObject(key) {
    if (this.isStorage) {
      return JSON.parse(sessionStorage.getItem(key));

    } else {
      return SessionDataService.init().getData(key);
    }
  }

  clear() {
    if (this.isStorage) {
      sessionStorage.clear();
    } else {
        sessionStorage.clear();
    }

  }


}
