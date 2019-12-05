import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExperienceSharingComponent } from './experience-sharing.component';

describe('ExperienceSharingComponent', () => {
  let component: ExperienceSharingComponent;
  let fixture: ComponentFixture<ExperienceSharingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExperienceSharingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExperienceSharingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
