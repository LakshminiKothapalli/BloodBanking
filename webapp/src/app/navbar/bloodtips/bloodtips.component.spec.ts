import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BloodtipsComponent } from './bloodtips.component';

describe('BloodtipsComponent', () => {
  let component: BloodtipsComponent;
  let fixture: ComponentFixture<BloodtipsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BloodtipsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BloodtipsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
