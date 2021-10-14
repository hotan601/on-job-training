import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Book } from 'src/app/dto/book';
import { Category } from 'src/app/dto/category';
import { BookService } from 'src/app/service/book.service';
import { CategoryService } from 'src/app/service/category.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-book-detail',
  templateUrl: './book-detail.component.html',
  styleUrls: ['./book-detail.component.css']
})
export class BookDetailComponent implements OnInit {

  id: number;
  book: Book;
  categories: Observable<Category[]>;


  constructor(private route: ActivatedRoute, private router: Router,
    private bookService: BookService,
    private categoryService: CategoryService) { }

  ngOnInit() {
    this.id = this.route.snapshot.params['id'];
    this.bookService.getBook(this.id).subscribe(data => {
      console.log(data)
      this.book = data;
    },
    error => console.log(error))
    this.categories = this.categoryService.getListCategories();
  }

  // ngOnInit() {
  //   this.detailsBook();
  //   this.categories = this.categoryService.getListCategories();
  // }

  // detailsBook() {
  //   this.id = this.route.snapshot.params['id'];

  //   this.bookService.getListBooks().subscribe(res => {
  //     console.log(res.length);

  //     this.bookService.getBook(this.id).subscribe(data => {
  //       if (data == null) {
  //         Swal.fire({
  //           title: 'Are you sure want to load page?',
  //           text: 'Your data has been deleted.',
  //           icon: 'error',
  //           showCancelButton: true,
  //           confirmButtonText: 'Yes, load page!',
  //           cancelButtonText: 'No, keep it'
  //         }).then((result) => {
  //           if (result.value) {
  //             this.list();
  //           }
  //         })
  //       } else {
  //         this.book = data;
  //       }
  //     },
  //     error => console.log(error))
  //   })

  // }

  list(){
    this.router.navigate(['/books']);
  }
}
