import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from '../dto/category';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private httpClient: HttpClient) { }

  getListCategories(): Observable<Category[]> {
      return this.httpClient.get<Category[]>(environment.baseUrl +'category');
  }

  createCategory(category: Category): Observable<Category> {
    return this.httpClient.post<Category>(environment.baseUrl +'category', category);
  }

  getCategoryByName(name : String): Observable<any> {
    return this.httpClient.get<Category>(environment.baseUrl +'category/findByName/' +name);
  }

  getCategoryByCode(code : String): Observable<any> {
    return this.httpClient.get<Category>(environment.baseUrl +'category/findByCode/' +code);
  }

  getCategory(id: number): Observable<Category> {
    return this.httpClient.get<Category>(environment.baseUrl +'category/details/' +id);
  }

  updateCategory(id: number, category: Category): Observable<Category> {
    return this.httpClient.put<Category>(environment.baseUrl +'category/update/' +id, category);
}
}
