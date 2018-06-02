import { Injectable } from '@angular/core';
import * as firebase from 'firebase';
import {Observable} from 'rxjs';
import { from } from 'rxjs';
import {Router} from '@angular/router';
import {HttpClient, HttpClientModule} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UploadprofileService {
  prof: object;
  db: any;
  constructor(private http: HttpClient) {
    this.db = firebase.firestore();
  }

  // getracidlist() {
  //   let temp =this.db.collection('person1').doc(localStorage.getItem('useremail')).get()
  //     .then(docsnapshot => {
  //       docsnapshot.data();
  //       this.trackidlist = Object.keys(docsnapshot.data());
  //       console.log('tracid~~~' + this.trackidlist);
  //       this.listlength = this.trackidlist.length;
  //     });
  // }

  downlloadProfile() {
   return from(this.db.collection('person1').doc('fav' + localStorage.getItem('useremail')).get()
     .then(result => {
       this.prof = result.data();
       console.log(this.prof);
       return this.prof;
     }));
  }

  uploadProfile(profile: Object) {
    this.db.collection('person1').doc('fav' + localStorage.getItem('useremail'))
      .set({ prof: profile} , { merge: true })
      .then(() => {
        console.log('Document successfully written!');
      });

  }

}
