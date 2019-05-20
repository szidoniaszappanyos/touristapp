import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TripRecommendationsComponent } from './trip-recommendations.component';

describe('TripRecommendationsComponent', () => {
  let component: TripRecommendationsComponent;
  let fixture: ComponentFixture<TripRecommendationsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TripRecommendationsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TripRecommendationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
