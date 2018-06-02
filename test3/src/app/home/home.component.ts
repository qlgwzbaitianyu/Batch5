import { Component, OnInit } from '@angular/core';
import {ProductService} from '../test01/product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private httpservice: ProductService) { }

  ngOnInit() {
  }


  httptest() {
    this.httpservice.getProduct(5)
      .subscribe((data) => {
        console.log(data);
        console.log(data);
        console.log(data);
      });

  }

  logout() {
    localStorage.clear();
  }
}
