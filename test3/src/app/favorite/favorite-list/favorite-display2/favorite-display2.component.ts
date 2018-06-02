import {Component, Input, OnInit} from '@angular/core';
import {AddfavService} from '../../addfav.service';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-favorite-display2',
  templateUrl: './favorite-display2.component.html',
  styleUrls: ['./favorite-display2.component.css']
})
export class FavoriteDisplay2Component implements OnInit {
  @Input() singleid: string;

  private music;
  private artistName;
  private  collectionName;
  private collectionViewUrl;
  private artworkUrl60;
  musicItem;
  private showItem: boolean = true;

  constructor(private favservice: AddfavService) { }

  ngOnInit() {
    console.log(this.showItem);
    this.getfavmusic();
  }

  removeFav() {
    console.log(event.target['value']);
    this.favservice.removeMusic(this.singleid)
      .then((message) => {
        console.log(message);
        this.showItem = false;
      });
  }

  getfavmusic() {
      this.favservice.searchID(this.singleid)
        .subscribe(data => {
          this.music = data;
           this.artistName = data.artistName;
           this.collectionName = data.collectionName;
           this.collectionViewUrl = data.collectionViewUrl;
           this.artworkUrl60 = data.artworkUrl60;
           console.log(data);
          // for (const p in this.music) {
          //
          //   //console.log(this.music[p]);
          //   this.musicItem = this.music[p]['artistName'];
          // }
        });

  }

}
