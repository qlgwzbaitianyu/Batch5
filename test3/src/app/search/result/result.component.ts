import {Component, Input, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AddfavService} from '../../favorite/addfav.service';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {
  @Input() result: any[];

  constructor(private routern: Router,
              private addmusic: AddfavService) {
  }

  ngOnInit() {
  }


  onClick(re) {
    // console.log(JSON.stringify(re));
    localStorage.setItem('music', JSON.stringify(re));
  }

  addToMyfavorite(re) {
    console.log(re.trackId);
    this.addmusic.addMusic(re.trackId);
  }

}
