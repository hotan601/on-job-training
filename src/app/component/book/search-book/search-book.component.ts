import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from 'src/app/dto/book';
import { BookService } from 'src/app/service/book.service';
import { Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged} from 'rxjs/operators';
import Swal from 'sweetalert2/dist/sweetalert2.js';
@Component({
  selector: 'app-search-book',
  templateUrl: './search-book.component.html',
  styleUrls: ['./search-book.component.css']
})
export class SearchBookComponent implements  OnInit {

  books: Book[] = [];
  keywords: string;
  searchTextChanged: Subject<string> = new Subject<string>();
  page = 1;
  limit = 6;// maximum item number on a page.
  totalItem = 0;//total record(row) of DB
  FILTER = /[^0-9]/g;
  @ViewChild('input', {static: false}) input: ElementRef;

  constructor(
    private bookService: BookService,
    private route: ActivatedRoute,
    private router: Router) {
  }

  ngOnInit(){
    this.keywords = this.route.snapshot.queryParamMap.get('key');
    console.log("key: " +this.keywords);

    this.searchTextChanged.pipe(
      debounceTime(500),
      distinctUntilChanged())
      .subscribe(d => this.search(d)
    )

    this.searchBook();
  }
  search(value: string) {
    this.bookService.searchBook(value).subscribe(
      data => {
        console.log(data);
        console.log("value: "+value);
        this.books = data;
        this.totalItem = data.length;
      },
      error => console.log(error)
    );
  }

  searchBook() {
    this.searchTextChanged.next(this.keywords);
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
        this.bookService.deleteBook(id).subscribe(
          res => {
            this.router.navigate(['/books']);
          },
        )
        Swal.fire(
          'Deleted!',
          'Your data has been deleted.',
          'success'
        )
      } else if (result.dismiss === Swal.DismissReason.cancel) {
        Swal.fire(
          'Cancelled',
          'Your data is safe :)',
          'error'
        )
      }
    })
  }
  // deleteBook(id: number) {
  //   this.bookService.deleteBook(id).subscribe(
  //     data => {
  //       console.log(data);
  //       this.router.navigate(['/books']);

  //     },
  //     error => console.log(error)
  //   );
  // }

  reloadData() {
    this.bookService.getListBooks().subscribe(
      data => {
        this.books = data;
      },
      error => console.log(error)
    )
  }

  bookDetails(id: number){
    this.router.navigate(['book/details', id]);
  }

  updateBook(id: number) {
    this.router.navigate(['book/update', id]);
  }

  selectPage(page: string) {
    this.page = parseInt(page) || 1;
  }
  formatInput(input: HTMLInputElement) {
    input.value = input.value.replace(this.FILTER, '');
  }
  change(event: any) {
    this.page = 1;
  }

  searchBook2() {
    this.router.navigate(['book/search'], {queryParams: {key: this.keywords}});
    console.log("search book 2")
    this.searchBook();
  }
  onKey(event: any) {
    if (event.key === 'Tab') {
      this.input.nativeElement.focus();
    }
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
              this.reloadData();
            },
            error => console.log(error)
          );

          Swal.fire(
            'Deleted!',
            'Your data has been deleted.',
            'success'
          )
        } else if (result.dismiss === Swal.DismissReason.cancel) {
          Swal.fire(
            'Cancelled',
            'Your data is safe :)',
            'error'
          )
        }
      })
    } else{
      alert("You haven't select any books yet");
    }
  }
}

