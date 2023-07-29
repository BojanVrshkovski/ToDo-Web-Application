import { Component, OnInit } from '@angular/core';
import { TodoDataService } from '../service/data/todo-data.service';
import { Todo, TodoRequest } from '../list-todos/list-todos.component';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  id: number = 0;
  todo!: Todo;
  todoRequest:TodoRequest = new TodoRequest(this.id, '', false, new Date());
  action: 'add' | 'edit' = 'add';

  constructor(
    private todoService: TodoDataService,
    private route: ActivatedRoute,
    private router: Router
  ) {

  }

  ngOnInit() {
    // this.id = this.route.snapshot.params['id'];//this is how we are getting the id from the URL
    // this.todo = new Todo(this.id, '', false, new Date());
    // this.todoRequest = new TodoRequest(this.id, '', false, new Date());

    // if (this.id != -1) {
    //   this.todoService.retrieveTodo('bojan', this.id)
    //     .subscribe(
    //       data => this.todoRequest = data
    //     )
    // }

    this.id = this.route.snapshot.params['id'];
    this.todoRequest = new TodoRequest(this.id, '', false, new Date());

    if (this.id != -1) {
      this.action = 'edit'; // Set action to 'edit' if an id is present
      this.todoService.retrieveTodo('bojan', this.id).subscribe(
        (data) => (this.todoRequest = data)
      );
    }
  }

  saveTodo() {
    // console.log('Todo Request:', this.todoRequest);
    // if (this.id == -1 || this.id == null) { //=== ==
    //   this.todoService.createTodo('bojan', this.todoRequest)
    //     .subscribe(
    //       data => {
    //         console.log(data)
    //         this.router.navigate(['todos'])
    //       },
    //       error => {
    //         console.error('Error occurred:', error);
    //       }
    //     );
    // } else {
    //   this.todoService.updateTodo('bojan', this.id, this.todoRequest)
    //     .subscribe(
    //       data => {
    //         console.log(data)
    //         this.router.navigate(['todos'])
    //       }
    //     )
    // }
    if (this.action === 'add' && this.id ==-1) {
      console.log('Action:', this.action);
      console.log('Todo Request:', this.todoRequest);
      // For new todo, id should be -1
      this.todoService.createTodo('bojan', this.todoRequest).subscribe(
        (data) => {
          console.log(data);
          this.router.navigate(['todos']);
        },
        (error) => {
          console.error('Error occurred:', error);
        }
      );
    } else if (this.action === 'edit') {
      this.todoService
        .updateTodo('bojan', this.id, this.todoRequest)
        .subscribe(
          (data) => {
            console.log(data);
            this.router.navigate(['todos']);
          },
          (error) => {
            console.error('Error occurred:', error);
          }
        );
    }
  }
}
