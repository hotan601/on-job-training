import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
// import {DataTablesModule} from 'angular-datatables';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookListComponent } from './component/book/book-list/book-list.component';
import { ToastrModule } from 'ngx-toastr';
import { CategoryListComponent } from './component/category/category-list/category-list.component';
import { PaginationComponent } from './component/common/pagination/pagination.component';
import { NgxSpinnerModule } from "ngx-spinner";

@NgModule({
  declarations: [
    AppComponent,
    BookListComponent,
    CategoryListComponent,
    PaginationComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    TooltipModule.forRoot(),
    NgbModule,
    ToastrModule.forRoot(),
    NgxSpinnerModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }





















// import { BrowserModule } from '@angular/platform-browser';
// import { NgModule } from '@angular/core';
// import { HttpClientModule } from '@angular/common/http';
// import { FormsModule } from '@angular/forms';
// import { ReactiveFormsModule } from '@angular/forms';

// import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

// import { AppRoutingModule } from './app-routing.module';
// import { AppComponent } from './app.component';
// import { CreateBookComponent } from './component/book/create-book/create-book.component';
// import { BookDetailComponent } from './component/book/book-detail/book-detail.component';
// import { BookListComponent } from './component/book/book-list/book-list.component';
// import { UpdateBookComponent } from './component/book/update-book/update-book.component';
// import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
// import { SearchBookComponent } from './component/book/search-book/search-book.component';

// import { TooltipModule } from 'ngx-bootstrap/tooltip';
// import { HomeComponent } from './component/home/home.component';
// import { PageNotFoundComponent } from './component/book/page-not-found/page-not-found.component';

// @NgModule({
//   declarations: [
//     AppComponent,
//     CreateBookComponent,
//     BookDetailComponent,
//     BookListComponent,
//     UpdateBookComponent,
//     SearchBookComponent,
//     HomeComponent,
//     PageNotFoundComponent,

//   ],
//   imports: [
//     BrowserModule,
//     AppRoutingModule,
//     FormsModule,
//     HttpClientModule,
//     ReactiveFormsModule,
//     BrowserAnimationsModule,
//     NgbModule,
//     TooltipModule.forRoot()
//   ],
//   providers: [],
//   bootstrap: [AppComponent]
// })
// export class AppModule { }
