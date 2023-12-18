import { TestBed } from '@angular/core/testing';

import { DatoCompartidoService } from './dato-compartido.service';

describe('DatoCompartidoService', () => {
  let service: DatoCompartidoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DatoCompartidoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
