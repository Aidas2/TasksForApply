import { PossibleAnwers } from './../common/models/possible-answer';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Product } from '../common/models/product-model';
import { Response } from '../common/models/response-model';
import { ProductService } from '../common/services/product.service';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.scss']
})
export class QuestionComponent implements OnInit {

  public products: Product[] = [];
  public recommendedProducts: Product[] = [];
  public response: Response;
  public answersToAge = this.possibleAnswers.answersToAge;
  public answersToIncome = this.possibleAnswers.answersToIncome;
  questionForm: FormGroup;

  constructor(private productService: ProductService,
              private possibleAnswers: PossibleAnwers,
              private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.findProducts();
    this.initForm();
    this.response = new Response(this.answersToAge[0].description, false, this.answersToIncome[0].description);
  }

  public findProducts(): void {
    this.productService.findProducts().subscribe(value => {
      if (value) {
        this.products.push(...value);
      }
    });
  }

  public initForm(): void {
    this.questionForm = this.formBuilder.group({
      ageRange: new FormControl(this.answersToAge[0].description, Validators.required),
      isStudent: new FormControl(false, Validators.required),
      incomeRange: new FormControl(this.answersToIncome[0].description, Validators.required)
    });

    this.questionForm.get('ageRange').valueChanges.subscribe(value => {
      this.response.ageRange = value;
    });

    this.questionForm.get('isStudent').valueChanges.subscribe(value => {
      this.response.isStudent = value;
    });

    this.questionForm.get('incomeRange').valueChanges.subscribe(value => {
      this.response.incomeRange = value;
    });
  }

  public findRecommendedProduct(): void {
    this.recommendedProducts = [];
    this.productService.findRecommendedProduct(this.response).subscribe((products: Product[]) => {
      if (products) {
        this.recommendedProducts.push(...products);
      }
    });
  }

}
