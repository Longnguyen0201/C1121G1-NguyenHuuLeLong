import {Component, OnInit} from '@angular/core';

import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductService} from '../../service/product.service';
import {CategoryService} from '../../service/category.service';
import {Category} from '../../model/category';

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  categorys: Category[] = [];
  id: number;
  productForm = new FormGroup({
    id: new FormControl(''),
    name: new FormControl(''),
    price: new FormControl(''),
    category: new FormControl(),
  });

  constructor(private productService: ProductService,
              private categoryService: CategoryService,
              private activatedRoute: ActivatedRoute,
              private route: Router) {
    this.categoryService.findAllCategory().subscribe(data => {
      this.categorys = data;
      this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
        this.id = +paramMap.get('id');
        this.productService.findById(this.id).subscribe(data2 => {
          this.productForm.get('id').setValue(data2.id);
          this.productForm.get('name').setValue(data2.name);
          this.productForm.get('price').setValue(data2.price);
          this.productForm.get('category').setValue(data2.category);
        });
      }, error => {
        console.log(error);
      });
    }, error => {
      console.log(error);
    });
  }

  ngOnInit() {
  }
  compareFn(t1: Category, t2: Category): boolean {
    return t1 && t2 ? t1.id === t2.id : t1 === t2;
  }

  // getProduct(id: number) {
  //   return this.productService.findById(id);
  // }

  updateProduct() {
    const product = this.productForm.value;
    this.productService.updateProduct(product).subscribe(() => {
      this.route.navigateByUrl('productList');
      alert('Update success');
    }, error => {
      console.log(error);
    });
  }
}
