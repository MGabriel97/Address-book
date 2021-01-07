import { Contact } from '../../shared/contact';
import { Component, OnInit } from '@angular/core';
import { Type,Input} from '@angular/core';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { HttpClient, HttpEventType,HttpErrorResponse } from '@angular/common/http';
import { NgForm }   from '@angular/forms';
import {  throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';
import { Router } from '@angular/router';

@Component({
  selector: 'app-modalconfirm-edit',
  templateUrl: './modalconfirm.component.html',
})
export class ModalEditComponentConfirm implements OnInit {

  @Input()
  contact: Contact ;

  id:number;
  name:String;
  address:String;
  constructor(public modal: NgbActiveModal,private http: HttpClient,private router: Router) {}
  onSubmit(form: NgForm): void{
    form.value.id=this.id;
    console.log(form.value);
    this.http.post<Contact>('http://localhost:8080/address/update',form.value).pipe(retry(1), catchError(this.handleError)).subscribe((data: Contact)=>{

      window.top.location.reload();
    });
    }
  delete(): void{
    this.http.delete<Contact>('http://localhost:8080/address/delete/'+this.id.toString()).pipe(retry(1), catchError(this.handleError)).subscribe((data: Contact)=>{
      this.router.navigate(['/search']);      

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
    this.id=this.contact.id;
    this.address=this.contact.address;
    this.name=this.contact.name;
  }
}

