import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-favorite-display1',
  templateUrl: './favorite-display1.component.html',
  styleUrls: ['./favorite-display1.component.css']
})
export class FavoriteDisplay1Component implements OnInit {
  @Input()idlist: any[];
  constructor() { }

  ngOnInit() {
    console.log(this.idlist);
  }


}
