import {Component, ElementRef, OnInit} from '@angular/core';
import {LoginService} from './login.service';
import {FormControl, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {ActivatedRoute} from '@angular/router';
import {NgForm} from '@angular/forms';


@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {
  form: FormGroup = new FormGroup({
    email: new FormControl(''),
    password: new FormControl(''),
  });
  returnUrl: string;
  constructor(private logservice: LoginService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    console.log(this.returnUrl);
  }


  onSubmit(form: NgForm) {
    this.logservice.signin(form.value['email'], form.value['password']).subscribe(
      data => {
        if (localStorage.getItem('user') == null) {
          this.router.navigate(['account']);
        } else {
          this.router.navigate(['search']);
        }
      },
      err => {
        console.log(err);
      }
    );
  }

  goReg() {
    this.router.navigate(['test01']);
  }



}
