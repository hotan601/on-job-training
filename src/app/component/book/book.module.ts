import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BookRoutingModule } from './book-routing.module';

import { BookDetailComponent } from './book-detail/book-detail.component';
import { CreateBookComponent } from './create-book/create-book.component';

import { SearchBookComponent } from './search-book/search-book.component';
import { UpdateBookComponent } from './update-book/update-book.component';
import { BookComponent } from './book.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TooltipModule } from 'ngx-bootstrap/tooltip';


@NgModule({
  imports: [
    CommonModule,
    BookRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
    TooltipModule.forRoot(),

  ],
  declarations: [
    BookComponent,
    BookDetailComponent,
    CreateBookComponent,
    SearchBookComponent,
    UpdateBookComponent,

  ]
})
export class BookModule { }
