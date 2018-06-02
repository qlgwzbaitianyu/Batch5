import { Injectable } from '@angular/core';
import * as firebase from 'firebase';
import {Observable} from 'rxjs';
import { from } from 'rxjs';
import {Router} from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  loginObservable
  token: string;
  constructor() { }

  signin(username, password) {
    console.log(username);
    console.log(password);
    this.loginObservable = from(firebase.auth().createUserWithEmailAndPassword(username, password).then((res) => {
      console.log(res);
      firebase.auth().currentUser.getIdToken().then(
        (token: string) => {
          this.token = token;
          localStorage.setItem('user', token);
        }
      );
    }).catch((error) => {
      console.log(error);
    }));
    return this.loginObservable;
  }

}

