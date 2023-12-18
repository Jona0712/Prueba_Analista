import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChequeraComponent } from './chequera.component';

describe('ChequeraComponent', () => {
  let component: ChequeraComponent;
  let fixture: ComponentFixture<ChequeraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChequeraComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ChequeraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
