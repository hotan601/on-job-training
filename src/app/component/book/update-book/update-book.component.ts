import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Book } from 'src/app/dto/book';
import { Category } from 'src/app/dto/category';
import { BookService } from 'src/app/service/book.service';
import { CategoryService } from 'src/app/service/category.service';
import { ValidationMessage } from 'src/app/utils/validation-message';
import { AnimationUtils } from 'src/app/utils/animation-utils';
import { NotificationService } from 'src/app/service/notification.service';
import Swal from 'sweetalert2/dist/sweetalert2.js';
@Component({
  selector: 'app-update-book',
  templateUrl: './update-book.component.html',
  styleUrls: ['./update-book.component.css']
})
export class UpdateBookComponent implements OnInit {

  updateForm: FormGroup;
  id: number;
  book = new Book;
  // categories: Observable<Category[]>;
  categories: Category[];
  submitted = false;
  futureDateError: boolean;

  constructor(private bookService: BookService, private route: ActivatedRoute,
        private router: Router,
        private formBuilder: FormBuilder,
        private categoryService: CategoryService,
        public validationMessage: ValidationMessage,
        private notifyService: NotificationService) { }

  ngOnInit() {
    AnimationUtils.tabLoop();
    AnimationUtils.focusFirstInput();
    this.id = this.route.snapshot.params['id'];
    this.bookService.getBook(this.id).subscribe(data => {
      console.log(data)
      this.book = data;
    },
    error => console.log(error));

    // this.categories = this.categoryService.getListCategories();
    this.categoryService.getListCategories().subscribe(data => {
      this.categories = data;
    })

    this.updateForm = this.formBuilder.group({
      name: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(50)]],
      categoryCode: ['', Validators.required],
      author: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(50)]],
      price: ['', [Validators.required, Validators.min(10000), Validators.max(10000000)]],
      publishedDate: ['', Validators.required],
      quantity: ['', [Validators.required, Validators.min(1), Validators.max(1000)]],
      description: ['', Validators.maxLength(1000)]
    })
  }
  updateBook() {
    this.bookService.updateBook(this.id, this.updateForm.value).subscribe(res => {
      console.log('Book updated successfully!');
      this.notifyService.showSuccess("Data updated successfully !!", "Notification");
      this.router.navigate(['/books']);

    },
    error => console.log(error));
  }
  get f() {
    return this.updateForm.controls;//read only
  }

  onSubmit() {
    this.submitted = true;
    if (this.updateForm.invalid) {
      return;
    }
    this.updateBook();
  }

  gotoList() {
    Swal.fire({
      title: 'Are you sure want to exit?',
      text: 'Your data entered will be lost!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, exit it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      if (result.value) {
        this.router.navigate(['/books']);
      } else if (result.dismiss === Swal.DismissReason.cancel) {
        this.router.navigate(['book/update', this.id]);
      }
    })
  }

  checkDateValidity(): boolean {
    const now = new Date();
    const inputDate = new Date(this.updateForm.value.publishedDate);

    if (inputDate < now) {
      return this.futureDateError = true;
    } else{
      this.updateForm.get('publishedDate').setErrors({ date: true})
      return this.futureDateError = false;
    }
  }

}
