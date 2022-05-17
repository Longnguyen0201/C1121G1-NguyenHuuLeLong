import {Component, OnInit} from '@angular/core';

import {Router} from '@angular/router';
import {Product} from '../../model/product';
import {ProductService} from '../../service/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];

  constructor(private productService: ProductService,
              private router: Router) {
    this.getAll();
  }

  ngOnInit() {

  }

  getAll() {
    this.productService.getAll().subscribe(data => {
      this.products = data;
    }, err => {
      console.log(err);
    });
  }

  onDelete(productId: number) {
    console.log(productId);
    if ( confirm('Are you sure to delete this record ?')){
      this.productService.deleteProduct(productId);
      this.productService.deleteProduct(productId).subscribe(() => {
        this.getAll();
        alert('DELETE SUCCESS !');
      }, err => {
        console.log(err);
      });
    }
  }

}

