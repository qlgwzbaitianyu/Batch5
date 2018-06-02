import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {ProductService} from './product.service'
import {RegisterService} from './register.service';
import {register} from 'ts-node';

import {FormControl, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-test01',
  templateUrl: './test01.component.html',
  styleUrls: ['./test01.component.css']
})
export class Test01Component implements OnInit {

  constructor(private route: ActivatedRoute,
              private productservice: ProductService,
              private register: RegisterService,
              private router: Router) { }

  ngOnInit() {
    const param = this.route.snapshot.params['id'];
    if (param) {
      const id = +param;
      //this.getProduct(id);
    }

  }


  onSubmit(form: NgForm) {
    this.register.signin(form.value['email'], form.value['password']).subscribe(
      data => {
        if (localStorage.getItem('user') == null) {
          this.router.navigate(['']);
        } else {
          this.router.navigate(['']);
        }
      },
      err => {
        console.log(err);
      }
    );
  }


    getProduct(id: number) {
      this.productservice.getProduct(id).subscribe(
        (response) => console.log(response),
        (error) => console.log("error: ", error)
      );
    }


  }
