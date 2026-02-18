import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, Validators } from '@angular/forms';
import { ClientService } from '../../services/client.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-new-clientes',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './new-clientes.component.html',
  styleUrl: './new-clientes.component.css'
})
export class NewClientesComponent {

  form;

  constructor(
    private fb: FormBuilder,
    private service: ClientService,
    private router: Router
  ) {
    this.form = this.fb.group({
      name: ['', Validators.required],
      cpf: ['', Validators.required],
      cnpj: ['', Validators.required],
      cellphone: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]]
    });
  }

  save() {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    this.service.createClient(this.form.value).subscribe(() => {
      this.router.navigate(['/clients']);
    });
  }
}
