import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {SearchingService} from './searching.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {


  resultlist: any;
  artist: string;

  constructor(private routern: Router,
              private searching: SearchingService) {}

  ngOnInit() {
  }

  Gohome() {
    this.routern.navigate(['']);
  }

  onSearch() {
    this.searching.searchMusic(this.artist
    )
      .subscribe(data => {
        console.log(data['results']);
        this.resultlist = data['results'];
      });
  }

}
