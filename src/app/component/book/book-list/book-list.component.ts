import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Book } from 'src/app/dto/book';
import { BookService } from 'src/app/service/book.service';
import { TooltipConfig } from 'ngx-bootstrap/tooltip';
import { fromEvent, Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged, map} from 'rxjs/operators';
import { NotificationService } from 'src/app/service/notification.service';
import { ConfirmBoxService } from 'src/app/service/confirmBox.service';
import Swal from 'sweetalert2/dist/sweetalert2.js';
import { PagingArgs } from '../../common/pagination/pagination.component';
import { CalculateTableIndex } from 'src/app/utils/calculate-table-index';
import { NgxSpinnerService } from "ngx-spinner";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {

  books: Book[] = [];
  // books: Book[];
  page = 1;
  limit = 6;// maximum item number on a page.
  totalItem = 0;//total record(row) of DB
  FILTER = /[^0-9]/g;
  searchTextChanged: Subject<string> = new Subject<string>();


  totalPages: number;
  totalElements: number;
  query: string="";
  pageSize: number;

  // default paging, search, sort
  pagingArgs: PagingArgs = {
      query: "",
      pageNumber: 1,
      pageSize: 5,
      sortBy: "id",
      sortDirection: "desc",
  };

  @ViewChild('input', {static: false}) input: ElementRef;//'input': is #input in <input>
  //ViewChild : to get the reference to element marked with the #input

  constructor(
    private bookService: BookService,
    private router: Router,
    private notifyService: NotificationService,
    private confirmBoxService: ConfirmBoxService,
    public calculateTableIndex: CalculateTableIndex,
    private spinnerService: NgxSpinnerService) {

  }

  ngOnInit() {
    this.reloadData(this.pagingArgs);
    this.onChangeSearch();
    console.log("ngOnInit");

  }

  reloadData(eventArgs?) {
    this.spinnerService.show();
    this.pagingArgs = eventArgs;
    this.bookService.getAll(eventArgs).subscribe(
      response => {
        if (response) {
          this.books = response.content;
          this.totalElements = response.totalElements;
          this.totalPages = response.totalPages;
          console.log(response.content);
          setTimeout(() => {
            /** spinner ends after 5 seconds */
            this.spinnerService.hide();
          }, 300);


        } else {
            this.books = [];
            this.totalElements = 0;
            this.totalPages = 0;
        }
      },
      error => console.log(error)
    )
  }

  deleteBook(id: number) {
    Swal.fire({
      title: 'Are you sure want to remove?',
      text: 'You will not be able to recover this book!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    }).then((result) => {
      if (result.value) {
        this.bookService.getBook(id).subscribe(
          res => {
            console.log(res);
            if (res == null) {
              Swal.fire({
                title: 'Are you sure want to load page?',
                text: 'Your data has been deleted by someone else!',
                icon: 'error',
                showCancelButton: true,
                confirmButtonText: 'Yes, load page!',
                cancelButtonText: 'No, keep it'
              }).then((result) => {
                if (result.value) {
                  this.reloadData(this.pagingArgs);
                }
              })
            } else {
              this.bookService.deleteBook(id).subscribe(
                res => {
                    this.reloadData(this.pagingArgs);
                    Swal.fire(
                      'Deleted successfully!',
                      '',
                      'success'
                    )
                },
              )
            }
          },
          error => {
            console.log(error);
          }
        )
      }
    })
  }

  bookDetails(id: number){
    console.log("ID:" +id);
    this.bookService.getBook(id).subscribe(data => {
      if (data == null) {
        Swal.fire({
          title: 'Are you sure want to load page?',
          text: 'Your data has been deleted by someone else!',
          icon: 'error',
          showCancelButton: true,
          confirmButtonText: 'Yes, load page!',
          cancelButtonText: 'No, keep it'
        }).then((result) => {
          if (result.value) {
            this.reloadData(this.pagingArgs);
          }
        })
      } else {
        this.router.navigate(['book/details', id]);
      }
    },
    error => console.log(error))
  }
  updateBook(id: number) {
    console.log("ID:" +id);
    this.bookService.getBook(id).subscribe(data => {
      if (data == null) {
        Swal.fire({
          title: 'Are you sure want to load page?',
          text: 'Your data has been deleted by someone else!',
          icon: 'error',
          showCancelButton: true,
          confirmButtonText: 'Yes, load page!',
          cancelButtonText: 'No, keep it'
        }).then((result) => {
          if (result.value) {
            this.reloadData(this.pagingArgs);
          }
        })
      } else {
        this.router.navigate(['book/update', id]);
      }
    },
    error => console.log(error))
  }

  searchBook(keywords: string) {
    this.router.navigate(['book/search'], {queryParams: {key: keywords}});
  }
  onChangeSearch() {
    fromEvent($("#searchInp"), "keyup")
        .pipe(
            map((event: any) => {
                return event.target.value;
            }),
            debounceTime(500),
            distinctUntilChanged()
        )
        .subscribe(
            (text: string) => {
                this.pagingArgs.query =text;
                this.reloadData(this.pagingArgs);
            },
            (err) => {
                console.log("error", err);
            }
        );
  }

  checkAllCheckBox(ev) {
		this.books.forEach(x => x.checked = ev.target.checked)
	}
  isAllCheckBoxChecked() {
		return this.books.every(b => b.checked);
	}
  deleteMultipleBooks() {
    const selectedBooks = this.books.filter(book => book.checked).map(b => b.id);
    console.log(selectedBooks);
    if(selectedBooks && selectedBooks.length > 0) {

      Swal.fire({
        title: 'Are you sure want to remove?',
        text: 'You will not be able to recover this books!',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Yes, delete it!',
        cancelButtonText: 'No, keep it'
      }).then((result) => {
        if (result.value) {
          this.bookService.deleteBooks(selectedBooks).subscribe(
            res => {
              console.log("Multiple books deleted!");
              this.reloadData(this.pagingArgs);
            },
            error => console.log(error)
          );
        }
      })
    } else{
      alert("You haven't select any books yet")
    }
  }

  sortBookes(prop) {
    if (this.pagingArgs.sortBy == prop) {
        if (this.pagingArgs.sortDirection == "desc") {
            this.pagingArgs.sortDirection = "asc";
        } else {
            this.pagingArgs.sortDirection = "desc";
        }
    }
    this.pagingArgs.sortBy = prop;
    this.reloadData(this.pagingArgs);
}
}
