import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpecificMapComponent } from './specific-map.component';

describe('SpecificMapComponent', () => {
  let component: SpecificMapComponent;
  let fixture: ComponentFixture<SpecificMapComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpecificMapComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpecificMapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
