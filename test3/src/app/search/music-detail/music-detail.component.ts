import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {templateJitUrl} from '@angular/compiler';

@Component({
  selector: 'app-music-detail',
  templateUrl: './music-detail.component.html',
  styleUrls: ['./music-detail.component.css']
})
export class MusicDetailComponent implements OnInit {

  musicObj: any;

  constructor(private route: ActivatedRoute,
              private  router: Router) { }
  ngOnInit() {

     const param = this.route.snapshot.params['artistName'];
     console.log(param);
    // if (param) {
    //   this.Display(param);
    // }
   let temp = JSON.parse(localStorage.getItem('music'));
   this.musicObj = temp;
   console.log(temp);
  }

  Display(song: object) {
    console.log(song);
  }

  Goback() {
    this.router.navigate(['search']);
  }

}
