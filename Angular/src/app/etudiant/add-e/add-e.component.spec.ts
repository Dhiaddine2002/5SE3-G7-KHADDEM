import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddEComponent } from './add-e.component';

describe('AddEComponent', () => {
  let component: AddEComponent;
  let fixture: ComponentFixture<AddEComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddEComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddEComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
