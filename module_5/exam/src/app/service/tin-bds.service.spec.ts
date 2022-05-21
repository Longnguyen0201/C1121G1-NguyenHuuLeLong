import { TestBed } from '@angular/core/testing';

import { TinBdsService } from './tin-bds.service';

describe('TinBdsService', () => {
  let service: TinBdsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TinBdsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
