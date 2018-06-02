import { Component, OnInit } from '@angular/core';
import {LoginService} from '../account/login.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  private loginstatus: boolean = false;
  constructor(private authservice: LoginService) { }

  ngOnInit() {
    if (localStorage.getItem('user')) {
        this.loginstatus = true;
    }
  }

  isLogin() {
    return this.authservice.isAuthenticated();
  }


}
