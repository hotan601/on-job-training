import { Category } from "./category";

export class Book {
  id: number;
  name: string;
  author: string;
  publishedDate: Date;
  description: string;
  price: number;
  categoryCode: number;
  categoryName: string;
  quantity: number;
  checked?: boolean;
  category: Category;
}
