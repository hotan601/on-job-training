import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookListComponent } from './component/book/book-list/book-list.component';
import { CategoryListComponent } from './component/category/category-list/category-list.component';


const routes: Routes = [
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full',
  },
  {
    path: 'book',
    loadChildren: './component/book/book.module#BookModule'
  },
  {
    path: 'books',
    component: BookListComponent
  },
  {
    path: 'category',
    loadChildren: './component/category/category.module#CategoryModule'
  },
  {
    path: 'categories',
    component: CategoryListComponent
  },
  {
    path: 'home',
    loadChildren: './component/home/home.module#HomeModule'
  },
  {
    path: '**',
    loadChildren: './component/page-not-found/page-not-found.module#PageNotFoundModule'
  },

]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
  providers: []
})
export class AppRoutingModule { }





// import { NgModule } from '@angular/core';
// import { Routes, RouterModule } from '@angular/router';
// import { BookDetailComponent } from './component/book/book-detail/book-detail.component';
// import { BookListComponent } from './component/book/book-list/book-list.component';
// import { CreateBookComponent } from './component/book/create-book/create-book.component';
// import { HomeComponent } from './component/book/home/home.component';
// import { PageNotFoundComponent } from './component/book/page-not-found/page-not-found.component';
// import { SearchBookComponent } from './component/book/search-book/search-book.component';
// import { UpdateBookComponent } from './component/book/update-book/update-book.component';

// const routes: Routes = [
//   {
//     path: '', redirectTo: '/home', pathMatch: 'full'
//   },
//   {
//     path: 'home', component: HomeComponent
//   },
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
//   {
//     path: '**', component: PageNotFoundComponent
//   }
// ]

// @NgModule({
//   imports: [RouterModule.forRoot(routes)],
//   exports: [RouterModule]
// })
// export class AppRoutingModule { }
