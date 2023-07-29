import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WelcomeDataService } from '../service/data/welcome-data.service';
//import { AppComponent} from '../app.component';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})

export class WelcomeComponent implements OnInit{

  message = 'Some Welcome Message'
  welcomeMessageFromService!: string;
  errorMessageFromService!: string;
  name = ''

  //ActivatedRoute

  constructor(private route:ActivatedRoute,private service:WelcomeDataService){

  }

  ngOnInit() {
    console.log(this.message)
    //console.log(this.route.snapshot.params['name'])
    this.name = this.route.snapshot.params['name']//this is how we are getting the name from the URL
  }

  getWelcomeMessage(){
    console.log(this.service.executeHelloWorldBeanService());
    this.service.executeHelloWorldBeanService().subscribe(
      response => this.handleSuccessfulResponse(response),
      error => this.handleErrorResponse(error)
    );

    console.log('last line of getWelcomeMsg')
    //console.log("get welcome message");
  }

  getWelcomeMessageWithParameter(){
    this.service.executeHelloWorldBeanServiceWithPathVariable(this.name).subscribe(
      response => this.handleSuccessfulResponse(response),
      error => this.handleErrorResponse(error)
    );
  }
  

  handleSuccessfulResponse(response: any){
    this.welcomeMessageFromService = response.message
    //console.log(response);
    //console.log(response.message);
  }

  handleErrorResponse(error : any){
    //console.log(error);
    //console.log(error.error)
    //console.log(error.error.message);
    this.errorMessageFromService = error.error.message;
    
  }


 

}
