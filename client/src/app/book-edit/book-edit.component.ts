import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { BookService } from '../shared/book/book.service';
import { FormControl, FormGroupDirective, FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';

@Component({
  selector: 'app-book-edit',
  templateUrl: './book-edit.component.html',
  styleUrls: ['./book-edit.component.css']
})
export class BookEditComponent implements OnInit {

  bookForm: FormGroup;
  _id:string='';
  book_name:string='';
  book_price:number=null;
  book_type:string='';
  book_creationDate:Date=null;
  isLoadingResults = false;

  constructor(private router: Router, private route: ActivatedRoute, private bookService: BookService, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.getBook(this.route.snapshot.params['id']);
    this.bookForm = this.formBuilder.group({
      'book_name' : [null, Validators.required],
      'book_type' : [null, Validators.required],
      'book_price' : [null, Validators.required],
      'book_creationDate' : [null, Validators.required]
    });
  }

  getBook(id) {
    this.bookService.find(id).subscribe(data => {
      this._id = data.id;
      this.bookForm = this.formBuilder.group({
        book_name: data.name,
        book_type: data.type,
        book_price: data.price,
        book_creationDate: data.creationDate,
      });
    })
  }

  onFormSubmit(form:NgForm) {
    this.isLoadingResults = true;
    this.bookService.updateBook(this._id, form)
      .subscribe(res => {
          let id = res['_id'];
          this.isLoadingResults = false;
          this.router.navigate(['books']);
        }, (err) => {
          console.log(err);
          this.isLoadingResults = false;
        }
      );
  }

  bookDetails() {
    this.router.navigate(['/books']);
  }

}