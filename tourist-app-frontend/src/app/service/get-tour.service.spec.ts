import { TestBed } from '@angular/core/testing';

import { GetTourService } from './get-tour.service';

describe('GetTourService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GetTourService = TestBed.get(GetTourService);
    expect(service).toBeTruthy();
  });
});
