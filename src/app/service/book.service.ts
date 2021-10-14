import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../dto/book';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})


export class BookService {

  constructor(
    private httpClient: HttpClient) { }

  getBook(id: number): Observable<Book> {
    return this.httpClient.get<Book>(environment.baseUrl +'book/details/' +id);
  }

  getListBooks(): Observable<Book[]> {
      return this.httpClient.get<Book[]>(environment.baseUrl +'book');
  }

  createBook(book: Book): Observable<Book> {
      return this.httpClient.post<Book>(environment.baseUrl +'book', book);
  }

  updateBook(id: number, book: Book): Observable<Book> {
      return this.httpClient.put<Book>(environment.baseUrl +'book/update/' +id, book);
  }

  deleteBook(id: number): Observable<any> {
      return this.httpClient.delete(environment.baseUrl +'book/' +id);
  }


  searchBook(keywords: string): Observable<Book[]> {
    return this.httpClient.get<Book[]>(environment.baseUrl +'book/search?key=' +keywords);
  }

  getBookByName(name: String): Observable<any> {
    return this.httpClient.get<Book>(environment.baseUrl +'book/findByName/' +name);
  }
  // deleteBooks(ids: number[]): Observable<any> {
  //   return this.httpClient.delete(environment.baseUrl +'delete/books/' +ids);
  // }
  deleteBooks(ids: number[]): Observable<any> {
    return this.httpClient.post<number[]>(environment.baseUrl +'delete/books',ids);
  }


  getAll(data?): Observable<any> {
    return this.httpClient.get(environment.baseUrl +'book', {
        params: {
            query: data.query,
            pageSize: data.pageSize,
            pageNumber: data.pageNumber,
            sortBy: data.sortBy,
            sortDirection: data.sortDirection,
        },
    });
}

}

