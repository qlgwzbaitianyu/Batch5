import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FavoriteDisplay2Component } from './favorite-display2.component';

describe('FavoriteDisplay2Component', () => {
  let component: FavoriteDisplay2Component;
  let fixture: ComponentFixture<FavoriteDisplay2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FavoriteDisplay2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FavoriteDisplay2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
