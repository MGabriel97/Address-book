import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders,HttpErrorResponse  } from '@angular/common/http';
import { Observable} from 'rxjs';
import {  throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import {Contact} from '../shared/contact'
import { NgForm }   from '@angular/forms';

import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  public checkEdit:number=0;
  public searchInput: String = '';
  public searchResult: Array<any> = [];
  contacts:Array<Contact>=[];
  constructor( private http: HttpClient ) { }

  displayedColumns: string[] = ['name', 'address'];
  dataSource = this.contacts;

  ngOnInit(): void {
   
    this.getContacts().subscribe((data: Array<Contact>)=>{
      this.contacts=data;
      console.log(this.contacts);
     this.dataSource = this.contacts;

    })
  }

  onSubmit(form: NgForm): void{
    {
      this.contacts=new Array<Contact>();
        this.http.post<any>('http://localhost:8080/address/search',form.value).pipe(retry(1), catchError(this.handleError)).subscribe((data: Array<Contact>)=>{
          this.contacts=data;
          this.dataSource = this.contacts;

          console.log(this.contacts);
    })
    }
  }

  getContacts(): Observable<Contact[]> {
    return this.http.get<Contact[]>('http://localhost:8080/address/getall/').pipe(retry(1), catchError(this.handleError));
  }

  handleError(error: HttpErrorResponse) {
    let errorMessage = 'Unknown error!';
    if (error.error instanceof ErrorEvent) {
      errorMessage = `Error: ${error.error.message}`;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    window.alert(errorMessage);
    return throwError(errorMessage);
  }

  setStorage(element)
  {
    sessionStorage.setItem("id",element.id) ;
  }

}
