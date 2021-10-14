import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CategoryRoutingModule } from './category-routing.module';

import { CategoryDetailComponent } from './category-detail/category-detail.component';
import { CreateCategoryComponent } from './create-category/create-category.component';

import { SearchCategoryComponent } from './search-category/search-category.component';
import { UpdateCategoryComponent } from './update-category/update-category.component';
import { CategoryComponent } from './category.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TooltipModule } from 'ngx-bootstrap/tooltip';

@NgModule({
  imports: [
    CommonModule,
    CategoryRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    NgbModule,
    TooltipModule.forRoot(),

  ],
  declarations: [
    CategoryComponent,
    CategoryDetailComponent,
    CreateCategoryComponent,
    SearchCategoryComponent,
    UpdateCategoryComponent,

  ]
})
export class CategoryModule { }
