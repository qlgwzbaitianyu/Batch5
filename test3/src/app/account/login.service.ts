import { Injectable } from '@angular/core';
import * as firebase from 'firebase';
import {Observable} from 'rxjs';
import { from } from 'rxjs';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  loginObservable
  token: string;

  constructor(private  router: Router) {
  }


  // use from to convert to observable
  signin(username, password) {
    this.loginObservable = from(firebase.auth().signInWithEmailAndPassword(username, password)
      .then((res) => {
      console.log(res);
      firebase.auth().currentUser.getIdToken()
        .then(
        (token: string) => {
          this.token = token;
          localStorage.setItem('user', token);
          localStorage.setItem('useremail',username);
        }
      );
    })
      .catch((error) => {
      console.log(error);
    }));
    //console.log(this.loginObservable);
    return this.loginObservable;
  }

  isAuthenticated() {
    if(localStorage.getItem('user')){
      return true;
    }
    else {
      return false;
    }
  }

}
