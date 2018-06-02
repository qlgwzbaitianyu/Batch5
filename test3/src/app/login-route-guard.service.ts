import { Injectable } from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, Router} from '@angular/router';
import {Observable} from 'rxjs';
import {ProductService} from './test01/product.service';

@Injectable({
  providedIn: 'root'
})
export class LoginRouteGuardService implements CanActivate {
  constructor(private authservice: ProductService, private router: Router) { }

  canActivate() {
    if (localStorage.getItem('user') !== null) {
      return true;
    } else {
      this.router.navigate(['account']);
      return false;
    }
  }

  // canActivate(route: ActivatedRouteSnapshot,
  //             state: RouterStateSnapshot): Promise<boolean> | boolean {
  //   return this.authservice.isAuth()
  //     .then(
  //       (authenticated: boolean) => {
  //         if (authenticated) {
  //           return true;
  //         } else {
  //           this.router.navigate(['account']);
  //         }
  //
  //       }
  //     );
  // }

}
