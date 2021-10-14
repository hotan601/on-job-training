import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Category } from 'src/app/dto/category';
import { BookService } from 'src/app/service/book.service';
import { CategoryService } from 'src/app/service/category.service';
import { AnimationUtils } from 'src/app/utils/animation-utils';
import { ValidationMessage } from 'src/app/utils/validation-message';
import { NotificationService } from 'src/app/service/notification.service';
import Swal from 'sweetalert2/dist/sweetalert2.js';
@Component({
  selector: 'app-create-book',
  templateUrl: './create-book.component.html',
  styleUrls: ['./create-book.component.css']
})
export class CreateBookComponent implements OnInit {

  submitted = false;
  categories: Category[];
  createForm: FormGroup;
  // pricePattern = "^[1-9][0-9]{4,6}$";
  // quantityPattern = "^([1-9]|0[1-9]|[1-9][0-9]{1,2})$";

  futureDateError: boolean;

  constructor(private bookSevice: BookService,
      private router: Router,
      private categoryService: CategoryService,
      private formBuilder: FormBuilder,
      public validationMessage: ValidationMessage,
      private notifyService: NotificationService) { }

  ngOnInit() {
    AnimationUtils.tabLoop();
    AnimationUtils.focusFirstInput();
    this.categoryService.getListCategories().subscribe(data => {
      this.categories = data;
    })
    this.createForm = this.formBuilder.group({
      name: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(50)]],
      categoryCode: ['', Validators.required],
      author: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(50)]],
      price: ['', [Validators.required, Validators.min(10000), Validators.max(10000000)]],
      publishedDate: ['', Validators.required],
      quantity: ['', [Validators.required, Validators.min(1), Validators.max(1000)]],
      description: ['', Validators.maxLength(1000)]
    })
  }

  save() {
    this.bookSevice.createBook(this.createForm.value).subscribe(
      data => {
        this.router.navigate(['/books']);
        this.notifyService.showSuccess("Data created successfully !!", "Notification");
      },
      error => console.log(error)
    );
  }

  checkExistByName(){
    this.bookSevice.getBookByName(this.createForm.value.name).subscribe(
      data => {
        if (data){
          this.createForm.get('name').setErrors({ shouldBeUnique: true})
          console.log(this.createForm.get('name'));
        } else {
          this.save();
        }
      },
      error => console.log(error)
    );
  }

  get f() {
    return this.createForm.controls;
  }

  onSubmit() {
    this.submitted = true;
    this.checkExistByName();
    if (this.createForm.invalid) {
      return;
    }
    // this.save();
  }

  // gotoList() {
  //   this.router.navigate(['/books']);
  // }
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
        this.router.navigate(['/book/add']);
      }
    })
  }


  onReset() {
    this.submitted = false;
    this.createForm.reset();
  }

  checkDateValidity(): boolean {
    const now = new Date();
    const inputDate = new Date(this.createForm.value.publishedDate);

    if (inputDate < now) {
      return this.futureDateError = true;
    } else{
      this.createForm.get('publishedDate').setErrors({ date: true})
      return this.futureDateError = false;
    }
  }
}
