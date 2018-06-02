import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { SearchComponent } from './search/search.component';
import { AccountComponent } from './account/account.component';
import { FavoriteComponent } from './favorite/favorite.component';
import {RouterModule, Routes} from '@angular/router';
import { Test01Component } from './test01/test01.component';
import {HttpClientModule} from '@angular/common/http';
import {ProductService} from './test01/product.service';
import {SearchingService} from './search/searching.service';
import { ResultComponent } from './search/result/result.component';
import {LoginRouteGuardService} from './login-route-guard.service';
import { MusicDetailComponent } from './search/music-detail/music-detail.component';

import {RegisterService} from './test01/register.service';
import {AddfavService} from './favorite/addfav.service';
import { FavoriteListComponent } from './favorite/favorite-list/favorite-list.component';
import { FavoriteDisplay1Component } from './favorite/favorite-list/favorite-display1/favorite-display1.component';
import { FavoriteDisplay2Component } from './favorite/favorite-list/favorite-display2/favorite-display2.component';
import { LogoutComponent } from './logout/logout.component';
import { ProfileComponent } from './profile/profile.component';
import {ReactiveFormsModule} from '@angular/forms';
import {Mo1Module} from './mo1/mo1.module';
import {UploadprofileService} from './profile/uploadprofile.service';
import { ShowprofileComponent } from './profile/showprofile/showprofile.component';
import { CustomdirectiveDirective } from './customdirective.directive';
import { CustomifDirective } from './customDirective/customif.directive';



const appRoutes: Routes = [
  {path: '', component: HomeComponent },
  {path: 'search', component: SearchComponent, canActivate: [LoginRouteGuardService] },
  {path: 'favorite', component: FavoriteComponent, canActivate: [LoginRouteGuardService] },
  {path: 'account', component: AccountComponent},
  {path: 'test01', component: Test01Component},
  {path: 'search/result', component: ResultComponent},
  {path: 'search/music-detail/:artistName', component: MusicDetailComponent},
  {path: 'logout', component: LogoutComponent},
  {path: 'showprofile', component: ShowprofileComponent},
  {path: 'profile', component: ProfileComponent},
  //{path: 'profile', component: ProfileComponent, loadChildren: './mo1.module#Mo1Module'},
];


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    SearchComponent,
    AccountComponent,
    FavoriteComponent,
    Test01Component,
    ResultComponent,
    MusicDetailComponent,
    FavoriteListComponent,
    FavoriteDisplay1Component,
    FavoriteDisplay2Component,
    LogoutComponent,
    ShowprofileComponent,
    CustomdirectiveDirective,
    CustomifDirective,
   // ProfileComponent,
    // AngularFireAuthModule,
    // AngularFireDatabaseModule,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    Mo1Module,
    // AngularFireModule
  ],
  providers: [HttpClientModule, ProductService, SearchingService, LoginRouteGuardService,
    RegisterService, AddfavService, UploadprofileService],
  bootstrap: [AppComponent]
})
export class AppModule { }
