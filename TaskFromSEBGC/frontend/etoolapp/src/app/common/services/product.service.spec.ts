import { HttpClient, HttpClientModule, HttpHandler } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';

import { ProductService } from './product.service';
import { Product } from './../models/product-model';
import { Response } from '../models/response-model';
import { AgeRange, IncomeRange } from '../models/possible-answer';

describe('ProductService', () => {
  let service: ProductService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [HttpClient, HttpClientModule, HttpHandler]
    });
    service = TestBed.inject(ProductService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should find goldCredit', () => {
    // const productService = fixture.debugElement.injector.get(ProductService);

    const ageRange = AgeRange.MIDDLE;
    const isStudent = false;
    const incomeRange = IncomeRange.LARGE;
    const response = new Response(ageRange, isStudent, incomeRange);
    let recommendedProducts: Product[] = [];
    const expectedTitle = 'Gold Credit';

    service.findRecommendedProduct(response).subscribe(recommended => {
      recommendedProducts.push(...recommended);
    });
    expect(expectedTitle).toBeTruthy(recommendedProducts[0].title);
  });
});
