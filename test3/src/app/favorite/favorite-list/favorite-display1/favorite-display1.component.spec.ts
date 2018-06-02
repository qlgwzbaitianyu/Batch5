import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FavoriteDisplay1Component } from './favorite-display1.component';

describe('FavoriteDisplay1Component', () => {
  let component: FavoriteDisplay1Component;
  let fixture: ComponentFixture<FavoriteDisplay1Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FavoriteDisplay1Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FavoriteDisplay1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
