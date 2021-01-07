import { Contact } from '../../shared/contact';
import { Component, OnInit } from '@angular/core';
import { Type} from '@angular/core';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { HttpClient, HttpEventType,HttpErrorResponse } from '@angular/common/http';
import { NgForm }   from '@angular/forms';
import {  throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
@Component({
  selector: 'app-modalconfirm',
  templateUrl: './modalconfirm.component.html',
})
export class ModalconfirmComponent implements OnInit {
  constructor(public modal: NgbActiveModal,private http: HttpClient) {}
  onSubmit(form: NgForm): void{
  
    this.http.post<Contact>('http://localhost:8080/address/add',form.value).pipe(retry(1), catchError(this.handleError)).subscribe((data: Contact)=>{

      window.top.location.reload();
    });
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

  ngOnInit(): void {
  }
}

