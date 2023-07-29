import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HardcodedAuthenticationService } from '../service/hardcoded-authentication.service';
import { BasicAuthenticationService } from '../service/basic-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  username = 'bojan'
  password = ''
  errorMessage = 'Invalid Credentials'
  invalidLogin = false

  //Router
  //Angular.giveMeRouter
  //Dependency Injection

  constructor(private router: Router,
    public hardcodedAuthenticationService: HardcodedAuthenticationService,
    public basicAuthenticationService:BasicAuthenticationService){

  }

  ngOnInit() {
    
  }

  handleLogin(){
    //console.log('Welcome ' + this.username);
    //console.log('Password ' + this.password);
    //if(this.username === 'bojan' && this.password === '12345'){
    if(this.hardcodedAuthenticationService.authenticate(this.username,this.password)){
      //Redirect to Welcome Page
      this.router.navigate(['welcome',this.username])
      this.invalidLogin = false
    }else{
      this.invalidLogin = true
    }
    
  }

  handleJWTAuthLogin(){
    //console.log('Welcome ' + this.username);
    //console.log('Password ' + this.password);
    //if(this.username === 'bojan' && this.password === '12345'){
    this.basicAuthenticationService.executeJWTAuthenticationService(this.username,this.password)
    .subscribe(
      data => {
        console.log(data)
        //Redirect to Welcome Page
        this.router.navigate(['welcome',this.username])
        this.invalidLogin = false
      },
      error =>{
        console.log(error)
        this.invalidLogin = true
      }
    )
    
  }

  handleBasicAuthLogin(){
    //console.log('Welcome ' + this.username);
    //console.log('Password ' + this.password);
    //if(this.username === 'bojan' && this.password === '12345'){
    this.basicAuthenticationService.executeAuthenticationService(this.username,this.password)
    .subscribe(
      data => {
        console.log(data)
        //Redirect to Welcome Page
        this.router.navigate(['welcome',this.username])
        this.invalidLogin = false
      },
      error =>{
        console.log(error)
        this.invalidLogin = true
      }
    )
    
  }
}
