import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { ClientesComponent } from './pages/clientes/clientes.component';
import { NewClientesComponent } from './pages/new-clientes/new-clientes.component';

export const routes: Routes = [
    {path: '', component: HomeComponent},

    {path: 'clients', component: ClientesComponent,},

    {path: 'clients/new', component: NewClientesComponent,}
];
