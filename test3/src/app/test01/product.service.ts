import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {catchError, tap, map} from 'rxjs/internal/operators';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  loggedIn = false;
  id;

  constructor(private http: HttpClient) { }

  getProduct(id: number) {
    return this.http.get('https://jsonplaceholder.typicode.com/posts', {responseType: 'json'} )
      .pipe(
         //map(data => data['productName']),
        map(data => data[1]
          ),
        map(data => data['id']),
        tap(data => {
          this.id = data;
          console.log(this.id);
        })
    );
  }


  // guard function
  isAuth() {
    const promise = new Promise(
      (resolve, reject) => {
        setTimeout(() => {
          resolve(this.loggedIn);
        }, 800);
      }
        );
    return promise;
  }

  login() {
    this.loggedIn = true;
  }

  logout() {
    this.loggedIn = false;
  }

}
