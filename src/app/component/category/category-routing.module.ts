import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CategoryDetailComponent } from './category-detail/category-detail.component';
import { CreateCategoryComponent } from './create-category/create-category.component';
import { SearchCategoryComponent } from './search-category/search-category.component';
import { UpdateCategoryComponent } from './update-category/update-category.component';
import { CategoryComponent } from './category.component';

const routes: Routes = [
  {
    path: '',
    component: CategoryComponent,
    children: [
      {
        path: 'add', component: CreateCategoryComponent
      },
      {
        path: 'update/:id', component: UpdateCategoryComponent
      },
      {
        path: 'details/:id', component: CategoryDetailComponent
      },
      {
        path: 'search', component: SearchCategoryComponent
      },
    ],
  },

];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CategoryRoutingModule { }
