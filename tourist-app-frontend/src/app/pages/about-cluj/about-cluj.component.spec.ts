import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AboutClujComponent } from './about-cluj.component';

describe('AboutClujComponent', () => {
  let component: AboutClujComponent;
  let fixture: ComponentFixture<AboutClujComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AboutClujComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AboutClujComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
