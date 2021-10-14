import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { Category } from 'src/app/dto/category';
import { CategoryService } from 'src/app/service/category.service';
import Swal from 'sweetalert2/dist/sweetalert2.js';
@Component({
  selector: 'app-category-list',
  templateUrl: './category-list.component.html',
  styleUrls: ['./category-list.component.css']
})
export class CategoryListComponent implements OnInit {

  categories: Category[] = [];
  page = 1;
  limit = 2;// maximum item number on a page.
  totalItem = 0;//total record(row) of DB
  FILTER = /[^0-9]/g;
  searchTextChanged: Subject<string> = new Subject<string>();
  @ViewChild('input', {static: false}) input: ElementRef;//'input': is #input in <input>

  constructor(
    private categoryService: CategoryService,
    private router: Router) {
  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.categoryService.getListCategories().subscribe(
      data => {
        console.log(data);
        this.categories = data;
        this.totalItem = data.length;
      })
  }

  checkAllCheckBox(ev) {
		this.categories.forEach(x => x.checked = ev.target.checked)
	}
  isAllCheckBoxChecked() {
		return this.categories.every(c => c.checked);
	}

  // deleteMultipleCategories() {
  //   const selectedCategories = this.categories.filter(category => category.checked).map(c => c.id);
  //   console.log(selectedCategories);
  //   if(selectedCategories && selectedCategories.length > 0) {
  //     Swal.fire({
  //       title: 'Are you sure want to remove?',
  //       text: 'You will not be able to recover this categories!',
  //       icon: 'warning',
  //       showCancelButton: true,
  //       confirmButtonText: 'Yes, delete it!',
  //       cancelButtonText: 'No, keep it'
  //     }).then((result) => {
  //       if (result.value) {
  //         this.categoriesService.deleteCategories(selectedBooks).subscribe(
  //           res => {
  //             console.log("Multiple books deleted!");
  //             this.reloadData();
  //           },
  //           error => console.log(error)
  //         );

  //         Swal.fire(
  //           'Deleted!',
  //           'Your data has been deleted.',
  //           'success'
  //         )
  //       } else if (result.dismiss === Swal.DismissReason.cancel) {
  //         Swal.fire(
  //           'Cancelled',
  //           'Your data is safe :)',
  //           'error'
  //         )
  //       }
  //     })
  //   } else{
  //     alert("You haven't select any books yet")
  //   }
  // }

  categoryDetails(id: number){
    this.router.navigate(['category/details', id]);
  }

  updateCategory(id: number) {
    this.router.navigate(['category/update', id]);
  }

}
