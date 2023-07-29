import { Component, OnInit } from '@angular/core';
import { TodoDataService } from '../service/data/todo-data.service';
import { Router } from '@angular/router';
import { MatDialog  } from '@angular/material/dialog';
import { DeleteConfirmationDialogComponent } from '../delete-confirmation-dialog/delete-confirmation-dialog.component';
import { animate, state, style, transition, trigger } from '@angular/animations'; // Import animations functions



export class Todo{
  constructor(
    public id: number,
    public description: string,
    public done: boolean,
    public targetDate: Date){
    
  }
}

export class TodoRequest{
  constructor(
    public id: number,
    public description: string,
    public done: boolean,
    public targetDate: Date){
    
  }
}

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css'],
  animations: [
    // Define fade-in and fade-out animations with 500ms duration
    trigger('fadeInOutAnimation', [
      state('in', style({ opacity: 1 })),
      transition(':enter', [
        style({ opacity: 0 }),
        animate('500ms ease-in-out'), // Set the duration to 500ms
      ]),
      transition(':leave', [
        animate('500ms ease-in-out', style({ opacity: 0 })), // Set the duration to 500ms
      ]),
    ]),
  ],
})
export class ListTodosComponent implements OnInit{

  
  message:string = '';
  todos: Todo[] = [];
  
    // = [
    //   new Todo(1,'Learn to Dance',true,new Date()),
    //   new Todo(2,'Become an Expert at Angular',false,new Date()),
    //   new Todo(3,'Visit Dubai',false,new Date())
    //   // {id : 1, description : 'Learn to Dance'},
    //   // {id : 2, description : 'Become an Expert at Angular'},
    //   // {id : 3, description : 'Visit Dubai'}
    // ]
    // todo = {
    //   id : 1,
    //   description: 'Learn to Dance'
    // }
    
  // = [
  //   new Todo(1,'Learn to Dance',true,new Date()),
  //   new Todo(2,'Become an Expert at Angular',false,new Date()),
  //   new Todo(3,'Visit Dubai',false,new Date())
  //   // {id : 1, description : 'Learn to Dance'},
  //   // {id : 2, description : 'Become an Expert at Angular'},
  //   // {id : 3, description : 'Visit Dubai'}
  // ]

  // todo = {
  //   id : 1,
  //   description: 'Learn to Dance'
  // }


  constructor(private todoService:TodoDataService,private router:Router,private dialog: MatDialog){

  }

  ngOnInit() {
    this.refreshTodos();
  }


  refreshTodos(){
    this.todoService.retrieveAllTodos('bojan').subscribe(
      response =>{
        this.todos = response;
      }
    )
  }
  

  deleteTodo(id : any){
    const dialogRef = this.dialog.open(DeleteConfirmationDialogComponent, {
      data: { id: id },
    });
  
    dialogRef.afterClosed().subscribe((result: any) => {
      if (result) {
        this.todoService.deleteTodo('bojan', id).subscribe((response) => {
          console.log(response);
          this.message = `Delete of Todo ${id} is successful`;
          this.refreshTodos();
        });
      }
    });
  }

  updateTodo(id : any){
    console.log(`update todo ${id}`)
    this.router.navigate(['todos',id])
  }

  addTodo(){
    this.router.navigate(['todos',-1])
  }

}
