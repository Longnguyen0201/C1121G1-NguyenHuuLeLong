import {Component, OnInit} from '@angular/core';
import {Todo} from '../todo';
import {FormControl} from '@angular/forms';
import {TodoService} from '../service/todo.service';


// tslint:disable-next-line:variable-name
let _id = 1;

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  todos: Todo[] = [];
  content = new FormControl();

  constructor(private todoService: TodoService,) {
    this.getAllTodo();
  }

  ngOnInit(): void {
  }

  getAllTodo(){
    this.todoService.getAll().subscribe(data => {
      this.todos = data ;
    }, error => {
      console.log(error);
    });
  }

  toggleTodo(i: number) {
    this.todos[i].complete = !this.todos[i].complete;
  }

  change() {
    const value = this.content.value;
    if (value) {
      const todo: Todo = {
        content: value,
        complete: false
      };
      console.log(todo);
      this.todoService.create(todo).subscribe(() => {
       alert('create success');
       this.getAllTodo();
     }, error => {
        console.log(error);
      });
    }
  }

  deleteTodo(id: number) {
    this.todoService.delete(id).subscribe(() => {
      console.log('success!');
      this.getAllTodo();
    }, err => {
      console.log(err);
    });
  }
}
