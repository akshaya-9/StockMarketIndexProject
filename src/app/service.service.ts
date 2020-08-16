import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ServiceService {
  name : any;
  constructor(private httpClient: HttpClient) { }
  registerCust(customer : any) : any { 
    return this.httpClient.post('StockMarketIndex/webapi/myresource/registerUser' , customer);
  }
  loginCust(email : any ,password:any ) : any { 
    return this.httpClient.get('StockMarketIndex/webapi/myresource/loginUser/' + email + '/'+ password).toPromise();
  }
  NSE(){
    return this.httpClient.get('StockMarketIndex/webapi/myresource/nse');
  }


}
