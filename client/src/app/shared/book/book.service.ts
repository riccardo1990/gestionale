import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders  } from '@angular/common/http';
import { Observable, of, throwError} from 'rxjs';
import { catchError, tap, map } from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({providedIn: 'root'})
export class BookService {
  books: any;

  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get('//localhost:8081/api/books');
  }

  delete(id: number) : Observable<any> {
    const url = `//localhost:8081/api/books/${id}`;
    return this.http.delete(url, httpOptions);
  }

  find(id: number) : Observable<any>{
    const url = `//localhost:8081/api/books/${id}`;
    return this.http.get(url, httpOptions);
  }

  updateBook (id, book): Observable<any> {
    const url = `//localhost:8081/api/books/`;

    return this.http.put(url, book, httpOptions).pipe(
      tap(_ => console.log(`updated book id=${id}`)),
      catchError(this.handleError<any>('updateBook'))
    );
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
