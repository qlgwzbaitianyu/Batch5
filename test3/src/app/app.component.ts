import { Component,  OnInit } from '@angular/core';
import * as firebase from 'firebase';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'app';

  constructor() {}
  ngOnInit(): void {
    firebase.initializeApp({
      apiKey: "AIzaSyAtF1zQ6a7XTEI4LzE5Hc3AAflxNGUunHs",
      authDomain: "itunesapp-5aeb2.firebaseapp.com",
      databaseURL: "https://itunesapp-5aeb2.firebaseio.com",
      projectId: "itunesapp-5aeb2",
      storageBucket: "itunesapp-5aeb2.appspot.com",
      messagingSenderId: "114849592112"
    });
    firebase.firestore().settings({ timestampsInSnapshots: true });
  }
}
