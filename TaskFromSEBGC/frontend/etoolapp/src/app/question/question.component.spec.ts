import { HttpClient, HttpClientModule, HttpHandler } from '@angular/common/http';
import { ProductService } from './../common/services/product.service';
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuestionComponent } from './question.component';
import { RouterTestingModule } from '@angular/router/testing';
import { AgeRange, IncomeRange, PossibleAnwers } from '../common/models/possible-answer';
import { FormBuilder } from '@angular/forms';


describe('QuestionComponent', () => {
  let component: QuestionComponent;
  let fixture: ComponentFixture<QuestionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        HttpClientModule,
      ],
      declarations: [ QuestionComponent ],
      providers: [HttpClient, HttpClientModule, FormBuilder, PossibleAnwers]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(QuestionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should find eight products', () => {
    const productService = fixture.debugElement.injector.get(ProductService);
    let expectedLength = 8;
    productService.findProducts().subscribe(allProducts => {
      expectedLength = allProducts.length;
      console.log('====length ', length);
    });
    expect(expectedLength).toBeTruthy(length);
  });

  it('should find eight', () => {
    const productService = fixture.debugElement.injector.get(ProductService);
    const q = 8;
    expect(q).toBeTruthy(productService.findEight());
  });


});
