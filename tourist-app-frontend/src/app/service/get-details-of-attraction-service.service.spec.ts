import { TestBed } from '@angular/core/testing';

import { GetDetailsOfAttractionServiceService } from './get-details-of-attraction-service.service';

describe('GetDetailsOfAttractionServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GetDetailsOfAttractionServiceService = TestBed.get(GetDetailsOfAttractionServiceService);
    expect(service).toBeTruthy();
  });
});
