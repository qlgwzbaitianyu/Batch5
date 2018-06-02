import {Component, Input, OnInit} from '@angular/core';
import { Injectable } from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import * as firebase from 'firebase';
import {Observable} from 'rxjs';
import {tap} from 'rxjs/internal/operators';
import {AddfavService} from '../addfav.service';

@Component({
  selector: 'app-favorite-list',
  templateUrl: './favorite-list.component.html',
  styleUrls: ['./favorite-list.component.css']
})
export class FavoriteListComponent implements OnInit {

  @Input() myfavorite: any[];
  db: any;
  trackidlist: any[];
  favoritesong: any[];
  listlength: number;


  constructor(private favservice: AddfavService) {
    this.db = firebase.firestore();
  }

  ngOnInit() {
    this.getracidlist();
    //this.getfavmusic();
  }

  getracidlist() {
    let temp =this.db.collection('person1').doc(localStorage.getItem('useremail')).get()
      .then(docsnapshot => {
        docsnapshot.data();
        this.trackidlist = Object.keys(docsnapshot.data());
        console.log('tracid~~~' + this.trackidlist);
        this.listlength = this.trackidlist.length;
      });
  }

  // getfavmusic() {
  //  console.log(this.trackidlist);
  //
  //   for (let i = 0; i < this.listlength; i++) {
  //     this.favservice.searchID(this.trackidlist[i])
  //       .subscribe(data => {
  //        //console.log(data['results']);
  //       });
  //   }
  // }

}
