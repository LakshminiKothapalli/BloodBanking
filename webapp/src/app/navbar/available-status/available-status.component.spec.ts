import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AvailableStatusComponent } from './available-status.component';

describe('AvailableStatusComponent', () => {
  let component: AvailableStatusComponent;
  let fixture: ComponentFixture<AvailableStatusComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AvailableStatusComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AvailableStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
