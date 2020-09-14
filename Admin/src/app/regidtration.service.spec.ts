import { TestBed } from '@angular/core/testing';

import { RegidtrationService } from './regidtration.service';

describe('RegidtrationService', () => {
  let service: RegidtrationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegidtrationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
