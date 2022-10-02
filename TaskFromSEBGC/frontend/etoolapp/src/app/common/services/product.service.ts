import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../models/product-model';
import { Response } from '../models/response-model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  public backendUrl = environment.eToolAppApi;

  constructor(private httpClient: HttpClient) {
  }

  public findProducts(): Observable<Product[]> {
    // NICE TO HAVE: use ProductDTO instead;
    return this.httpClient.get<Product[]>(this.backendUrl + 'products/all');
  }

  // public findRecommendedProduct(response: Response): Observable<Product> {
  //   // NICE TO HAVE: use ProductDTO or ProductSearchDTO instead;
  //   // NICE TO HAVE: use separate parameters and get method
  //   return this.httpClient.post<Product>(this.backendUrl + 'products/by-params', response);
  // }

  public findRecommendedProduct(response: Response): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.backendUrl + 'products/by-params',
      {
        params: {
          ageRange: '' + response.ageRange,
          isStudent: '' + response.isStudent,
          incomeRange: '' + response.incomeRange
        }
      });
  }

  public findEight(): number {
    return 8;
  }

}
