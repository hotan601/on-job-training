import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CategoryService } from 'src/app/service/category.service';
import { NotificationService } from 'src/app/service/notification.service';
import { AnimationUtils } from 'src/app/utils/animation-utils';
import { ValidationMessage } from 'src/app/utils/validation-message';
import Swal from 'sweetalert2/dist/sweetalert2.js';

@Component({
  selector: 'app-create-category',
  templateUrl: './create-category.component.html',
  styleUrls: ['./create-category.component.css']
})
export class CreateCategoryComponent implements OnInit {

  submitted = false;
  createForm: FormGroup;

  constructor(
    private categoryService: CategoryService,
    private router: Router,
    private formBuilder: FormBuilder,
    public validationMessage: ValidationMessage,
    private notifyService: NotificationService
  ) { }

  ngOnInit() {
    AnimationUtils.tabLoop();
    AnimationUtils.focusFirstInput();
    this.createForm = this.formBuilder.group({
      categoryName: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(50)]],
      categoryCode: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(50)]],
      description: ['', Validators.maxLength(1000)]
    })
  }

  saveCategory() {
    this.categoryService.createCategory(this.createForm.value).subscribe(
      data => {
        this.router.navigate(['/categories']);

      },
      error => console.log(error)
    );
  }
  checkExistByName() {
    this.categoryService.getCategoryByName(this.createForm.value.categoryName).subscribe(
      data => {
        if (data) {
          this.createForm.get('categoryName').setErrors({ shouldBeUnique: true})
          console.log(this.createForm.get('categoryName'));
        } else {
          this.saveCategory();
          // this.notifyService.showSuccess("Data created successfully!", "Notification");
        }
      },
      error => console.log(error)
    );
  }

  // checkExistByCode() {
  //   this.categoryService.getCategoryByCode(this.createForm.value.categoryCode).subscribe(
  //     data => {
  //       if (data) {
  //         this.createForm.get('categoryCode').setErrors({ shouldBeUnique: true})
  //       } else {
  //         this.saveCategory();
  //       }
  //     }
  //   )
  // }

  get f() {
    return this.createForm.controls;
  }

  onSubmit() {
    this.submitted = true;
    this.checkExistByName();
    // this.checkExistByCode();
    if (this.createForm.invalid) {
      return;
    // } else {
    //   this.saveCategory();
    }


  }

  onReset() {
    // this.submitted = false;
    this.createForm.reset();
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

        Swal.fire(
          'Exited!',
          'You have exited the create form!',
          'success'
        )
        this.router.navigate(['/categories']);
      } else if (result.dismiss === Swal.DismissReason.cancel) {
        Swal.fire(
          'Cancelled',
          'Your data entered is still available :)',
          'error'
        )
        this.router.navigate(['/category/add']);
      }
    })
  }
}
