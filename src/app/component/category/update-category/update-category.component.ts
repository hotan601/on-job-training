import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from 'src/app/dto/category';
import { CategoryService } from 'src/app/service/category.service';
import { NotificationService } from 'src/app/service/notification.service';
import { AnimationUtils } from 'src/app/utils/animation-utils';
import { ValidationMessage } from 'src/app/utils/validation-message';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-category',
  templateUrl: './update-category.component.html',
  styleUrls: ['./update-category.component.css']
})
export class UpdateCategoryComponent implements OnInit {

  submitted = false;
  updateForm: FormGroup;
  id: number;
  category = new Category;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private formBuilder: FormBuilder,
    private categoryService: CategoryService,
    public validationMessage: ValidationMessage,
    private notifyService: NotificationService
  ) { }

  ngOnInit() {
    AnimationUtils.tabLoop();
    AnimationUtils.focusFirstInput();
    this.id = this.route.snapshot.params['id'];
    this.categoryService.getCategory(this.id).subscribe(data => {
      console.log(data)
      this.category = data;
    },
    error => console.log(error));
    this.updateForm = this.formBuilder.group({
      categoryName: ['', [Validators.required, Validators.minLength(5), Validators.maxLength(50)]],
      categoryCode: ['', [Validators.required,Validators.minLength(5), Validators.maxLength(50)]],
      description: ['', Validators.maxLength(1000)]
    })
  }
  updateCategory() {
    this.categoryService.updateCategory(this.id, this.updateForm.value).subscribe(res => {
      console.log('Category updated successfully!');
      this.notifyService.showSuccess("Data updated successfully !!", "Notification");
      this.router.navigate(['/categories']);

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
    this.updateCategory();
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
          'You have exited the update form!',
          'success'
        )
        this.router.navigate(['/categories']);
      } else if (result.dismiss === Swal.DismissReason.cancel) {
        Swal.fire(
          'Cancelled',
          'Your data entered is still available :)',
          'error'
        )
        this.router.navigate(['category/update', this.id]);
      }
    })
  }

}
