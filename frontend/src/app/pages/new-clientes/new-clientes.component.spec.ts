import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewClientesComponent } from './new-clientes.component';

describe('NewClientesComponent', () => {
  let component: NewClientesComponent;
  let fixture: ComponentFixture<NewClientesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewClientesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewClientesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
