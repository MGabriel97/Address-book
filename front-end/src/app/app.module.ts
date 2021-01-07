import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ModalconfirmComponent} from'./search/addcontact/modalconfirm.component';
import { ModalComponent} from'./search/addcontact/modal.component';
import { ModalEditComponentConfirm} from'./search/editcontact/modalconfirm.component';
import { ModalEditComponent} from'./search/editcontact/modal.component';

import { SearchComponent } from './search/search.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import {MatSortModule} from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table'  
import {MatButtonModule} from '@angular/material/button';
import { ProfileComponent } from './profile/profile.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    SearchComponent,
    ModalconfirmComponent,
    ModalComponent,
    ModalEditComponent,
    ModalEditComponentConfirm,
    ProfileComponent
    ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    NoopAnimationsModule,
    MatSortModule,
    MatTableModule,
    MatButtonModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
