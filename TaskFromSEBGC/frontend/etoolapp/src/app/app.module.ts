import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PossibleAnwers } from './common/models/possible-answer';
import { QuestionComponent } from './question/question.component';
import { ResponseComponent } from './response/response.component';

@NgModule({
  declarations: [
    AppComponent,
    QuestionComponent,
    ResponseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [PossibleAnwers],
  bootstrap: [AppComponent]
})
export class AppModule { }
