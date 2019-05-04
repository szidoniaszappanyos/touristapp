import { TestBed } from '@angular/core/testing';

import { GetAllAttractionsService } from './get-all-attractions.service';

describe('GetAllAttractionsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GetAllAttractionsService = TestBed.get(GetAllAttractionsService);
    expect(service).toBeTruthy();
  });
});
