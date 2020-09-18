import { Subject }    from 'rxjs';


export class SessionDataService
{
    message:String;
    static instance:SessionDataService;
    static isCreating:boolean = false;
    data={};
 
    constructor() {
        if (!SessionDataService.isCreating) {
            throw new ErrorEvent("You can't call new in Singleton instances!");
        }
    }
    static init(){
        return this.getInstance();
    }
    static getInstance() {
        if (SessionDataService.instance == null) {
            SessionDataService.isCreating = true;
            SessionDataService.instance = new SessionDataService();
            SessionDataService.isCreating = false;
        }
 
        return SessionDataService.instance;
    }
    setData(key,value){
        //alert(key)
        this.data[key]=value;
    }
    getData(key){
        return this.data[key];
    }
    setMessage(msg:String) {
        this.message = msg;
        console.log(this.message);
    }
 
    getMessage() {
        return this.message;
        //console.log(message);
    }
    setObject (key, valueObj){
        localStorage.setItem(key,valueObj);
    }
    getObject(key){
        return localStorage.getItem(key);
    }

    private userRefresh = new Subject<string>();
    refresh$ = this.userRefresh.asObservable();

    refresh(totalStr:any){
        this.userRefresh.next(totalStr)
    }
    
    clear(){
        this.data={};
    }
}