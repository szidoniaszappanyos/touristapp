import { TestBed } from '@angular/core/testing';

import { GetLocationOfAttractionService } from './get-location-of-attraction.service';

describe('GetLocationOfAttractionService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GetLocationOfAttractionService = TestBed.get(GetLocationOfAttractionService);
    expect(service).toBeTruthy();
  });
});
