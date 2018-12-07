import { Component, OnInit } from '@angular/core';
import { BookService } from '../shared/book/book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
  displayedColumns: string[] = ['name', 'price', 'type', 'creationDate', 'action'];
  books: Array<any>;
  message: string;

  constructor(private bookService: BookService) { }

  ngOnInit() {
    this.bookService.getAll().subscribe(
      data =>{
        this.books = data;
      });
  }

  delete(element) {
    this.bookService.delete(element.id).subscribe(
      ()=> this.message = "Customer Deleted Successfully!");
  }

}
