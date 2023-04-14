import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FarmService {

  private url = 'http://localhost:8011/api/v1/farms';

  constructor(private httpClient: HttpClient) {

  }

  getFarms() {
    return this.httpClient.get(this.url);
  }

}
