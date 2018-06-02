import { Injectable } from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import * as firebase from 'firebase';
import {Observable} from 'rxjs';
import {tap, map} from 'rxjs/internal/operators';

@Injectable({
  providedIn: 'root'
})
export class AddfavService {

  db: any;
  constructor(private router: Router,
              private http: HttpClient) {
    this.db = firebase.firestore();
  }

  addMusic(trackid: string) {
    const musicobj = {};
    musicobj[trackid] = null;

    this.db.collection('person1').doc(localStorage.getItem('useremail'))
      .set( musicobj, { merge: true })
      .then(function() {
        console.log('Document successfully written!');
        localStorage.setItem(trackid, null);
      })
      .catch(function(error) {
        console.error('Error writing document: ', error);
      });
  }


  removeMusic(trackid: string) {
    //let item = {};
    //item[trackid] = firebase.firestore.FieldValue.delete();

    return this.db.collection('person1').doc(localStorage.getItem('useremail'))
    .update( {[trackid] : firebase.firestore.FieldValue.delete()})
      .then((res) => {
        console.log('result' + res);
        return "yeah!!";
      })
      .catch(function(error) {
        console.error('Error writing document: ', error);
      });
  }

  searchID(trackid: string) {
    const tmp =  `https://itunes.apple.com/search?term=${trackid}`;

    return this.http.get(tmp, {responseType: 'json'})
      .pipe(
        map(data => data['results'][0]),
        tap( // Log the result or error
          // data => console.log("SERVICE",data), //data['results'],
          // error => console.log('error'))
      )
    );
  }



}
