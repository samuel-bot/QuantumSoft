import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private api = 'http://localhost:8080/clients';

  constructor(private http: HttpClient) {}

  getClients() {
    return this.http.get<any[]>(this.api);
  }
  createClient(data: any) {
  return this.http.post(this.api, data);
}

}

