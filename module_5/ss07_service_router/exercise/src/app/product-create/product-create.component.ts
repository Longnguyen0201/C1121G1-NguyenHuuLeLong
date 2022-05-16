import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductService} from '../service/product.service';
import {CategoryService} from '../service/category.service';
import {Category} from '../model/category';
import {Product} from '../model/product';
import {Router} from '@angular/router';


@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  categorys: Category[] = [];
  product: Product;
  productForm: FormGroup = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    price: new FormControl(),
    category: new FormControl(),
  });

  constructor(private productService: ProductService,
              private categoryService: CategoryService,
              private route: Router) {
    this.categoryService.findAllCategory().subscribe(data => {
      this.categorys = data;
      this.productForm.get('category').setValue(this.categorys[0]);
    }, error => {
      console.log(error);
    });
  }

  ngOnInit() {
  }

  submit() {
    this.product = this.productForm.value;
    this.productService.saveProduct(this.product).subscribe(() => {
      this.productForm.reset();
      this.route.navigateByUrl('/productList');
      alert('Create success');
    }, error => {
      console.log(error);
    });
  }
}

