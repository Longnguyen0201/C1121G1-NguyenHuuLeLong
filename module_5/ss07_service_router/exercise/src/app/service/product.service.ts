import {Injectable} from '@angular/core';
import {Product} from '../model/product';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  // products: Product[] = [{
  //   id: 1,
  //   name: 'IPhone 12',
  //   price: 2400000,
  //   description: 'New'
  // }, {
  //   id: 2,
  //   name: 'IPhone 11',
  //   price: 1560000,
  //   description: 'Like new'
  // }, {
  //   id: 3,
  //   name: 'IPhone X',
  //   price: 968000,
  //   description: '97%'
  // }, {
  //   id: 4,
  //   name: 'IPhone 8',
  //   price: 7540000,
  //   description: '98%'
  // }, {
  //   id: 5,
  //   name: 'IPhone 11 Pro',
  //   price: 1895000,
  //   description: 'Like new'
  // }];

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get<any>('http://localhost:3000/product');
  }

  saveProduct(product: Product): Observable<Product> {
    return this.http.post<Product>('http://localhost:3000/product', product);
  }

  findById(id: number): Observable<Product> {
    return this.http.get(`http://localhost:3000/product/${id}`);
  }

  updateProduct(product: Product): Observable<Product> {
    return this.http.put<Product>(`http://localhost:3000/product/${product.id}`, product);
  }

  deleteProduct(id: number): Observable<Product> {
    return this.http.delete<Product>(`http://localhost:3000/product/${id}`);
  }
}
