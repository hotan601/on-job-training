import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { BookDetailComponent } from './book-detail/book-detail.component';
import { CreateBookComponent } from './create-book/create-book.component';
import { SearchBookComponent } from './search-book/search-book.component';
import { UpdateBookComponent } from './update-book/update-book.component';
import { BookComponent } from './book.component';

const routes: Routes = [
  {
    path: '',
    component: BookComponent,
    children: [
      {
        path: 'add', component: CreateBookComponent
      },
      {
        path: 'update/:id', component: UpdateBookComponent
      },
      {
        path: 'details/:id', component: BookDetailComponent
      },
      {
        path: 'search', component: SearchBookComponent
      },
    ],
  },

];


// const routes: Routes = [
//   {
//     path: 'books', component: BookListComponent
//   },
//   {
//     path: 'book/add', component: CreateBookComponent
//   },
//   {
//     path: 'book/update/:id', component: UpdateBookComponent
//   },
//   {
//     path: 'book/details/:id', component: BookDetailComponent
//   },
//   {
//     path: 'book/search', component: SearchBookComponent
//   },
// ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BookRoutingModule { }
