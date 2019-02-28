import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SightsToSeeComponent } from './sights-to-see.component';

describe('SightsToSeeComponent', () => {
  let component: SightsToSeeComponent;
  let fixture: ComponentFixture<SightsToSeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SightsToSeeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SightsToSeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
