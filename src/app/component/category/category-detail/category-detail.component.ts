import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from 'src/app/dto/category';
import { CategoryService } from 'src/app/service/category.service';

@Component({
  selector: 'app-category-detail',
  templateUrl: './category-detail.component.html',
  styleUrls: ['./category-detail.component.css']
})
export class CategoryDetailComponent implements OnInit {

  id: number;
  category: Category;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private categoryService: CategoryService
  ) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.categoryService.getCategory(this.id).subscribe(data => {
      console.log(data)
      this.category = data;
    },
    error => console.log(error))
  }

  goToList(){
    this.router.navigate(['/categories']);
  }
}
