import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BookListComponent } from './book-list/book-list.component';
import { BookEditComponent } from './book-edit/book-edit.component';

const routes: Routes = [
  {
    path: 'books',
    component: BookListComponent,
    data: { title: 'List of Books' }
  },
  {
    path: 'book-edit/:id',
    component: BookEditComponent,
    data: { title: 'Book Edit' }
  },
  { path: '',
    redirectTo: '/books',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
