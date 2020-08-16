import { Component, OnInit, AfterViewInit } from '@angular/core';
import { Router } from '@angular/router';
import{ServiceService} from '../service.service';
@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {
 loggedUser : {userId : "" , userName : "" , email : "" , password : "" };
  user: any;
  userr : any;
  address : any;
  containment : any;
  todayStock:any;
  constructor(private router: Router , private service : ServiceService) {
    this.user = { email: '', password: '' };
    this.todayStock = {date :'',adjClose :'',close:'',high:'',open:'',volume:''};
    this.userr = {userId : "1" , userName : "" , email : "" , password : ""};

  }

  ngOnInit(): void {
    this.service.NSE().subscribe((result:any)=>{
      this.todayStock = result;
      console.log(result)});  }
  

  redirect(): void {
    this.router.navigate(['register']);
  }
  
 async loginSubmit(loginForm: any) {
    
  await  this.service.loginCust(this.user.email,this.user.password).then((res: any) => 
    {this.service.name = res.userName;
      if(res != null) {console.log(res),this.loggedUser = res;
        alert('Login Successful')
      
      }
    else{
      alert("wrong credentials");
    }});
   
    console.log(this.service.name);
   // this.service.getContainment(this.address).subscribe((data:any) =>{ this.containment=data; console.log(this.containment); if(data.hasContainmentZone == false){ this.router.navigate(['home']);}
 // else{
  //  this.router.navigate(['covid']);
  //}});
}
regSubmit():void{
  this.service.registerCust(this.userr).subscribe((result:any)=>{console.log(result)});
  console.log(this.userr);
  this.userr =  {userId : "" , userName : "" , email : "" , password : ""};
}

login(){
  if(this.service.name === null)
     return true ;
  else
     return false;
}
}