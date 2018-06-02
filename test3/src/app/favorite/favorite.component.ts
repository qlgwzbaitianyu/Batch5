import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import * as firebase from 'firebase';
import {Observable} from 'rxjs';
import {AddfavService} from './addfav.service';


@Component({
  selector: 'app-favorite',
  templateUrl: './favorite.component.html',
  styleUrls: ['./favorite.component.css']
})
export class FavoriteComponent implements OnInit {
  favlist: any;
  username: string;
  constructor(private routern: Router,
              private addmusic: AddfavService) { }

  ngOnInit() {
    this.username = localStorage.getItem('useremail');
  }

  Gohome() {
    this.routern.navigate(['']);
  }

}
