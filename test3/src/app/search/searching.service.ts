import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {catchError, tap} from 'rxjs/internal/operators';



@Injectable({
  providedIn: 'root'
})
export class SearchingService {
  baseurl:string = 'https://itunes.apple.com/search';
  var1;

  constructor(private http: HttpClient) { }

  searchMusic(name: string) {
    const tmp = `${this.baseurl}?term=${name}&media=music&limit=20`;
    return this.http.get(tmp, {responseType: 'json'})
      .pipe(
        tap( // Log the result or error
          data => this.var1 = data,
          error => console.log('error'))
      );
  }
}
