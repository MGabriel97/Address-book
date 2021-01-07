import { Contact } from '../shared/contact';
import { Component, OnInit } from '@angular/core';
import { Type,Input} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import { HttpClient, HttpHeaders,HttpErrorResponse  } from '@angular/common/http';
import { Observable} from 'rxjs';
import {  throwError } from 'rxjs';
import { retry, catchError } from 'rxjs/operators';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  image= '../../../assets/download.jpg';

  contact: Contact ;
  retrievedImage: any;
  selectedFile: File;


  constructor(
    private activatedroute: ActivatedRoute,private http: HttpClient

  ) { }

  ngOnInit(): void {
    this.activatedroute.params.subscribe((data) => {
      this.getContact(data.id).subscribe((data: Contact)=>{
        this.contact=data;
        if(this.contact.picture!=null)
          this.retrievedImage = 'data:image/jpeg;base64,' + this.contact.picture.image;
        else
          this.retrievedImage = this.image;

    })
    })
}

public onFileChanged(event) {
  //Select File
  this.selectedFile = event.target.files[0];
  this.changeImage();
}
changeImage()
  {
    
    //FormData API provides methods and properties to allow us easily prepare form data to be sent with POST HTTP requests.
    let body = new FormData();
    // Add file content to prepare the request
    body.append("image", this.selectedFile);
    
    //Make a call to the Spring Boot Application to save the image
    this.http.post('http://localhost:8080/addimage/'+this.contact.id, body)
    .subscribe(
      (data) => {console.log(data);      window.top.location.reload()},
      error => console.log(error),

      () => { console.log("completed") }
    );
  }
getContact(id:any): Observable<Contact> {
  return this.http.get<Contact>('http://localhost:8080/address/get/'+id).pipe(retry(1), catchError(this.handleError));
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

}
