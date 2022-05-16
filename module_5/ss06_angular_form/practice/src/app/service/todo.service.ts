import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Todo} from '../todo';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any>{
    return this.http.get<any>(`http://localhost:3000/todo`);
  }

  create(todo: Todo): Observable <Todo>{
    return this.http.post( `http://localhost:3000/todo`, todo);
  }

  findById(id: number): Observable<Todo> {
    return this.http.get(`http://localhost:3000/todo/${id}`);
  }
  delete(id: number): Observable<Todo> {
    return this.http.delete(`http://localhost:3000/todo/${id}`);
  }
}
