import { TestBed } from '@angular/core/testing';

import { GetGalleryOfAttractionServiceService } from './get-gallery-of-attraction-service.service';

describe('GetGalleryOfAttractionServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GetGalleryOfAttractionServiceService = TestBed.get(GetGalleryOfAttractionServiceService);
    expect(service).toBeTruthy();
  });
});
