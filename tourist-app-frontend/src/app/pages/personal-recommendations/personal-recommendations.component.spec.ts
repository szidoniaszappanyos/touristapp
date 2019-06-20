import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PersonalRecommendationsComponent } from './personal-recommendations.component';

describe('PersonalRecommendationsComponent', () => {
  let component: PersonalRecommendationsComponent;
  let fixture: ComponentFixture<PersonalRecommendationsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PersonalRecommendationsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PersonalRecommendationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
