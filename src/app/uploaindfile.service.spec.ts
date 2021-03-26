import { TestBed } from '@angular/core/testing';

import { UploaindfileService } from './uploaindfile.service';

describe('UploaindfileService', () => {
  let service: UploaindfileService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UploaindfileService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
